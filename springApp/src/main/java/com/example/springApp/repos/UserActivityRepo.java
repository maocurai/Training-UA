package com.example.springApp.repos;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityRepo extends JpaRepository<UserActivity, AdminConfirmationKey> {
}
