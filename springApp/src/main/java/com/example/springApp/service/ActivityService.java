package com.example.springApp.service;

import com.example.springApp.domain.Activity;
import com.example.springApp.repos.ActivityRepo;
import com.example.springApp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ActivityService {

    @Autowired
    private ActivityRepo activityRepo;

    public ActivityService(ActivityRepo activityRepo) {
        this.activityRepo = activityRepo;
    }

//    @Override
//    public Activity findByActivityname(String activityname) throws UsernameNotFoundException {
//        return activityRepo.findByActivityname(activityname);
//    }
}
