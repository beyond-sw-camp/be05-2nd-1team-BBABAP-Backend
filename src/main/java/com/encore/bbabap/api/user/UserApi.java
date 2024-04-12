package com.encore.bbabap.api.user;


import com.encore.bbabap.api.user.request.SignUpUserRequest;
import com.encore.bbabap.api.user.request.UserUpdateRequest;
import com.encore.bbabap.api.user.response.UserResponse;
import com.encore.bbabap.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "회원 ", description = "사용자가 회원 가입, 회원 수정 API")
public class UserApi {

    private final UserService userService;

    // 멤버 가입
    @PostMapping("/register")
    @Operation(summary = "회원 가입", description = "회원 가입하는 API")
    public ResponseEntity<String> signUp(@RequestBody SignUpUserRequest request) {
        UserResponse userResponse = userService.signUp(request);
        if (userResponse != null) {
            return ResponseEntity.ok("회원가입이 완료되었습니다. 로그인 페이지로 이동하세요.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입에 실패했습니다.");
        }
    }

    // 전체 멤버 조회
    @GetMapping()
    @Operation(summary = "회원 조회", description = "관리자가 회원 조회하는 API")
    public List<UserResponse> memberList() {
        return userService.findAll();
    }

    // 멤버 수정
    @PatchMapping("/{id}")
    @Operation(summary = "회원 수정", description = "회원 수정하는 API")
    public void updateMember(@PathVariable Long id,
                             @Validated @RequestBody UserUpdateRequest request) {
        userService.updateMember(id, request);
    }

    // 멤버 삭제
    @DeleteMapping("{id}")
    @Operation(summary = "회원 탈퇴", description = "관리자 또는 회원이 회원 탈퇴하는 API")
    public void deleteMember(@PathVariable Long id) {
        userService.deleteMemberById(id);
    }


}
