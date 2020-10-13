package com.project.thrifting.service;

import com.project.thrifting.models.Categories;
import com.project.thrifting.models.Genders;
import com.project.thrifting.models.Sale;
import com.project.thrifting.models.Sizes;
import com.project.thrifting.models.User;
import com.project.thrifting.models.repository.SaleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImplimentation implements SaleServiceInterface {

    @Autowired
    SaleRepository saleRepository;

    List<Sale> emptyList = new ArrayList<Sale>();

    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> getallsales() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> getSalesByGenderid(Genders gender) {
        return saleRepository.findByGenderid(gender).orElse(emptyList);
    }

    @Override
    public List<Sale> getSalesByCategoryid(Categories category) {
        return saleRepository.findByCategoryid(category).orElse(emptyList);
    }

    @Override
    public List<Sale> getSalesBySizeid(Sizes size) {
        return saleRepository.findBySizeid(size).orElse(emptyList);
    }

    @Override
    public List<Sale> getSaleByUserId(User user) {

        return saleRepository.findByUserid(user).orElse(emptyList);
    }

    @Override
    public void deleteSale(int saleid) {
        saleRepository.deleteById(saleid);
    }
    
    @Override
    public List<Sale> getSaleByPrice(Double price) {
        List<Sale> emptyList = new ArrayList<Sale>();
        return saleRepository.findByPriceLessThan(price).orElse(emptyList);
    }

}
