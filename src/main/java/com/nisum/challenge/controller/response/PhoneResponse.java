package com.nisum.challenge.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhoneResponse {
    private Long id;
    private String number;
    private String cityCode;
    private String countryCode;
}
