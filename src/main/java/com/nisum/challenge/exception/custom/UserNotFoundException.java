package com.nisum.challenge.exception.custom;

import com.nisum.challenge.exception.ChallengeAbstractException;
import com.nisum.challenge.exception.ChallengeEnumException;

public class UserNotFoundException extends ChallengeAbstractException {

    public UserNotFoundException() {
        super(ChallengeEnumException.USER_NOT_FOUND.message);
    }
}
