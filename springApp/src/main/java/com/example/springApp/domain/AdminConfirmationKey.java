package com.example.springApp.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AdminConfirmationKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "activity_id")
    private Long activityId;

    public Long getUserId() {
        return userId;
    }

    public AdminConfirmationKey() {}

    public AdminConfirmationKey(Long userId, Long activityId) {
        this.userId = userId;
        this.activityId = activityId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }


}