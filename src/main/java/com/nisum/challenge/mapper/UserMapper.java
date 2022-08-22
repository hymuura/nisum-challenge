package com.nisum.challenge.mapper;

import com.nisum.challenge.controller.request.PhoneRequest;
import com.nisum.challenge.controller.request.UserRequest;
import com.nisum.challenge.controller.response.UserResponse;
import com.nisum.challenge.entity.Phone;
import com.nisum.challenge.entity.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static User toEntity(UserRequest request, String token) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .token(token)
                .phones(request.getPhones().stream()
                        .map(UserMapper::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    public static UserResponse toResponse(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .created(entity.getCreated().toString())
                .modified(entity.getModified().toString())
                .lastLogin(entity.getLastLogin().toString())
                .isActive(entity.getIsActive())
                .token(entity.getToken())
                .build();
    }


    private static Phone toEntity(PhoneRequest request) {
        return Phone.builder()
                .number(request.getNumber())
                .countryCode(request.getCountryCode())
                .cityCode(request.getCityCode())
                .build();
    }
}
