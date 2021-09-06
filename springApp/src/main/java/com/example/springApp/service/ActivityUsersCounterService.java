package com.example.springApp.service;

import com.example.springApp.repos.ActivityUsersCounter;
import com.example.springApp.repos.ActivityUsersCounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ActivityUsersCounterService {

    private final ActivityUsersCounterRepo activityUsersCounterRepo;

    public ActivityUsersCounterService(ActivityUsersCounterRepo activityUsersCounterRepo) {
        this.activityUsersCounterRepo = activityUsersCounterRepo;
    }

    public List<ActivityUsersCounter> countActivityUsersAndOrderBy(String sortField) {
        return activityUsersCounterRepo.countActivityUsersAndOrderBy(sortField);
    }

    public List<ActivityUsersCounter> countActivityUsersByCategoryName(String categoryName) {
<<<<<<< HEAD
        return (categoryName.equals("NULL")) ?
                activityUsersCounterRepo.countActivityUsersWhereCategoryIsNull() :
                activityUsersCounterRepo.countActivityUsersByCategoryName(categoryName);
=======
        return activityUsersCounterRepo.countActivityUsersByCategoryName(categoryName);
>>>>>>> d2f05cf94c8f4164a55c4a226b1b661c79ecfd1c
    }

    public String changeSortingDirection(String currentOrderDirection) {
        return currentOrderDirection.equals("ASC") ? "DESC" : "ASC";
    }

    public List setOrderDirection(List list, String orderDirection) {
        if (!orderDirection.equals("ASC")) Collections.reverse(list);
        return list;
    }
}
