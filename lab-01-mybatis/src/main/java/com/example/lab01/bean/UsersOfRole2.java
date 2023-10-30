package com.example.lab01.bean;

import java.util.List;

public class UsersOfRole2 {
    int roleId;
    String name;
    List<SystemUser> users;

    public UsersOfRole2() {
    }

    public UsersOfRole2(int roleId, String name, List<SystemUser> users) {
        this.roleId = roleId;
        this.name = name;
        this.users = users;
    }
}
