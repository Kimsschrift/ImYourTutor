<template>
  <div class="app-layout">
    <!-- 글로벌 헤더 -->
    <header class="global-header" v-if="!isLoginPage">
      <div class="header-content">
        <div class="logo-container">
          <img 
            src="../assets/Logo.png" 
            alt="ImYourTutor Logo" 
            class="header-logo"
            @click="goToHome"
          />
          <span class="app-name" @click="goToHome">ImYourTutor</span>
        </div>
        
        <!-- 사용자 정보 영역 -->
        <div class="user-section" v-if="authStore.isAuthenticated">
          <span class="user-name">{{ authStore.user?.name }}님</span>
          <button 
            @click="handleLogout" 
            class="logout-btn btn btn-secondary"
          >
            로그아웃
          </button>
        </div>
      </div>
    </header>

    <!-- 메인 콘텐츠 영역 -->
    <main class="main-content" :class="{ 'with-header': !isLoginPage }">
      <slot />
    </main>
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { useAuthStore } from '../stores/auth';

const route = useRoute();
const router = useRouter();
const authStore = useAuthStore();

// 로그인 페이지에서는 헤더 숨김
const isLoginPage = computed(() => route.name === 'Login');

const goToHome = () => {
  if (authStore.isAuthenticated) {
    router.push('/dashboard');
  }
};

const handleLogout = async () => {
  await authStore.logout();
  router.push('/login');
};
</script>

<style scoped>
.app-layout {
  min-height: 100vh;
  background-color: var(--background-gray);
}

.global-header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  height: 64px;
  background-color: var(--white);
  border-bottom: 1px solid var(--border-color);
  box-shadow: 0 1px 3px var(--shadow-light);
  z-index: 1000;
}

.header-content {
  height: 100%;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 12px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.logo-container {
  display: flex;
  align-items: center;
  gap: 12px;
  cursor: pointer;
  transition: opacity 0.2s ease;
}

.logo-container:hover {
  opacity: 0.8;
}

.header-logo {
  height: 32px;
  width: auto;
}

.app-name {
  font-size: 20px;
  font-weight: 600;
  color: var(--primary-blue);
  font-family: 'Google Sans', 'Roboto', Arial, sans-serif;
}

.user-section {
  display: flex;
  align-items: center;
  gap: 16px;
}

.user-name {
  font-size: 14px;
  color: var(--text-secondary);
  font-weight: 500;
}

.logout-btn {
  padding: 6px 12px;
  font-size: 13px;
  border-radius: 6px;
}

.main-content {
  width: 100%;
  min-height: 100vh;
}

.main-content.with-header {
  padding-top: 64px; /* 헤더 높이만큼 패딩 추가 */
}

@media (max-width: 768px) {
  .header-content {
    padding: 0 8px;
  }
  
  .app-name {
    font-size: 18px;
  }
  
  .header-logo {
    height: 28px;
  }
  
  .user-name {
    display: none; /* 모바일에서는 사용자 이름 숨김 */
  }
}
</style>