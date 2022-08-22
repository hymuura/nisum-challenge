package com.nisum.challenge.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class PhoneRequest {
    @NotEmpty
    private String number;
    @NotEmpty
    private String cityCode;
    @NotEmpty
    private String countryCode;
}
