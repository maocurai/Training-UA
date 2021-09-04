package com.example.springApp.repos;

import com.example.springApp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByCategoryname(String categoryname);
    List<Category> findAll();
}
