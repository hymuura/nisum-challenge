package com.nisum.challenge.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UserRequest {
    @NotEmpty
    private String name;
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = ".*[0-9].*", message = "The password field needs to contain at least 1 number")
    private String password;
    private List<PhoneRequest> phones;
}
