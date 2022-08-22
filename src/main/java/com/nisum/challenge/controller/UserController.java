package com.nisum.challenge.controller;

import com.nisum.challenge.controller.request.UserRequest;
import com.nisum.challenge.controller.response.UserResponse;
import com.nisum.challenge.facade.UserFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserFacade facade;

    public UserController(UserFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestAttribute(value = "token") String token, @Valid @RequestBody UserRequest request) {
        return facade.create(request, token);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable("id") Long id) {
        return facade.findById(id);
    }
}
