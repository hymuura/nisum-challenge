package com.nisum.challenge.exception.custom;

import com.nisum.challenge.exception.ChallengeAbstractException;
import com.nisum.challenge.exception.ChallengeEnumException;

public class InvalidJWTException extends ChallengeAbstractException {

    public InvalidJWTException() {
        super(ChallengeEnumException.INVALID_JWT.message);
    }
}
