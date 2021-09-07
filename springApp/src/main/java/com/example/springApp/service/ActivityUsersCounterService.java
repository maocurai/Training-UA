package com.example.springApp.service;

import com.example.springApp.repos.ActivityUsersCounter;
import com.example.springApp.repos.ActivityUsersCounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ActivityUsersCounterService {

    private final ActivityUsersCounterRepo activityUsersCounterRepo;

    public ActivityUsersCounterService(ActivityUsersCounterRepo activityUsersCounterRepo) {
        this.activityUsersCounterRepo = activityUsersCounterRepo;
    }

    public Page<ActivityUsersCounter> countActivityUsers(Pageable pageable) {
        return activityUsersCounterRepo.countActivityUsers(pageable);
    }

    public Page<ActivityUsersCounter> countActivityUsersByCategoryName(String categoryName, Pageable pageable) {
        return (categoryName.equals("NULL")) ?
                activityUsersCounterRepo.countActivityUsersWhereCategoryIsNull(pageable) :
                activityUsersCounterRepo.countActivityUsersByCategoryName(categoryName, pageable);
    }

    public String changeSortingDirection(String currentOrderDirection) {
        return currentOrderDirection.equals("ASC") ? "DESC" : "ASC";
    }

    public Sort setSort(String orderField, String currentDirection) {
        return currentDirection.equals("ASC") ? Sort.by(orderField).descending() : Sort.by(orderField).ascending();
    }
}
