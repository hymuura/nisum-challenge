package com.nisum.challenge.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class ChallengeAbstractException extends RuntimeException {
    private final String message;
}
