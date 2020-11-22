package com.project.thrifting.models.controllers;

import com.project.thrifting.Dto.DtoUser;
import com.project.thrifting.Dto.EditDto;
import com.project.thrifting.Dto.JwtResponse;
import com.project.thrifting.Dto.LoginRequest;
import com.project.thrifting.Dto.MessageResponse;
import com.project.thrifting.Dto.SignUpDto;
import com.project.thrifting.models.ERole;
import com.project.thrifting.models.Role;
import com.project.thrifting.models.User;
import com.project.thrifting.security.jwt.JwtUtils;
import com.project.thrifting.service.RoleServiceInterface;
import com.project.thrifting.service.UserServiceInterface;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/welcome")
public class UserController {

    @Value("${images.upload.dir}")
    public String uploadDir;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleServiceInterface roleServiceInterface;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpDto signupdto) throws IOException {

        if (userServiceInterface.existsByUsername(signupdto.getUsername())) {

            return ResponseEntity
                    .badRequest()
                    .body(new Error("Oops !! Username is already taken!!"));
        }

        if (userServiceInterface.existsByEmail(signupdto.getEmail())) {

            return ResponseEntity
                    .badRequest()
                    .body((new MessageResponse("Oops !!  Email is already in use!!")));
        }

        //Create new User account
        User user = new User();

        user.setFirstName(signupdto.getFirstName());

        user.setLastName(signupdto.getLastName());

        user.setUsername(signupdto.getUsername());

        user.setEmail(signupdto.getEmail());

        user.setPassword(encoder.encode(signupdto.getPassword()));

        user.setTelephone(signupdto.getTelephone());

        user.setCountry(signupdto.getCountry());

        user.setRegion(signupdto.getRegion());

        user.setAddress(signupdto.getAddress());

        user.setZip(signupdto.getZip());

        user.setUserlatitude(signupdto.getUserslatitude());

        user.setUserlongitude(signupdto.getUserslongitude());

        //setting the roles
        List<Role> userroles = user.getRoles();
        if (userroles.isEmpty()) {
            Role userRole = roleServiceInterface.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            userroles.add(userRole);
        }
        user.setRoles(userroles);

        //saving the photo
        BufferedImage image = null;
        byte[] decodedBytes = Base64.getMimeDecoder().decode(signupdto.getPhotoBase64().split(",")[1]);

        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
        image = ImageIO.read(bis);
        System.out.println("image" + image);
        if (image == null) {
            return ResponseEntity
                    .badRequest()
                    .body((new MessageResponse("jpeg or png!!")));
        }
        bis.close();
        //creating a new random name for the photo
        Random r = new Random();

        String extension = StringUtils.getFilenameExtension(signupdto.getPhotoname());

        String newPhotoName = "profileImg" + signupdto.getUsername() + r.nextInt() + "." + extension;

        File outputfile = new File(uploadDir + newPhotoName);

        ImageIO.write(image, "png", outputfile);

        user.setPhotoUrl(newPhotoName);

        userServiceInterface.insertUser(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }

    @PostMapping("/getUser")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public User getUser(@RequestBody DtoUser dtoUser) {

        Long id = dtoUser.getId();
        return userServiceInterface.findbyid(id);
    }

    @PostMapping("/edituser")
    @PreAuthorize("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editUser(@Valid @RequestBody EditDto editdto) throws IOException {

        //get the user from id 
        User user = userServiceInterface.findbyid(editdto.getUserid());

        //check if user entered new password
        if (!editdto.getPassword().isEmpty()) {

            //hash new password
            user.setPassword(encoder.encode(editdto.getPassword()));
        }

        user.setFirstName(editdto.getFirstName());

        user.setLastName(editdto.getLastName());

        //check if user entered new username
        if (!user.getUsername().equals(editdto.getUsername())) {

            if (userServiceInterface.existsByUsername(editdto.getUsername())) {

                return ResponseEntity
                        .badRequest()
                        .body(new Error("Oops !! Username is already taken!!"));
            }

        }
        user.setUsername(editdto.getUsername());

        user.setEmail(editdto.getEmail());

        user.setTelephone(editdto.getTelephone());

        user.setCountry(editdto.getCountry());

        user.setRegion(editdto.getRegion());

        user.setAddress(editdto.getAddress());

        user.setZip(editdto.getZip());

        if (editdto.getPhotoBase64() != null) {

            //saving the photo
            BufferedImage image = null;
            byte[] decodedBytes = Base64.getMimeDecoder().decode(editdto.getPhotoBase64().split(",")[1]);

            ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
            image = ImageIO.read(bis);
            bis.close();
            //creating a new random name for the photo
            Random r = new Random();

            String extension = StringUtils.getFilenameExtension(editdto.getPhotoname());

            String newPhotoName = "profileImg" + editdto.getUsername() + r.nextInt() + "." + extension;

            File outputfile = new File(uploadDir + newPhotoName);

            ImageIO.write(image, "png", outputfile);

            user.setPhotoUrl(newPhotoName);

        }

//        
        userServiceInterface.insertUser(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

    }

}
