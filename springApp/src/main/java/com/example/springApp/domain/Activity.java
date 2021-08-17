package com.example.springApp.domain;

import javax.persistence.*;

@Entity
@Table(name = "actvt")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String activityname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    private Integer usersCounter = 0;

    public Activity() {}

    public Activity(String activityname, Category category) {
        this.activityname = activityname;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getUsersCounter() {
        return usersCounter;
    }

    public void setUsersCounter(Integer usersCounter) {
        this.usersCounter = usersCounter;
    }

    public void increaseCounter() {
        this.usersCounter++;
    }

    public void decreaseCounter() {
        this.usersCounter--;
    }

}
