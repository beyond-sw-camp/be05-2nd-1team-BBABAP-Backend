package com.encore.bbabap.api.user.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {

    private final String email;
    private final String nickname;
//    private final CarType carType;

    @Builder
    public UserResponse(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
//        this.carType = carType;
    }

//    public static MemberResponse of(Member savedMember) {
//        return new MemberResponse(savedMember.getEmail(), savedMember.getNickname(),
//                savedMember.getCarType());
//    }
}
