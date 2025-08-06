package com.imyourtutor.backend.repository;

import com.imyourtutor.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Google ID로 사용자 찾기
    Optional<UserEntity> findByGoogleId(String googleId);

    // 이메일로 사용자 찾기
    Optional<UserEntity> findByEmail(String email);

    // Google ID 존재 여부 확인
    boolean existsByGoogleId(String googleId);

    // 이메일 존재 여부 확인
    boolean existsByEmail(String email);
}