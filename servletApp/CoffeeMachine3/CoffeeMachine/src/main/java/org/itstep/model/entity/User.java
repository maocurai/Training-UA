package org.itstep.model.entity;

public class User {

    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
