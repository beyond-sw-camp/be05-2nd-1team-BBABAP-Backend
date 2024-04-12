package com.encore.bbabap.api.user.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class SignUpUserRequest {

    @Email
    private String email;

    private String password;

    private String nickname;

//    private CarType carType;


}
