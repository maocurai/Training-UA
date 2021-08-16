package com.example.springApp.repos;

import com.example.springApp.domain.Activity;
import com.example.springApp.domain.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity, Long> {

    @Query( value = "SELECT * FROM actvt WHERE category_id = ?1",
            nativeQuery = true)
    List<Activity> findByCategoryId(Long id);
    List<Activity> findAll(Sort sort);
    List<Activity> findAll();
    Activity findByActivityname(String activityname);
    Activity findByid(Long id);
}
