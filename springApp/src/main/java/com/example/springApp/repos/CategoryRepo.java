package com.example.springApp.repos;

import com.example.springApp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByCategoryname(String categoryname);
    List<Category> findAll();
}
