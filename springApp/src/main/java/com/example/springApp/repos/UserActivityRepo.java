package com.example.springApp.repos;

import com.example.springApp.domain.AdminConfirmationKey;
import com.example.springApp.domain.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserActivityRepo extends JpaRepository<UserActivity, AdminConfirmationKey> {
    UserActivity findByid(AdminConfirmationKey id);
    List<UserActivity> findByuserId(Long id);
    List<UserActivity> findByStatusNotIn(Collection collection);
}
