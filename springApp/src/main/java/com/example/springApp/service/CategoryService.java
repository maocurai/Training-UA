package com.example.springApp.service;

import com.example.springApp.domain.Activity;
import com.example.springApp.domain.Category;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;
    private final ActivityService activityService;

    public CategoryService(CategoryRepo categoryRepo, ActivityService activityService) {
        this.categoryRepo = categoryRepo;
        this.activityService = activityService;
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
<<<<<<< HEAD
        List<Activity> byCategoryId = activityService.findByCategoryId(category.getId());
        for(Activity activity: byCategoryId) {
            activity.setCategory(null);
            activityService.save(activity);
        }
=======
>>>>>>> d2f05cf94c8f4164a55c4a226b1b661c79ecfd1c
        categoryRepo.delete(category);
    }
}