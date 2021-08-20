package com.example.springApp.service;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.Status;
import com.example.springApp.domain.User;
import com.example.springApp.domain.UserActivity;
import com.example.springApp.repos.UserActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserActivityService {

    private final UserActivityRepo userActivityRepo;

    public UserActivityService(UserActivityRepo userActivityRepo) {
        this.userActivityRepo = userActivityRepo;
    }

    public UserActivity findById(AdminConfirmationKey id) {
        return userActivityRepo.findByid(id);
    }

    public List<UserActivity> findByUserId(Long id) {
        return userActivityRepo.findByuserId(id);
    }

    public List<UserActivity> findByStatusNotIn(Collection collection) {
        return userActivityRepo.findByStatusNotIn(collection);
    }

    public List<UserActivity> findAll() {
        return userActivityRepo.findAll();
    }

    public void save(UserActivity userActivity) {
        userActivityRepo.save(userActivity);
    }

    public void delete(UserActivity userActivity) {
        userActivityRepo.delete(userActivity);
    }

    public void doActionDueToStatus(UserActivity userActivity, Status status) {
        switch (status) {
            case ADD_REQUEST: userActivityRepo.save(userActivity); break;
            case DELETE_REQUEST: userActivityRepo.delete(userActivity);
        }
    }
}
