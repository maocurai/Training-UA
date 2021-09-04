package com.example.springApp.repos;

import org.springframework.stereotype.Repository;

@Repository
public interface ActivityUsersCounter {
    Long getActivityId();
    String getActivityName();
    String getCategoryName();
    Integer getCountUsers();
}
