package com.example.springApp.domain;

import javax.persistence.*;

@Entity
public class UserActivity {

    @EmbeddedId
    private AdminConfirmationKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("activityId")
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Enumerated(EnumType.STRING)
    private Status status;

    public UserActivity() {}

    public UserActivity(User user, Activity activity, Status status) {
        this.id = new AdminConfirmationKey(user.getId(), activity.getId());
        this.user = user;
        this.activity = activity;
        this.status = status;
    }

    public boolean isConfirmed() {
        return this.status.equals(Status.CONFIRMED);
    }

    public boolean isDenied() {
        return this.status.equals(Status.DENIED);
    }

    public AdminConfirmationKey getId() {
        return id;
    }

    public void setId(AdminConfirmationKey id) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
