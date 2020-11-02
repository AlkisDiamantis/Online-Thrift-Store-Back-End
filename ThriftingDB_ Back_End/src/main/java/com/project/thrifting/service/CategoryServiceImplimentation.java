package com.project.thrifting.service;

import com.project.thrifting.models.Categories;
import com.project.thrifting.models.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplimentation implements CategoryServiceInterface {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Categories> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Categories findCategorybyid(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: category is not found."));
    }

}
