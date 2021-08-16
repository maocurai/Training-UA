package com.example.springApp.repos;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.UserActivityTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityTimeRepo extends JpaRepository<UserActivityTime, AdminConfirmationKey> {
}
