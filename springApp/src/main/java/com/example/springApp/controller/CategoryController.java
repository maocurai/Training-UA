package com.example.springApp.controller;

import com.example.springApp.domain.Category;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        try {
            categoryRepo.save(category);
            model.put("addCategoryResult", "Category successfully added");
        } catch (Exception ex) {
            model.put("addCategoryResult", "Category already exists");
        }
        return "redirect:/adminCategory";
    }
}
