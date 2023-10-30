package com.example.lab01.bean;

import java.util.List;

public class UsersOfRole4 {
    SystemRole role;
    List<SystemUser> users;

    public UsersOfRole4() {
    }



    public SystemRole getRole() {
        return role;
    }

    public void setRole(SystemRole role) {
        this.role = role;
    }

    public List<SystemUser> getUsers() {
        return users;
    }

    public void setUsers(List<SystemUser> users) {
        this.users = users;
    }
}
