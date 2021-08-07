package com.example.springApp.controller;

import com.example.springApp.domain.Category;
import com.example.springApp.domain.Role;
import com.example.springApp.domain.User;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/adminCategory")
//@PreAuthorize("hasAuthority('ADMIN')")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminCategory";
    }

    @PostMapping
    public String addCategory(Map<String, Object> model, Category category) {
        if(!isCategoryNameTaken(category.getCategoryname())) {
            categoryRepo.save(category);
            model.put("addCategoryResult", "Category successfully added");
        } else {
            model.put("addCategoryResult", "Category already exists");
        }
        return "redirect:/adminCategory";
    }

    public boolean isCategoryNameTaken(String categoryname) {
        return categoryRepo.findAll()
                .stream()
                .anyMatch(category->category.getCategoryname().equals(categoryname));
    }
}
