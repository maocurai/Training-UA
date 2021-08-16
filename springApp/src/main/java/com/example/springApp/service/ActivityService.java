package com.example.springApp.service;

import com.example.springApp.domain.Activity;
import com.example.springApp.repos.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepo activityRepo;

    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

    public List<Activity> findByCategoryId(Long id) {
        return activityRepo.findByCategoryId(id);
    }

    public List<Activity> findByUserIdNotUsersActivities(Long id) {
        return activityRepo.findByUserIdNot(id);
    }

    public Activity findById(Long id) {
        return activityRepo.findByid(id);
    }

    public List<Activity> findAllAndSort(Sort sort) {
        return activityRepo.findAll(sort);
    }

    public List<Activity> findAll() {
        return activityRepo.findAll();
    }

    public Activity findByName(String activityname) {
        return activityRepo.findByActivityname(activityname);
    }

    public void save(Activity activity) {
        activityRepo.save(activity);
    }
}
