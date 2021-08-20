package com.example.springApp.repos;

import com.example.springApp.domain.Activity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepo extends JpaRepository<Activity, Long> {

    @Query( value = "SELECT * FROM actvt WHERE category_id = ?1",
            nativeQuery = true)
    List<Activity> findByCategoryId(Long id);

    @Query(
            value = "SELECT a.id, a.activityname, a.category_id FROM actvt a LEFT JOIN user_activity ua on a.id = ua.activity_id\n" +
                    "WHERE ua.user_id != ?1 OR (ua.user_id IS NULL)\n" +
                    "group by a.id",
            nativeQuery = true
    )
    List<Activity> findByUserIdNot(Long id);

    Activity findByid(Long id);

    List<Activity> findAll(Sort sort);

    List<Activity> findAll();

    Activity findByActivityname(String activityname);
}
