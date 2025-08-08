<template>
  <div class="login-container">
    <div class="login-card card">
      <div class="logo-section">
        <h1 class="app-title">ImYourTutor</h1>
        <p class="app-subtitle">
          개인 맞춤형 학습 플랫폼에 오신 것을 환영합니다
        </p>
      </div>

      <div class="login-section">
        <h2 class="login-title">로그인</h2>
        <p class="login-description">Google 계정으로 간편하게 로그인하세요</p>

        <button
          @click="handleGoogleLogin"
          class="google-login-btn btn"
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
          <span class="btn-text">Google로 로그인</span>
        </button>
      </div>

      <div class="footer-section">
        <p class="terms-text">
          로그인하면 <a href="#" class="terms-link">서비스 이용약관</a>과
          <a href="#" class="terms-link">개인정보처리방침</a>에 동의하는 것으로
          간주됩니다.
        </p>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { useAuthStore } from "../stores/auth";

const authStore = useAuthStore();
const isLoading = ref(false);

const handleGoogleLogin = () => {
  isLoading.value = true;
  authStore.login();
};
</script>

<style scoped>
.login-container {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  padding: 20px;
}

.login-card {
  width: 100%;
  max-width: 450px;
  text-align: center;
}

.logo-section {
  margin-bottom: 40px;
}

.app-title {
  font-size: 32px;
  font-weight: 700;
  color: #2c3e50;
  margin-bottom: 8px;
  background: linear-gradient(135deg, #667eea, #764ba2);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.app-subtitle {
  font-size: 16px;
  color: #6c757d;
  line-height: 1.5;
}

.login-section {
  margin-bottom: 32px;
}

.login-title {
  font-size: 24px;
  font-weight: 600;
  color: #2c3e50;
  margin-bottom: 8px;
}

.login-description {
  font-size: 14px;
  color: #6c757d;
  margin-bottom: 32px;
}

.google-login-btn {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
  background-color: white;
  border: 2px solid #e0e0e0;
  color: #333;
  font-weight: 500;
  transition: all 0.3s ease;
  position: relative;
}

.google-login-btn:hover {
  border-color: #4285f4;
  box-shadow: 0 4px 12px rgba(66, 133, 244, 0.15);
  transform: translateY(-1px);
}

.google-login-btn:disabled {
  opacity: 0.6;
  cursor: not-allowed;
  transform: none;
}

.google-icon {
  flex-shrink: 0;
}

.btn-text {
  font-size: 16px;
}

.footer-section {
  border-top: 1px solid #e9ecef;
  padding-top: 24px;
}

.terms-text {
  font-size: 12px;
  color: #6c757d;
  line-height: 1.5;
}

.terms-link {
  color: #4285f4;
  text-decoration: none;
}

.terms-link:hover {
  text-decoration: underline;
}

@media (max-width: 480px) {
  .login-card {
    margin: 20px;
    padding: 24px;
  }

  .app-title {
    font-size: 28px;
  }

  .login-title {
    font-size: 20px;
  }
}
</style>
