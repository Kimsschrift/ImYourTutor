package com.imyourtutor.backend.service;

import com.imyourtutor.backend.dto.GoogleUserInfoDTO;
import com.imyourtutor.backend.dto.UserResponseDTO;
import com.imyourtutor.backend.entity.UserEntity;
import com.imyourtutor.backend.entity.UserRole;
import com.imyourtutor.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor // 이 어노테이션은 final 필드나 **@NonNull**이 붙은 필드를 초기화하는 생성자를 자동으로 생성
@Transactional // 한 메서드에서 여러 테이블에 데이터를 저장하다가 중간에 에러가 발생하면, @Transactional이 붙어있을 경우 처음 상태로 모든 변경 사항을 되돌립니다(Rollback).
public class UserService {

    private final UserRepository userRepository;

    // Google 로그인한 사용자를 처리
    public UserResponseDTO processGoogleUser(GoogleUserInfoDTO googleUserInfo) {
        Optional<UserEntity> existingUser = userRepository.findByGoogleId(googleUserInfo.getId());
        
        UserEntity user;
        if (existingUser.isPresent()) {
            user = existingUser.get();
            updateUserInfo(user, googleUserInfo);
        } else {
            user = createNewUser(googleUserInfo);
        }

        return convertToDTO(user);
    }

    // ------ 회원가입 처리 ------

    // 신규 회원가입
    private UserEntity createNewUser(GoogleUserInfoDTO googleUserInfo) {
        UserEntity newUser = UserEntity.builder()
                .googleId(googleUserInfo.getId())
                .email(googleUserInfo.getEmail())
                .name(googleUserInfo.getName())
                .profileImageUrl(googleUserInfo.getPicture())
                .role(UserRole.USER)
                .build();

        return userRepository.save(newUser);
    }

    // 기존 사용자 정보 업데이트
    private void updateUserInfo(UserEntity user, GoogleUserInfoDTO googleUserInfo) {
        user.setName(googleUserInfo.getName());
        user.setProfileImageUrl(googleUserInfo.getPicture());
        
        userRepository.save(user);
    }

    // 변환 메서드
    public UserResponseDTO convertToDTO(UserEntity user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .googleId(user.getGoogleId())
                .email(user.getEmail())
                .name(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    // Optional: 값이 존재할 수도 있고 존재하지 않을 수도 있는 객체를 표현하는 컨테이너 역할
    // NullPointerException 방지 기능

    // 이 메서드들에서 @Transactional쓰는 이유 readyOnly가 true인 것을 알게 하여 dirty checking을 방지하여 성능 향상

    @Transactional(readOnly = true)
    public Optional<UserResponseDTO> findByGoogleId(String googleId) {
        return userRepository.findByGoogleId(googleId)
                .map(this::convertToDTO);
    }

    @Transactional(readOnly = true)
    public Optional<UserResponseDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(this::convertToDTO);
    }

    @Transactional(readOnly = true)
    public boolean existsByGoogleId(String googleId) {
        return userRepository.existsByGoogleId(googleId);
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}