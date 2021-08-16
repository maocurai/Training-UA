package com.example.springApp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserActivityTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private AdminConfirmationKey userAndActivityId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("activityId")
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column(name = "start_time", columnDefinition = "DATETIME")
    private LocalDateTime startTime;

    @Column(name = "end_time", columnDefinition = "DATETIME")
    private LocalDateTime endTime;

    public UserActivityTime() {}

    public UserActivityTime(AdminConfirmationKey userAndActivityId, User user, Activity activity, LocalDateTime startTime, LocalDateTime endTime) {
        this.userAndActivityId = userAndActivityId;
        this.user = user;
        this.activity = activity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public AdminConfirmationKey getUserAndActivityId() {
        return userAndActivityId;
    }

    public void setUserAndActivityId(AdminConfirmationKey userAndActivityId) {
        this.userAndActivityId = userAndActivityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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
