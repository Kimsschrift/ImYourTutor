package com.imyourtutor.backend.dto;

import com.imyourtutor.backend.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// 사용자 정보를 Frontend에 보낼 때 사용하는 클래스
public class UserResponseDTO {

    private Long id;
    private String googleId;
    private String email;
    private String name;
    private String profileImageUrl;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}