package com.example.lab01;

import com.example.lab01.bean.*;
import com.example.lab01.mapper.SystemUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SystemUserTest {

    @Autowired
    private SystemUserMapper userMapper;

    @Test
    public void systemUserTest(){
        final List<SystemUser> users = userMapper.selectAllUser();

        final UsersOfRole usersOfRole = userMapper.selectUsersOfRole(0);
        final UsersOfRole2 usersOfRole2 = userMapper.selectUsersOfRole2(0);
        final UsersOfRole3 usersOfRole3 = userMapper.selectUsersOfRole3(0);
        final UsersOfRole4 usersOfRole4 = userMapper.selectUsersOfRole4(0);
        final UsersOfRole5 usersOfRole5 = userMapper.selectUsersOfRole5(0);
        int a  = 1;
    }

}
