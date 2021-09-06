package com.example.springApp.service;

import com.example.springApp.repos.ActivityUsersCounter;
import com.example.springApp.repos.ActivityUsersCounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ActivityUsersCounterService {

    private final ActivityUsersCounterRepo activityUsersCounterRepo;

    public ActivityUsersCounterService(ActivityUsersCounterRepo activityUsersCounterRepo) {
        this.activityUsersCounterRepo = activityUsersCounterRepo;
    }

    public Page<ActivityUsersCounter> countActivityUsersAndOrderBy(String sortField, Pageable pageable) {
        return activityUsersCounterRepo.countActivityUsersAndOrderBy(sortField, pageable);
    }

    public Page<ActivityUsersCounter> countActivityUsersByCategoryName(String categoryName, Pageable pageable) {
        return (categoryName.equals("NULL")) ?
                activityUsersCounterRepo.countActivityUsersWhereCategoryIsNull(pageable) :
                activityUsersCounterRepo.countActivityUsersByCategoryName(categoryName, pageable);
    }

    public String changeSortingDirection(String currentOrderDirection) {
        return currentOrderDirection.equals("ASC") ? "DESC" : "ASC";
    }

    public List setOrderDirection(List list, String currentOrderDirection) {
        if (!currentOrderDirection.equals("ASC")) Collections.reverse(list);
        return list;
    }
}
