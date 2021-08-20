package com.example.springApp.service;

import com.example.springApp.domain.Category;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Category loadCategoryByCategoryname(String categoryname) {
        return categoryRepo.findByCategoryname(categoryname);
    }

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public void delete(Category category) {
        categoryRepo.save(category);
    }
}