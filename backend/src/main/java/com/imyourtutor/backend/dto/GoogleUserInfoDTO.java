package com.imyourtutor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Google에서 받아온 사용자 정보를 담는 클래스
public class GoogleUserInfoDTO {

    private String id;
    private String email;
    private String name;
    private String picture;
}