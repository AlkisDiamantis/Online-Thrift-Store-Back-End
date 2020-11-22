package com.project.thrifting.models.controllers;

import com.project.thrifting.Dto.SaleDto;
import com.project.thrifting.models.Categories;
import com.project.thrifting.models.Conditions;
import com.project.thrifting.models.Genders;
import com.project.thrifting.models.Sale;
import com.project.thrifting.models.Sizes;
import com.project.thrifting.models.User;
import com.project.thrifting.service.CategoryServiceInterface;
import com.project.thrifting.service.ConditionsServiceInterface;
import com.project.thrifting.service.GenderServiceInterface;
import com.project.thrifting.service.SaleServiceInterface;
import com.project.thrifting.service.SizeServiceInterface;
import com.project.thrifting.service.UserServiceInterface;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/welcome")
public class SaleController {

    @Value("${images.upload.dir}")
    public String uploadDir;

    @Autowired
    ConditionsServiceInterface conditionsServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    CategoryServiceInterface categoryServiceInterface;

    @Autowired
    GenderServiceInterface genderServiceInterface;

    @Autowired
    SizeServiceInterface sizeServiceInterface;

    @Autowired
    SaleServiceInterface saleServiceInterface;

    @PostMapping("/insertsale")
    @PreAuthorize("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    public String insertsale(@Valid @RequestBody SaleDto sale) throws IOException {

        int condid = sale.getCondid();

        Conditions condition = conditionsServiceInterface.findbyid(condid);

        Long userid = sale.getUserid();

        User user = userServiceInterface.findbyid(userid);

        int categoryid = sale.getCategoryid();

        Categories category = categoryServiceInterface.findCategorybyid(categoryid);

        int genderid = sale.getGenderid();

        Genders gender = genderServiceInterface.findGenderbyId(genderid);

        int sizeid = sale.getSizeid();

        Sizes size = sizeServiceInterface.getSizebyId(sizeid);

        String title = sale.getTitle();

        Double price = sale.getPrice();

        String comment = sale.getComment();

        String startdate = sale.getDatestart();

        BufferedImage image = null;
        byte[] decodedBytes = Base64.getMimeDecoder().decode(sale.getPhotoBase64().split(",")[1]);

        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
        image = ImageIO.read(bis);
        bis.close();

        String extension = StringUtils.getFilenameExtension(sale.getPhotoname());

        Random r = new Random();

        String newPhotoName = "SaleImgUserid" + sale.getUserid() + r.nextInt() + "." + extension;

        File outputfile = new File(uploadDir + newPhotoName);

        ImageIO.write(image, "png", outputfile);

        String photoUrl = newPhotoName;

        // user.setPhotoUrl(sale.getPhotoname());
        Sale mysale = new Sale(title, comment, startdate, price, category, condition, gender, size, user, photoUrl);

        saleServiceInterface.saveSale(mysale);

        return "ok";
    }

    @GetMapping("/getsales")
    public List<Sale> getallsales() {

        return saleServiceInterface.getallsales();
    }

    @GetMapping("/getsalebygender/{genderid}")
    public List<Sale> getallsalebygender(@PathVariable int genderid) {

        Genders mygender = genderServiceInterface.findGenderbyId(genderid);

        return saleServiceInterface.getSalesByGenderid(mygender);
    }

    @GetMapping("/getsalebycategory/{categoryrid}")
    public List<Sale> getSaleByCategoryMethod(@PathVariable int categoryrid) {

        Categories mycategory = categoryServiceInterface.findCategorybyid(categoryrid);

        return saleServiceInterface.getSalesByCategoryid(mycategory);
    }

    @GetMapping("/getsalebysize/{sizeid}")
    public List<Sale> getSaleBySizeMethod(@PathVariable int sizeid) {

        Sizes mysize = sizeServiceInterface.getSizebyId(sizeid);

        return saleServiceInterface.getSalesBySizeid(mysize);
    }

    @GetMapping("/getsalebyuserid/{userid}")
    public List<Sale> getSaleByUserIdMethod(@PathVariable Long userid) {

        User user = userServiceInterface.findbyid(userid);

        return saleServiceInterface.getSaleByUserId(user);
    }

    @GetMapping("/deletesale/{saleid}")
    public void deletesale(@PathVariable int saleid) {
        saleServiceInterface.deleteSale(saleid);

    }

    @GetMapping("/getsalebyprice/{price}")
    public List<Sale> getallsalebyprice(@PathVariable Double price) {

        return saleServiceInterface.getSaleByPrice(price);
    }

}
