package com.example.springApp.repos;

import com.example.springApp.domain.Activity;
import com.example.springApp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Activity findByCategoryname(String categoryname);
}
