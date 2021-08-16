package com.example.springApp.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class UserActivityTime {

    @EmbeddedId
    private AdminConfirmationKey id;

    @Column(name = "start_time", columnDefinition = "DATETIME")
    private LocalDateTime startTime;

    @Column(name = "end_time", columnDefinition = "DATETIME")
    private LocalDateTime endTime;

    public UserActivityTime() {}

    public UserActivityTime(AdminConfirmationKey id, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public AdminConfirmationKey getId() {
        return id;
    }

    public void setId(AdminConfirmationKey id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
