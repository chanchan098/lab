package com.example.lab01.bean;

import java.util.List;

public class UsersOfRole3 {
    int id;
    String name;
    List<SystemUser> users;

    public UsersOfRole3() {
    }

    public UsersOfRole3(int id, String name, List<SystemUser> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
}
