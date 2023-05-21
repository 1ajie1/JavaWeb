package com.tuleaj.service.impl;

import com.tuleaj.dao.UserMapper;
import com.tuleaj.domain.User;
import com.tuleaj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int selectUser(User user) {
        return userMapper.selectUser(user);
    }
}
