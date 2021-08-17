package com.example.springApp.service;

import com.example.springApp.domain.UserActivityTime;
import com.example.springApp.repos.UserActivityTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityTimeService {

    @Autowired
    private UserActivityTimeRepo userActivityTimeRepo;

    public List<UserActivityTime> findByUserId(Long id) {
        return userActivityTimeRepo.findByuserId(id);
    }

    public void save(UserActivityTime userActivityTime) {
        userActivityTimeRepo.save(userActivityTime);
    }

    public List<UserActivityTime> findAll() {
        return userActivityTimeRepo.findAll();
    }
}
