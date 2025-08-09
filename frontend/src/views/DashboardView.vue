<template>
  <div class="dashboard-container">
    <main class="dashboard-main">
      <div class="container">
        <div class="dashboard-content">
          <div class="welcome-section">
            <div class="card">
              <h2 class="section-title">대시보드</h2>
              <p class="section-description">
                개인 맞춤형 학습을 시작해보세요. 다양한 학습 도구와 기능들이
                준비되어 있습니다.
              </p>
            </div>
          </div>

          <div class="features-grid">
            <div class="feature-card card">
              <div class="feature-icon">
                <svg width="48" height="48" fill="#4285f4" viewBox="0 0 24 24">
                  <path
                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z"
                  />
                </svg>
              </div>
              <h3 class="feature-title">학습 진도 관리</h3>
              <p class="feature-description">
                체계적인 학습 계획을 세우고 진도를 추적하세요.
              </p>
              <button class="feature-btn btn btn-primary">시작하기</button>
            </div>

            <div class="feature-card card">
              <div class="feature-icon">
                <svg width="48" height="48" fill="#34a853" viewBox="0 0 24 24">
                  <path
                    d="M19 3H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm-5 14H7v-2h7v2zm3-4H7v-2h10v2zm0-4H7V7h10v2z"
                  />
                </svg>
              </div>
              <h3 class="feature-title">학습 자료</h3>
              <p class="feature-description">
                다양한 주제별 학습 자료와 연습 문제를 제공합니다.
              </p>
              <button class="feature-btn btn btn-primary">둘러보기</button>
            </div>

            <div class="feature-card card">
              <div class="feature-icon">
                <svg width="48" height="48" fill="#fbbc05" viewBox="0 0 24 24">
                  <path
                    d="M16 6l2.29 2.29-4.88 4.88-4-4L2 16.59 3.41 18l6-6 4 4 6.3-6.29L22 12V6z"
                  />
                </svg>
              </div>
              <h3 class="feature-title">성과 분석</h3>
              <p class="feature-description">
                학습 성과를 시각화하고 개선점을 찾아보세요.
              </p>
              <button class="feature-btn btn btn-primary">분석 보기</button>
            </div>

            <div class="feature-card card">
              <div class="feature-icon">
                <svg width="48" height="48" fill="#ea4335" viewBox="0 0 24 24">
                  <path
                    d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm3.5 6L12 10.5 8.5 8 12 5.5 15.5 8zM8.5 16L12 13.5 15.5 16 12 18.5 8.5 16z"
                  />
                </svg>
              </div>
              <h3 class="feature-title">개인 튜터</h3>
              <p class="feature-description">
                AI 튜터와 함께 맞춤형 학습을 진행하세요.
              </p>
              <button class="feature-btn btn btn-primary">대화하기</button>
            </div>
          </div>

          <div class="stats-section">
            <div class="card">
              <h3 class="section-title">학습 통계</h3>
              <div class="stats-grid">
                <div class="stat-item">
                  <div class="stat-value">0</div>
                  <div class="stat-label">완료한 학습</div>
                </div>
                <div class="stat-item">
                  <div class="stat-value">0</div>
                  <div class="stat-label">학습 시간</div>
                </div>
                <div class="stat-item">
                  <div class="stat-value">0%</div>
                  <div class="stat-label">진도율</div>
                </div>
                <div class="stat-item">
                  <div class="stat-value">0</div>
                  <div class="stat-label">연속 학습일</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { useAuthStore } from "../stores/auth";
import { useRouter } from "vue-router";

const authStore = useAuthStore();
const router = useRouter();

const handleLogout = async () => {
  await authStore.logout();
  router.push("/login");
};
</script>

<style scoped>
.dashboard-container {
  min-height: 100vh;
  background-color: var(--background-gray);
}


.dashboard-main {
  padding: 32px 0;
}

.dashboard-content {
  max-width: 1200px;
  margin: 0 auto;
}

.welcome-section {
  margin-bottom: 32px;
}

.section-title {
  font-size: 28px;
  font-weight: 600;
  color: var(--text-primary);
  margin-bottom: 8px;
}

.section-description {
  font-size: 16px;
  color: var(--text-secondary);
  line-height: 1.6;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 24px;
  margin-bottom: 32px;
}

.feature-card {
  text-align: center;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.feature-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
}

.feature-icon {
  margin-bottom: 16px;
}

.feature-title {
  font-size: 20px;
  font-weight: 600;
  color: var(--text-primary);
  margin-bottom: 12px;
}

.feature-description {
  font-size: 14px;
  color: var(--text-secondary);
  line-height: 1.5;
  margin-bottom: 20px;
}

.feature-btn {
  width: 100%;
  max-width: 200px;
}

.stats-section {
  margin-top: 32px;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 24px;
  margin-top: 24px;
}

.stat-item {
  text-align: center;
  padding: 20px;
  background-color: var(--light-gray);
  border-radius: 8px;
}

.stat-value {
  font-size: 32px;
  font-weight: 700;
  color: var(--primary-blue);
  margin-bottom: 4px;
}

.stat-label {
  font-size: 14px;
  color: var(--text-secondary);
  font-weight: 500;
}

@media (max-width: 768px) {
  .features-grid {
    grid-template-columns: 1fr;
  }

  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 480px) {
  .stats-grid {
    grid-template-columns: 1fr;
  }
}
</style>
