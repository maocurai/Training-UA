package com.example.springApp.repos;

import com.example.springApp.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity, Long> {
    Activity findByActivityname(String activityname);
}
