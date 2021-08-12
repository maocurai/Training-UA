package com.example.springApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AdminConfirmationKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "activity_id")
    private Long activityId;

    public Long getUserId() {
        return userId;
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

    public AdminConfirmationKey() { }

    public AdminConfirmationKey(Long userId, Long activityId) {
        this.userId = userId;
        this.activityId = activityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminConfirmationKey)) return false;
        AdminConfirmationKey that = (AdminConfirmationKey) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, activityId);
    }
}