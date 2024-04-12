package com.encore.bbabap.user;

public class UserEmailDuplicateException extends RuntimeException {

    public UserEmailDuplicateException(String message) {
        super(message);
    }

}
