package com.nisum.challenge.service;

import com.nisum.challenge.entity.User;

public interface UserService {
    User create(User user);
    User findById(Long id);
}

