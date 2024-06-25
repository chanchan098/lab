package com.example.lab01.mapper;

import com.example.lab01.bean.*;

import java.util.List;


public interface SystemUserMapper {
    List<SystemUser> selectAllUser();
    List<SystemRole> selectUsersByRole(int roleId);
    UsersOfRole selectUsersOfRole(int roleId);
    UsersOfRole2 selectUsersOfRole2(int roleId);
    UsersOfRole3 selectUsersOfRole3(int roleId);
    UsersOfRole4 selectUsersOfRole4(int roleId);
    UsersOfRole5 selectUsersOfRole5(int roleId);
}