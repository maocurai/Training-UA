package org.itstep.model.entity;

import javax.persistence.criteria.CriteriaBuilder;

public class User {

    private Integer id;
    private String username;
    private String password;
    private boolean active;

    private Role role;

    public boolean isAdmin() {
        return role.equals(Role.ADMIN);
    }

    public String getRoleAsString() {
        return role.toString();
    }

    public String getRole() {
        return role.toString();
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
