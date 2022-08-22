package com.nisum.challenge.service.impl;

import com.nisum.challenge.entity.User;
import com.nisum.challenge.exception.custom.UserInvalidEmailException;
import com.nisum.challenge.exception.custom.UserNotFoundException;
import com.nisum.challenge.repository.UserRepository;
import com.nisum.challenge.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        if (this.repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserInvalidEmailException();
        }

        return repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

}
