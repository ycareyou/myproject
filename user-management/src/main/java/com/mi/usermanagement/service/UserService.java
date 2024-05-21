package com.mi.usermanagement.service;

import com.mi.usermanagement.model.User;

public interface UserService {
    User findByUserName(String userName);
    void register(User user);
    User login(User user);
}
