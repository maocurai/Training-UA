package com.example.springApp.repos;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.UserActivity;
import com.example.springApp.domain.UserActivityTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActivityTimeRepo extends JpaRepository<UserActivityTime, AdminConfirmationKey> {
    List<UserActivityTime> findByuserId(Long id);
}
