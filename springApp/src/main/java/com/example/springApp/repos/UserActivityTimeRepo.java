package com.example.springApp.repos;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.UserActivityTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityTimeRepo extends JpaRepository<UserActivityTime, AdminConfirmationKey> {
    List<UserActivityTime> findByuserId(Long id);
}
