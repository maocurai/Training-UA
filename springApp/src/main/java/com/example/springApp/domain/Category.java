package com.example.springApp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ctgr")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String categoryname;

    @ManyToMany(mappedBy = "categoriesOfactivities")
    private Set<Activity> activities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
