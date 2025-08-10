<template>
  <!-- 전체 화면 중앙에 로그인 박스 위치 시키기 위한 역할 login-container -->
  <div class="login-container">
    <!-- 교육 테마 애니메이션 배경 -->
    <div class="education-illustration">
      <svg class="floating-books" viewBox="0 0 200 100">
        <g class="book" v-for="(book, index) in books" :key="index">
          <rect
            :x="book.x"
            :y="book.y"
            width="15"
            height="20"
            :fill="book.color"
            rx="2"
            class="floating"
          />
        </g>
      </svg>
    </div>

    <!-- 실제로 사용자에게 보이는 로그인 박스 login-wrapper -->
    <div class="login-wrapper">
      <div class="logo-section">
        <div class="logo-container" @click="goToHome">
          <img src="@/assets/Logo.png" alt="ImYourTutor" class="logo-image" />
          <h1 class="app-title">ImYourTutor</h1>
        </div>
        <p class="app-subtitle">AI 기반 개인 맞춤형 학습 플랫폼</p>
      </div>

      <div class="login-section">
        <h2>로그인</h2>
        <p class="login-description">Google 계정으로 간편하게 시작하세요</p>

        <!-- 오류 메시지 표시 -->
        <div v-if="errorMessage" class="error-message">
          {{ errorMessage }}
        </div>

        <button
          @click="handleGoogleLogin"
          class="google-login-btn"
          :disabled="isLoading"
        >
          <div v-if="isLoading" class="loading-spinner"></div>
          <svg
            v-else
            class="google-icon"
            viewBox="0 0 24 24"
            width="20"
            height="20"
          >
            <path
              fill="#4285F4"
              d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z"
            />
            <path
              fill="#34A853"
              d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z"
            />
            <path
              fill="#FBBC05"
              d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z"
            />
            <path
              fill="#EA4335"
              d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z"
            />
          </svg>
          <span>Google로 로그인</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from "vue";
import { useAuthStore } from "../stores/auth";
import { useRoute, useRouter } from "vue-router";

// ref는 변수가 변경될 때 화면을 자동으로 업데이트 해주는 역할 반응형 변수 (reactive variables)
const authStore = useAuthStore();
const route = useRoute();
const router = useRouter();
const isLoading = ref(false);
const errorMessage = ref("");

// 교육 테마 애니메이션을 위한 책 데이터
const books = ref([
  { x: 20, y: 30, color: "#4285F4" },
  { x: 50, y: 45, color: "#34A853" },
  { x: 80, y: 25, color: "#FBBC05" },
  { x: 110, y: 40, color: "#EA4335" },
  { x: 140, y: 35, color: "#9C27B0" },
  { x: 170, y: 50, color: "#FF9800" },
]);

// OAuth 오류 처리
onMounted(() => {
  const error = route.query.error;
  if (error === "oauth") {
    errorMessage.value =
      "Google 로그인 중 오류가 발생했습니다. 다시 시도해주세요.";
    // URL에서 error 파라미터 제거 (깔끔하게)
    const url = new URL(window.location.href);
    url.searchParams.delete("error");
    window.history.replaceState({}, "", url.pathname);
  }
});

const handleGoogleLogin = () => {
  isLoading.value = true;
  errorMessage.value = ""; // 오류 메시지 초기화
  // Google OAuth 페이지로 리다이렉트
  // 성공하면 백엔드에서 바로 /dashboard로 리다이렉트됨
  authStore.login();
};

const goToHome = () => {
  router.push('/');
};
</script>

<style scoped>
body {
  background: linear-gradient(to bottom, #e0f7fa, #ffffff);
}

.login-container {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: var(--background-gray);
  padding: 20px;
}

.login-wrapper {
  width: 100%;
  max-width: 440px;
  padding: 48px;
  box-sizing: border-box;
  background-color: var(--white);
  border-radius: 12px;
  box-shadow: 0 2px 10px var(--shadow-medium);
  border: 1px solid var(--border-color);
  text-align: center;
}

.logo-section {
  margin-bottom: 40px;
}

.logo-container {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
  cursor: pointer;
  transition: transform 0.3s ease;
  margin-bottom: 8px;
}

.logo-container:hover {
  transform: scale(1.05);
}

.logo-image {
  height: 96px;
  width: auto;
}

.app-title {
  font-size: 28px;
  font-weight: 600;
  color: var(--primary-blue);
  margin: 0;
  font-family: "Google Sans", "Roboto", Arial, sans-serif;
}

.app-subtitle {
  font-size: 14px;
  color: var(--text-secondary);
  margin-bottom: 0;
}

.login-section {
  margin-bottom: 24px;
}

.login-section > h2 {
  font-size: 24px;
  color: var(--text-primary);
  margin-bottom: 8px;
  font-weight: 400;
}

.login-description {
  font-size: 14px;
  color: var(--text-secondary);
  margin-bottom: 24px;
}

.error-message {
  background-color: #fef7f7;
  border: 1px solid #f5c6c6;
  border-radius: 8px;
  color: #d93025;
  padding: 12px 16px;
  margin-bottom: 24px;
  font-size: 14px;
  text-align: center;
  animation: fadeIn 0.3s ease-in;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.google-login-btn {
  width: 100%;
  height: 48px;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
  background-color: var(--white);
  border: 1px solid var(--border-color);
  border-radius: 8px;
  color: var(--text-primary);
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s ease;
  font-family: "Google Sans", "Roboto", Arial, sans-serif;
}

.google-login-btn:hover {
  background-color: var(--light-gray);
  border-color: var(--medium-gray);
  box-shadow: 0 1px 3px var(--shadow-light);
}

.google-login-btn:disabled {
  opacity: 0.6;
  cursor: not-allowed;
  transform: none;
}

.google-icon {
  flex-shrink: 0;
}

.loading-spinner {
  width: 20px;
  height: 20px;
  border: 2px solid var(--medium-gray);
  border-top: 2px solid var(--primary-blue);
  border-radius: 50%;
  animation: spin 1s linear infinite;
}

@keyframes spin {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

.education-illustration {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
  opacity: 0.3;
  z-index: 1;
}

.floating-books {
  width: 100%;
  height: 100%;
}

.floating {
  animation: float 3s ease-in-out infinite;
}

.book:nth-child(1) .floating {
  animation-delay: 0s;
}
.book:nth-child(2) .floating {
  animation-delay: 0.5s;
}
.book:nth-child(3) .floating {
  animation-delay: 1s;
}
.book:nth-child(4) .floating {
  animation-delay: 1.5s;
}
.book:nth-child(5) .floating {
  animation-delay: 2s;
}
.book:nth-child(6) .floating {
  animation-delay: 2.5s;
}

@keyframes float {
  0%,
  100% {
    transform: translateY(0px);
  }
  50% {
    transform: translateY(-10px);
  }
}

.login-wrapper {
  position: relative;
  z-index: 2;
}

@media (max-width: 480px) {
  .login-wrapper {
    margin: 20px;
    padding: 32px 24px;
  }

  .app-title {
    font-size: 24px;
  }
}
</style>
