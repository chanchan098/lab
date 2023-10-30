package com.example.lab01.bean;

import java.util.List;

public class UsersOfRole5 {
    int roleId;
    SystemRole role;
    List<SystemUser> users;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
