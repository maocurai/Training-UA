package com.example.springApp.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actvt")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String activityname;

    private boolean isConfirmedByAdmin;


    @ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "activity_category",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categoriesOfactivities;

    @ManyToMany(mappedBy = "userActivitiesSet")
    private Set<User> activityUsersSet;

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

    public Set<Category> getCategoriesOfactivities() {
        return categoriesOfactivities;
    }

    public void setCategoriesOfactivities(Set<Category> categoriesOfactivities) {
        this.categoriesOfactivities = categoriesOfactivities;
    }

    public boolean isConfirmedByAdmin() {
        return isConfirmedByAdmin;
    }

    public void setConfirmedByAdmin(boolean confirmedByAdmin) {
        isConfirmedByAdmin = confirmedByAdmin;
    }

    public Set<User> getActivityUsersSet() {
        return activityUsersSet;
    }

    public void setActivityUsersSet(Set<User> activityUsersSet) {
        this.activityUsersSet = activityUsersSet;
    }
}
