package com.encore.bbabap.domain.user;


import com.encore.bbabap.api.user.request.UserUpdateRequest;
import com.encore.bbabap.domain.enums.CarType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickname;
    @Enumerated(value = EnumType.STRING)
    private CarType carType;
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private Boolean deletedYn;
    private String role;

//    @OneToOne(mappedBy = "writer")
//    private Board board;

    @Builder
    public User(String email, String password, String nickname, CarType carType,
                LocalDateTime registeredAt, LocalDateTime updatedAt, Boolean deletedYn, String role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.carType = carType;
        this.registeredAt = LocalDateTime.now();
        this.updatedAt = null;
        this.deletedYn = false;
        this.role = "ROLE_USER";
        // TODO : 기본 회원가입은 USER로 설정하고 필요시 MANAGER, ADMIN 레벨 만들어서 특정 요청에 의해서 권한을 주는 게 어떤지(의논 필요)
    }

    public void updateMemberDetail(UserUpdateRequest request, String encodedPassword) {
        this.nickname = request.getNickname();
        this.password = encodedPassword;
//        this.carType = request.getCarType();
        this.updatedAt = LocalDateTime.now();
    }

    public void deleteUser() {
        this.deletedYn = true;
    }


//    public Member(String email, String password, String nickname, CarType carType) {
//        this.email = email;
//        this.password = password;
//        this.nickname = nickname;
//        this.carType = carType;
//        this.registeredAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//        this.deletedYn = false;
//    }
//
//    public static Member createMember(SignUpMemberRequest request) {
//        return new Member(request.getEmail(), request.getPassword(), request.getNickname(),
//                request.getCarType());
//    }


}


