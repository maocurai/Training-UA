package com.example.springApp.domain;

import javax.persistence.*;

@Entity
@Table(name = "actvt")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String activityname;
    private String password;
    private boolean active;
}
