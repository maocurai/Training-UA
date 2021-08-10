package com.example.springApp.controller;

import com.example.springApp.domain.Category;
import com.example.springApp.domain.Role;
import com.example.springApp.domain.User;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
//@RequestMapping("/adminCategory")
//@PreAuthorize("hasAuthority('ADMIN')")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/adminCategory")
    public String categoryList(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "adminCategory";
    }

    @GetMapping("/adminCategory/{category}")
    public String userEditForm(@PathVariable Category category, Model model) {
        model.addAttribute("category", category);
        return "categoryEdit";
    }

    @PostMapping("/adminCategory/edit")
    public String editCategory(Map<String, Object> model,
                               @RequestParam String categoryname,
                               @RequestParam("categoryId") Category category) {
        category.setCategoryname(categoryname);
        addCategory(model, category);
        return "redirect:/adminCategory";
    }

    @PostMapping("/adminCategory/add")
    public String addCategory(Map<String, Object> model,
                              Category category) {
        try {
            categoryRepo.save(category);
            model.put("addCategoryResult", "Category successfully added");
        } catch (Exception ex) {
            model.put("addCategoryResult", "Category already exists");
        }
        return "redirect:/adminCategory";
    }

    @PostMapping("/adminCategory/delete")
    public String deleteCategory(Map<String, Object> model,
                              Category category) {
        try {
            categoryRepo.delete(categoryRepo.findByCategoryname(category.getCategoryname()));
            model.put("addCategoryResult", "Category successfully added");
        } catch (Exception ex) {
            model.put("addCategoryResult", "Category already exists");
        }
        return "redirect:/adminCategory";
    }
}
