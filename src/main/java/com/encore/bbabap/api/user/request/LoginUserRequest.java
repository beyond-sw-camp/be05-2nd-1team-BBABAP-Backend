package com.encore.bbabap.api.user.request;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserRequest {

    @Email
    private  String email;

    private  String password;

//    @Builder
//    public LoginUserRequest(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
}
