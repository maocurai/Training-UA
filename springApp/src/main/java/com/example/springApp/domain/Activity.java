package com.example.springApp.domain;

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


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "activity_category",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categoriesOfactivities;

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
}
