package com.nisum.challenge.exception;

public enum ChallengeEnumException {

    USER_NOT_FOUND("User not found"),
    USER_INVALID_EMAIL("The email has already taken"),
    INVALID_JWT("The jwt token is invalid");

    public final String message;

    ChallengeEnumException(String message) {
        this.message = message;
    }
}


