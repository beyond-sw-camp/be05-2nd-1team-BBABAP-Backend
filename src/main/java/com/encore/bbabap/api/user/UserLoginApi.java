package com.encore.bbabap.api.user;


import com.encore.bbabap.api.user.request.LoginUserRequest;
import com.encore.bbabap.service.user.CustomUserDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Tag(name = "로그인 ", description = "사용자가 회원 가입, 회원 수정 API")
@RequiredArgsConstructor
public class UserLoginApi {

    private final CustomUserDetailService customUserDetailService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login"; // 로그인 페이지의 HTML 파일명 또는 경로를 반환
    }

    // POST 메서드는 그대로 유지
    @PostMapping("/api/login")
    public String login(@RequestBody LoginUserRequest request) {

        return request.getPassword();
    }
}
