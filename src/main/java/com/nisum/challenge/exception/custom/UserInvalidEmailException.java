package com.nisum.challenge.exception.custom;

import com.nisum.challenge.exception.ChallengeAbstractException;
import com.nisum.challenge.exception.ChallengeEnumException;

public class UserInvalidEmailException extends ChallengeAbstractException {

    public UserInvalidEmailException() {
        super(ChallengeEnumException.USER_INVALID_EMAIL.message);
    }
}
