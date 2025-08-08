package com.imyourtutor.backend.controller;

import com.imyourtutor.backend.dto.GoogleUserInfoDTO;
import com.imyourtutor.backend.dto.UserResponseDTO;
import com.imyourtutor.backend.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // Google 로그인 완료 후 콜백 처리
    @PostMapping("/login/oauth2/code/google")
    public ResponseEntity<UserResponseDTO> googleLoginCallback(
            // @AuthenticationPrincipal 어노테이션은 현재 인증된 사용자(Principal)의 정보를 메서드 파라미터로 직접 주입받는 역할
            // oauth2User: 구글로부터 받은 사용자의 실제 로그인 정보를 담고 있는 객체 (일회성)
            // session: 사용자의 로그인 정보를 서버에 저장하기 위한 객체
            // oauth2User가 원본 데이터라면, session은 그 데이터를 서버에 보관하는 역할을 합니다.
            // oauth2User는 로그인 과정 자체에 필요한 데이터이고, session은 로그인 상태를 유지하기 위한 데이터
            @AuthenticationPrincipal OAuth2User oauth2User,
            HttpSession session) {

        if (oauth2User == null) {
            // return ResponseEntity.unauthorized().build();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Map<String, Object> attributes = oauth2User.getAttributes();
        
        GoogleUserInfoDTO googleUserInfo = GoogleUserInfoDTO.builder()
                .id((String) attributes.get("sub"))
                .email((String) attributes.get("email"))
                .name((String) attributes.get("name"))
                .picture((String) attributes.get("picture"))
                .build();

        UserResponseDTO user = userService.processGoogleUser(googleUserInfo);

        // UserResponseDTO 객체(user)를 session에 "user"라는 이름으로 저장
        // 사용자가 다음에 다른 페이지를 요청할 때, 서버는 세션에 저장된 이 정보를 꺼내서 "이 사용자는 이미 로그인된 상태"임을 확인
        session.setAttribute("user", user);

        // UserResponseDTO 형태로 클라이언트(프론트엔드)에 반환
        return ResponseEntity.ok(user);
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponseDTO> getCurrentUser(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("user");
        
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getMe(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("user");
        
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
        return ResponseEntity.ok(user);
    }

    @GetMapping("/check")
    public ResponseEntity<Map<String, Object>> checkAuthStatus(HttpSession session) {
        UserResponseDTO user = (UserResponseDTO) session.getAttribute("user");
        boolean isAuthenticated = user != null;
        
        return ResponseEntity.ok(Map.of(
                "authenticated", isAuthenticated,
                "user", isAuthenticated ? user : null
        ));
    }
}