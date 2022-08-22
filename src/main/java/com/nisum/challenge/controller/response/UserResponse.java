package com.nisum.challenge.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String created;
    private String modified;
    private String lastLogin;
    private Boolean isActive;
    private String token;
}
