package com.nisum.challenge.facade;

import com.nisum.challenge.controller.request.UserRequest;
import com.nisum.challenge.controller.response.UserResponse;
import com.nisum.challenge.mapper.UserMapper;
import com.nisum.challenge.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    private UserService service;

    public UserFacade(UserService service) {
        this.service = service;
    }

    public UserResponse create(UserRequest request, String token) {
        return UserMapper.toResponse(service.create(UserMapper.toEntity(request, token)));
    }

    public UserResponse findById(Long id) {
        return UserMapper.toResponse(service.findById(id));
    }
}
