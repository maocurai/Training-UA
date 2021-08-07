package com.example.springApp.service;

import com.example.springApp.domain.Category;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Transactional
    public Category loadCategoryByCategoryname(String categoryname) throws UsernameNotFoundException {
        return categoryRepo.findByCategoryname(categoryname);
    }
}