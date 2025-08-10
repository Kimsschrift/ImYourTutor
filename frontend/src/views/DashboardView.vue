<template>
  <div class="dashboard-container">
    <!-- 배경 요소들 -->
    <div class="background-elements">
      <div class="bg-gradient-1"></div>
      <div class="bg-gradient-2"></div>
      <div class="floating-shapes">
        <div class="shape shape-1"></div>
        <div class="shape shape-2"></div>
        <div class="shape shape-3"></div>
      </div>
    </div>

    <main class="dashboard-main">
      <div class="container">
        <div class="dashboard-content">
          <!-- 웰컴 헤더 섹션 -->
          <div class="welcome-header">
            <div class="welcome-content">
              <div class="welcome-badge">
                <svg class="badge-icon" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-9.293a1 1 0 00-1.414-1.414L9 10.586 7.707 9.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l4-4z" clip-rule="evenodd" />
                </svg>
                <span>학습 대시보드</span>
              </div>
              <h1 class="welcome-title">안녕하세요! 👋</h1>
              <h2 class="welcome-subtitle">오늘도 <span class="highlight">새로운 학습</span>을 시작해볼까요?</h2>
              <p class="welcome-description">
                AI 기반 개인 맞춤형 학습으로 효과적인 공부를 경험하세요. PDF 업로드부터 문제 생성까지 모든 과정이 자동화되어 있습니다.
              </p>
              
              <!-- 퀵 액션 버튼들 -->
              <div class="quick-actions">
                <button class="btn-quick-primary" @click="startLearning">
                  <svg class="btn-icon" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                  </svg>
                  <span>학습 시작하기</span>
                </button>
                <button class="btn-quick-secondary" @click="uploadPDF">
                  <svg class="btn-icon" viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M3 17a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM6.293 6.707a1 1 0 010-1.414l3-3a1 1 0 011.414 0l3 3a1 1 0 01-1.414 1.414L11 5.414V13a1 1 0 11-2 0V5.414L7.707 6.707a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                  </svg>
                  <span>PDF 업로드</span>
                </button>
              </div>
            </div>
            
            <!-- 진행률 카드 -->
            <div class="progress-visual">
              <div class="progress-card">
                <div class="progress-header">
                  <h3>오늘의 학습 진도</h3>
                  <div class="progress-percentage">
                    <span class="percentage-value">75</span>
                    <span class="percentage-symbol">%</span>
                  </div>
                </div>
                <div class="progress-chart">
                  <div class="progress-ring">
                    <svg class="progress-svg" viewBox="0 0 120 120">
                      <circle class="progress-bg" cx="60" cy="60" r="50" />
                      <circle class="progress-fill" cx="60" cy="60" r="50" />
                    </svg>
                    <div class="progress-center">
                      <svg class="progress-icon" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" />
                      </svg>
                    </div>
                  </div>
                </div>
                <div class="progress-details">
                  <div class="progress-item">
                    <span class="item-label">완료</span>
                    <span class="item-value">3/4 과제</span>
                  </div>
                  <div class="progress-item">
                    <span class="item-label">남은 시간</span>
                    <span class="item-value">25분</span>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- 통계 카드 섹션 -->
          <div class="stats-overview">
            <div class="stats-grid">
              <div class="stat-card">
                <div class="stat-icon stat-icon-blue">
                  <svg viewBox="0 0 24 24" fill="currentColor">
                    <path d="M12 14l9-5-9-5-9 5 9 5z" />
                    <path d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
                  </svg>
                </div>
                <div class="stat-content">
                  <div class="stat-value">
                    <span class="value-number">12</span>
                    <span class="value-unit">개</span>
                  </div>
                  <div class="stat-label">완료한 학습</div>
                  <div class="stat-trend positive">
                    <svg class="trend-icon" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M3.293 9.707a1 1 0 010-1.414l6-6a1 1 0 011.414 0l6 6a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L4.707 9.707a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                    </svg>
                    <span>+20%</span>
                  </div>
                </div>
              </div>

              <div class="stat-card">
                <div class="stat-icon stat-icon-green">
                  <svg viewBox="0 0 24 24" fill="currentColor">
                    <path fill-rule="evenodd" d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div class="stat-content">
                  <div class="stat-value">
                    <span class="value-number">48</span>
                    <span class="value-unit">시간</span>
                  </div>
                  <div class="stat-label">총 학습 시간</div>
                  <div class="stat-trend positive">
                    <svg class="trend-icon" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M3.293 9.707a1 1 0 010-1.414l6-6a1 1 0 011.414 0l6 6a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L4.707 9.707a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                    </svg>
                    <span>+15%</span>
                  </div>
                </div>
              </div>

              <div class="stat-card">
                <div class="stat-icon stat-icon-purple">
                  <svg viewBox="0 0 24 24" fill="currentColor">
                    <path d="M2.003 5.884L10 9.882l7.997-3.998A2 2 0 0016 4H4a2 2 0 00-1.997 1.884z" />
                    <path d="M18 8.118l-8 4-8-4V14a2 2 0 002 2h12a2 2 0 002-2V8.118z" />
                  </svg>
                </div>
                <div class="stat-content">
                  <div class="stat-value">
                    <span class="value-number">89</span>
                    <span class="value-unit">%</span>
                  </div>
                  <div class="stat-label">평균 점수</div>
                  <div class="stat-trend positive">
                    <svg class="trend-icon" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M3.293 9.707a1 1 0 010-1.414l6-6a1 1 0 011.414 0l6 6a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L4.707 9.707a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                    </svg>
                    <span>+5%</span>
                  </div>
                </div>
              </div>

              <div class="stat-card">
                <div class="stat-icon stat-icon-orange">
                  <svg viewBox="0 0 24 24" fill="currentColor">
                    <path d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div class="stat-content">
                  <div class="stat-value">
                    <span class="value-number">7</span>
                    <span class="value-unit">일</span>
                  </div>
                  <div class="stat-label">연속 학습일</div>
                  <div class="stat-trend positive">
                    <svg class="trend-icon" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M3.293 9.707a1 1 0 010-1.414l6-6a1 1 0 011.414 0l6 6a1 1 0 01-1.414 1.414L11 5.414V17a1 1 0 11-2 0V5.414L4.707 9.707a1 1 0 01-1.414 0z" clip-rule="evenodd" />
                    </svg>
                    <span>+2일</span>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- 주요 기능 카드들 -->
          <div class="main-features">
            <div class="features-header">
              <h2 class="features-title">주요 학습 기능</h2>
              <p class="features-description">AI가 도와주는 스마트 학습 도구들을 활용해보세요</p>
            </div>

            <div class="features-grid">
              <div class="feature-card feature-primary" @click="navigateToUpload">
                <div class="feature-background">
                  <div class="feature-pattern"></div>
                </div>
                <div class="feature-content">
                  <div class="feature-icon">
                    <svg viewBox="0 0 24 24" fill="currentColor">
                      <path d="M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8l-6-6z" />
                      <polyline points="14,2 14,8 20,8" />
                      <line x1="16" y1="13" x2="8" y2="13" />
                      <line x1="16" y1="17" x2="8" y2="17" />
                      <polyline points="10,9 9,9 8,9" />
                    </svg>
                  </div>
                  <h3 class="feature-title">PDF 학습 시작</h3>
                  <p class="feature-description">
                    PDF 문서를 업로드하고 AI가 자동으로 맞춤형 문제를 생성해드립니다.
                  </p>
                  <div class="feature-stats">
                    <div class="stat-item">
                      <span class="stat-number">5-10</span>
                      <span class="stat-label">문제 생성</span>
                    </div>
                    <div class="stat-item">
                      <span class="stat-number">3</span>
                      <span class="stat-label">언어 지원</span>
                    </div>
                  </div>
                </div>
                <div class="feature-action">
                  <button class="btn-feature">
                    <span>시작하기</span>
                    <svg class="btn-arrow" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                    </svg>
                  </button>
                </div>
              </div>

              <div class="feature-card feature-secondary" @click="navigateToResults">
                <div class="feature-background">
                  <div class="feature-pattern"></div>
                </div>
                <div class="feature-content">
                  <div class="feature-icon">
                    <svg viewBox="0 0 24 24" fill="currentColor">
                      <path d="M9 17a2 2 0 11-4 0 2 2 0 014 0zM21 17a2 2 0 11-4 0 2 2 0 014 0z" />
                      <path d="M7 17h8a2 2 0 002-2V9a2 2 0 00-2-2H7V5a2 2 0 00-2-2H3a2 2 0 000 4h2v2a2 2 0 002 2z" />
                    </svg>
                  </div>
                  <h3 class="feature-title">학습 성과 분석</h3>
                  <p class="feature-description">
                    AI 기반 상세 분석으로 학습 패턴과 개선점을 확인하세요.
                  </p>
                  <div class="feature-stats">
                    <div class="stat-item">
                      <span class="stat-number">100%</span>
                      <span class="stat-label">자동 채점</span>
                    </div>
                    <div class="stat-item">
                      <span class="stat-number">AI</span>
                      <span class="stat-label">피드백</span>
                    </div>
                  </div>
                </div>
                <div class="feature-action">
                  <button class="btn-feature">
                    <span>분석 보기</span>
                    <svg class="btn-arrow" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                    </svg>
                  </button>
                </div>
              </div>

              <div class="feature-card feature-accent" @click="navigateToSettings">
                <div class="feature-background">
                  <div class="feature-pattern"></div>
                </div>
                <div class="feature-content">
                  <div class="feature-icon">
                    <svg viewBox="0 0 24 24" fill="currentColor">
                      <path fill-rule="evenodd" d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd" />
                    </svg>
                  </div>
                  <h3 class="feature-title">학습 설정</h3>
                  <p class="feature-description">
                    언어, 문제 유형, 난이도 등을 개인 취향에 맞게 설정하세요.
                  </p>
                  <div class="feature-stats">
                    <div class="stat-item">
                      <span class="stat-number">맞춤</span>
                      <span class="stat-label">설정</span>
                    </div>
                    <div class="stat-item">
                      <span class="stat-number">실시간</span>
                      <span class="stat-label">적용</span>
                    </div>
                  </div>
                </div>
                <div class="feature-action">
                  <button class="btn-feature">
                    <span>설정하기</span>
                    <svg class="btn-arrow" viewBox="0 0 20 20" fill="currentColor">
                      <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                    </svg>
                  </button>
                </div>
              </div>
            </div>
          </div>

          <!-- 최근 활동 -->
          <div class="recent-activity">
            <div class="activity-header">
              <h2 class="activity-title">최근 학습 활동</h2>
              <button class="btn-view-all">
                <span>전체 보기</span>
                <svg class="btn-icon" viewBox="0 0 20 20" fill="currentColor">
                  <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
                </svg>
              </button>
            </div>
            
            <div class="activity-list">
              <div class="activity-item">
                <div class="activity-icon activity-icon-success">
                  <svg viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div class="activity-content">
                  <h3 class="activity-name">데이터 구조와 알고리즘 시험</h3>
                  <p class="activity-description">10문제 중 9문제 정답 • 90점</p>
                  <time class="activity-time">2시간 전</time>
                </div>
                <div class="activity-score success">90점</div>
              </div>

              <div class="activity-item">
                <div class="activity-icon activity-icon-info">
                  <svg viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M3 4a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zm0 4a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zm0 4a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zm0 4a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div class="activity-content">
                  <h3 class="activity-name">머신러닝 기초 자료</h3>
                  <p class="activity-description">PDF 업로드 및 문제 생성 완료</p>
                  <time class="activity-time">어제</time>
                </div>
                <div class="activity-status processing">처리중</div>
              </div>

              <div class="activity-item">
                <div class="activity-icon activity-icon-warning">
                  <svg viewBox="0 0 20 20" fill="currentColor">
                    <path fill-rule="evenodd" d="M8.257 3.099c.765-1.36 2.722-1.36 3.486 0l5.58 9.92c.75 1.334-.213 2.98-1.742 2.98H4.42c-1.53 0-2.493-1.646-1.743-2.98l5.58-9.92zM11 13a1 1 0 11-2 0 1 1 0 012 0zm-1-8a1 1 0 00-1 1v3a1 1 0 002 0V6a1 1 0 00-1-1z" clip-rule="evenodd" />
                  </svg>
                </div>
                <div class="activity-content">
                  <h3 class="activity-name">웹 개발 기초 시험</h3>
                  <p class="activity-description">5문제 중 3문제 정답 • 60점</p>
                  <time class="activity-time">3일 전</time>
                </div>
                <div class="activity-score warning">60점</div>
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
import { ref, onMounted } from "vue";

const authStore = useAuthStore();
const router = useRouter();

// 페이지 상태
const isLoading = ref(false);

// 네비게이션 함수들
const startLearning = () => {
  router.push('/upload');
};

const uploadPDF = () => {
  router.push('/upload');
};

const navigateToUpload = () => {
  router.push('/upload');
};

const navigateToResults = () => {
  router.push('/results');
};

const navigateToSettings = () => {
  router.push('/settings');
};

const handleLogout = async () => {
  await authStore.logout();
  router.push("/login");
};

// 컴포넌트 마운트 시 실행
onMounted(() => {
  // 추후 실제 데이터 로딩 로직 추가
  isLoading.value = false;
});
</script>

<style scoped>
/* === 전역 색상 시스템 (StartPage와 동일) === */
:root {
  /* Primary Colors - 2024 트렌드 */
  --primary-blue: #2563EB;
  --primary-blue-dark: #1E40AF;
  --primary-blue-light: #3B82F6;
  
  /* Secondary Colors */
  --success-green: #10B981;
  --warning-orange: #F59E0B;
  --accent-purple: #8B5CF6;
  
  /* Neutral Colors */
  --gray-50: #F9FAFB;
  --gray-100: #F3F4F6;
  --gray-200: #E5E7EB;
  --gray-300: #D1D5DB;
  --gray-400: #9CA3AF;
  --gray-500: #6B7280;
  --gray-600: #4B5563;
  --gray-700: #374151;
  --gray-800: #1F2937;
  --gray-900: #111827;
  
  /* Gradients */
  --gradient-primary: linear-gradient(135deg, var(--primary-blue) 0%, var(--accent-purple) 100%);
  --gradient-success: linear-gradient(135deg, var(--success-green) 0%, var(--primary-blue) 100%);
  --gradient-hero: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  
  /* Modern Shadows */
  --shadow-sm: 0 1px 2px 0 rgba(0, 0, 0, 0.05);
  --shadow-md: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
  --shadow-lg: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
  --shadow-xl: 0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04);
  --shadow-glow: 0 0 20px rgba(37, 99, 235, 0.15);
  
  /* Border Radius */
  --radius-sm: 8px;
  --radius-md: 12px;
  --radius-lg: 16px;
  --radius-xl: 24px;
  
  /* Transitions */
  --transition-fast: all 0.2s cubic-bezier(0.4, 0, 0.2, 1);
  --transition-smooth: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
  --transition-bounce: all 0.4s cubic-bezier(0.68, -0.55, 0.265, 1.55);
}

/* === 기본 레이아웃 === */
.dashboard-container {
  min-height: 100vh;
  background: linear-gradient(
    135deg,
    rgba(37, 99, 235, 0.03) 0%,
    rgba(139, 92, 246, 0.03) 50%,
    rgba(16, 185, 129, 0.03) 100%
  );
  position: relative;
  overflow-x: hidden;
  font-family: 'Inter', -apple-system, BlinkMacSystemFont, sans-serif;
}

/* === 배경 효과 (StartPage와 동일) === */
.background-elements {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  pointer-events: none;
  z-index: -1;
}

.bg-gradient-1 {
  position: absolute;
  top: 20%;
  right: -10%;
  width: 600px;
  height: 600px;
  background: radial-gradient(circle, rgba(37, 99, 235, 0.08) 0%, transparent 70%);
  border-radius: 50%;
  animation: float-slow 8s ease-in-out infinite;
}

.bg-gradient-2 {
  position: absolute;
  bottom: 10%;
  left: -15%;
  width: 800px;
  height: 800px;
  background: radial-gradient(circle, rgba(139, 92, 246, 0.06) 0%, transparent 70%);
  border-radius: 50%;
  animation: float-slow 10s ease-in-out infinite reverse;
}

.floating-shapes {
  position: absolute;
  width: 100%;
  height: 100%;
}

.shape {
  position: absolute;
  opacity: 0.08;
}

.shape-1 {
  top: 15%;
  left: 10%;
  width: 120px;
  height: 120px;
  background: var(--gradient-primary);
  border-radius: var(--radius-xl);
  animation: float-gentle 6s ease-in-out infinite;
  transform: rotate(45deg);
}

.shape-2 {
  top: 60%;
  right: 15%;
  width: 80px;
  height: 80px;
  background: var(--gradient-success);
  border-radius: 50%;
  animation: float-gentle 7s ease-in-out infinite reverse;
}

.shape-3 {
  bottom: 25%;
  left: 20%;
  width: 100px;
  height: 100px;
  background: linear-gradient(135deg, var(--warning-orange) 0%, var(--accent-purple) 100%);
  border-radius: var(--radius-lg);
  animation: float-gentle 8s ease-in-out infinite;
}

/* === 메인 컨테이너 === */
.dashboard-main {
  padding: 2rem 0 4rem;
  position: relative;
  z-index: 1;
}

.container {
  max-width: 1400px;
  margin: 0 auto;
  padding: 0 2rem;
}

.dashboard-content {
  display: flex;
  flex-direction: column;
  gap: 3rem;
}

/* === 웰컴 헤더 === */
.welcome-header {
  display: grid;
  grid-template-columns: 2fr 1fr;
  gap: 4rem;
  align-items: center;
  margin-bottom: 1rem;
}

.welcome-content {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.welcome-badge {
  display: inline-flex;
  align-items: center;
  width: fit-content;
  gap: 0.5rem;
  padding: 0.75rem 1.25rem;
  background: rgba(37, 99, 235, 0.1);
  color: var(--primary-blue);
  border-radius: 50px;
  font-size: 0.875rem;
  font-weight: 600;
  animation: float-gentle 4s ease-in-out infinite;
}

.badge-icon {
  width: 16px;
  height: 16px;
}

.welcome-title {
  font-size: 3rem;
  font-weight: 800;
  color: var(--gray-900);
  margin: 0;
  line-height: 1.1;
}

.welcome-subtitle {
  font-size: 2rem;
  font-weight: 700;
  color: var(--gray-700);
  margin: 0;
  line-height: 1.2;
}

.highlight {
  background: var(--gradient-primary);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.welcome-description {
  font-size: 1.125rem;
  color: var(--gray-600);
  line-height: 1.6;
  max-width: 600px;
  margin: 0;
}

/* === 퀵 액션 버튼들 === */
.quick-actions {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.btn-quick-primary {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 1rem 2rem;
  background: var(--gradient-primary);
  color: white;
  border: none;
  border-radius: var(--radius-md);
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: var(--transition-bounce);
  box-shadow: var(--shadow-glow);
}

.btn-quick-primary:hover {
  transform: translateY(-2px) scale(1.02);
  box-shadow: 0 15px 30px rgba(37, 99, 235, 0.3);
}

.btn-quick-secondary {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 1rem 2rem;
  background: white;
  color: var(--gray-700);
  border: 2px solid var(--gray-200);
  border-radius: var(--radius-md);
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: var(--transition-smooth);
  box-shadow: var(--shadow-sm);
}

.btn-quick-secondary:hover {
  background: var(--gray-50);
  border-color: var(--primary-blue);
  color: var(--primary-blue);
  transform: translateY(-2px);
  box-shadow: var(--shadow-md);
}

.btn-icon {
  width: 20px;
  height: 20px;
}

/* === 진행률 비주얼 === */
.progress-visual {
  display: flex;
  justify-content: center;
}

.progress-card {
  background: white;
  border-radius: var(--radius-xl);
  padding: 2rem;
  box-shadow: var(--shadow-lg);
  border: 1px solid var(--gray-200);
  width: 100%;
  max-width: 350px;
}

.progress-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}

.progress-header h3 {
  font-size: 1.125rem;
  font-weight: 600;
  color: var(--gray-800);
  margin: 0;
}

.progress-percentage {
  display: flex;
  align-items: baseline;
  gap: 0.25rem;
}

.percentage-value {
  font-size: 1.75rem;
  font-weight: 800;
  color: var(--primary-blue);
}

.percentage-symbol {
  font-size: 1rem;
  font-weight: 600;
  color: var(--gray-500);
}

.progress-chart {
  display: flex;
  justify-content: center;
  margin-bottom: 2rem;
}

.progress-ring {
  position: relative;
  width: 120px;
  height: 120px;
}

.progress-svg {
  width: 100%;
  height: 100%;
  transform: rotate(-90deg);
}

.progress-bg {
  fill: none;
  stroke: var(--gray-200);
  stroke-width: 8;
}

.progress-fill {
  fill: none;
  stroke: url(#progressGradient);
  stroke-width: 8;
  stroke-linecap: round;
  stroke-dasharray: 314;
  stroke-dashoffset: 78.5;
  animation: progress-animate 2s ease-out;
}

.progress-center {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 40px;
  height: 40px;
  background: var(--gradient-primary);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  box-shadow: var(--shadow-glow);
}

.progress-icon {
  width: 20px;
  height: 20px;
}

.progress-details {
  display: flex;
  justify-content: space-between;
}

.progress-item {
  text-align: center;
}

.item-label {
  display: block;
  font-size: 0.875rem;
  color: var(--gray-500);
  margin-bottom: 0.25rem;
}

.item-value {
  font-size: 1rem;
  font-weight: 600;
  color: var(--gray-800);
}

/* === 통계 개요 === */
.stats-overview {
  margin: 2rem 0;
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
  gap: 1.5rem;
}

.stat-card {
  background: white;
  border-radius: var(--radius-xl);
  padding: 2rem;
  box-shadow: var(--shadow-lg);
  border: 1px solid var(--gray-200);
  transition: var(--transition-smooth);
  position: relative;
  overflow: hidden;
}

.stat-card:hover {
  transform: translateY(-4px);
  box-shadow: var(--shadow-xl);
}

.stat-card::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 4px;
  background: var(--gradient-primary);
}

.stat-icon {
  width: 48px;
  height: 48px;
  border-radius: var(--radius-md);
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 1.5rem;
  color: white;
}

.stat-icon svg {
  width: 24px;
  height: 24px;
}

.stat-icon-blue { background: var(--gradient-primary); }
.stat-icon-green { background: var(--gradient-success); }
.stat-icon-purple { background: linear-gradient(135deg, var(--accent-purple) 0%, var(--primary-blue) 100%); }
.stat-icon-orange { background: linear-gradient(135deg, var(--warning-orange) 0%, var(--accent-purple) 100%); }

.stat-content {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.stat-value {
  display: flex;
  align-items: baseline;
  gap: 0.25rem;
}

.value-number {
  font-size: 2rem;
  font-weight: 800;
  color: var(--gray-900);
}

.value-unit {
  font-size: 0.875rem;
  font-weight: 500;
  color: var(--gray-500);
}

.stat-label {
  font-size: 0.875rem;
  color: var(--gray-600);
  font-weight: 500;
}

.stat-trend {
  display: flex;
  align-items: center;
  gap: 0.25rem;
  font-size: 0.75rem;
  font-weight: 600;
}

.stat-trend.positive {
  color: var(--success-green);
}

.trend-icon {
  width: 12px;
  height: 12px;
}

/* === 주요 기능 === */
.main-features {
  margin: 3rem 0;
}

.features-header {
  text-align: center;
  margin-bottom: 3rem;
}

.features-title {
  font-size: 2.5rem;
  font-weight: 800;
  color: var(--gray-900);
  margin-bottom: 1rem;
  line-height: 1.1;
}

.features-description {
  font-size: 1.125rem;
  color: var(--gray-600);
  margin: 0;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 2rem;
}

.feature-card {
  background: white;
  border-radius: var(--radius-xl);
  padding: 0;
  box-shadow: var(--shadow-lg);
  border: 1px solid var(--gray-200);
  transition: var(--transition-smooth);
  position: relative;
  overflow: hidden;
  cursor: pointer;
}

.feature-card:hover {
  transform: translateY(-8px);
  box-shadow: var(--shadow-xl);
}

.feature-background {
  position: absolute;
  top: 0;
  right: 0;
  width: 100%;
  height: 100%;
  opacity: 0.05;
}

.feature-pattern {
  width: 100%;
  height: 100%;
  background-image: radial-gradient(circle at 2px 2px, currentColor 1px, transparent 0);
  background-size: 20px 20px;
}

.feature-primary .feature-pattern { color: var(--primary-blue); }
.feature-secondary .feature-pattern { color: var(--success-green); }
.feature-accent .feature-pattern { color: var(--accent-purple); }

.feature-content {
  padding: 2.5rem;
  position: relative;
  z-index: 2;
}

.feature-icon {
  width: 64px;
  height: 64px;
  border-radius: var(--radius-lg);
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 2rem;
  color: white;
  box-shadow: var(--shadow-glow);
}

.feature-primary .feature-icon { background: var(--gradient-primary); }
.feature-secondary .feature-icon { background: var(--gradient-success); }
.feature-accent .feature-icon { background: linear-gradient(135deg, var(--accent-purple) 0%, var(--primary-blue) 100%); }

.feature-icon svg {
  width: 32px;
  height: 32px;
}

.feature-title {
  font-size: 1.5rem;
  font-weight: 700;
  color: var(--gray-900);
  margin-bottom: 1rem;
}

.feature-description {
  font-size: 1rem;
  color: var(--gray-600);
  line-height: 1.6;
  margin-bottom: 2rem;
}

.feature-stats {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1.5rem;
}

.feature-stats .stat-item {
  text-align: center;
}

.feature-stats .stat-number {
  font-size: 1.125rem;
  font-weight: 700;
  color: var(--primary-blue);
  display: block;
  margin-bottom: 0.25rem;
}

.feature-stats .stat-label {
  font-size: 0.875rem;
  color: var(--gray-500);
}

.feature-action {
  padding: 0 2.5rem 2.5rem;
  position: relative;
  z-index: 2;
}

.btn-feature {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  width: 100%;
  padding: 1rem 2rem;
  background: var(--gray-900);
  color: white;
  border: none;
  border-radius: var(--radius-md);
  font-size: 1rem;
  font-weight: 600;
  cursor: pointer;
  transition: var(--transition-smooth);
}

.btn-feature:hover {
  background: var(--primary-blue);
  transform: translateY(-2px);
}

.btn-arrow {
  width: 16px;
  height: 16px;
  transition: var(--transition-smooth);
}

.btn-feature:hover .btn-arrow {
  transform: translateX(2px);
}

/* === 최근 활동 === */
.recent-activity {
  background: white;
  border-radius: var(--radius-xl);
  padding: 2.5rem;
  box-shadow: var(--shadow-lg);
  border: 1px solid var(--gray-200);
}

.activity-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}

.activity-title {
  font-size: 1.5rem;
  font-weight: 700;
  color: var(--gray-900);
  margin: 0;
}

.btn-view-all {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  background: none;
  border: none;
  color: var(--primary-blue);
  font-weight: 600;
  font-size: 0.875rem;
  cursor: pointer;
  transition: var(--transition-smooth);
}

.btn-view-all:hover {
  color: var(--primary-blue-dark);
}

.btn-view-all .btn-icon {
  width: 16px;
  height: 16px;
}

.activity-list {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.activity-item {
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1.5rem;
  background: var(--gray-50);
  border-radius: var(--radius-lg);
  transition: var(--transition-smooth);
}

.activity-item:hover {
  background: var(--gray-100);
  transform: translateX(4px);
}

.activity-icon {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  flex-shrink: 0;
}

.activity-icon svg {
  width: 20px;
  height: 20px;
}

.activity-icon-success { background: var(--success-green); }
.activity-icon-info { background: var(--primary-blue); }
.activity-icon-warning { background: var(--warning-orange); }

.activity-content {
  flex: 1;
}

.activity-name {
  font-size: 1rem;
  font-weight: 600;
  color: var(--gray-900);
  margin-bottom: 0.25rem;
}

.activity-description {
  font-size: 0.875rem;
  color: var(--gray-600);
  margin-bottom: 0.25rem;
}

.activity-time {
  font-size: 0.75rem;
  color: var(--gray-500);
}

.activity-score,
.activity-status {
  padding: 0.5rem 1rem;
  border-radius: var(--radius-sm);
  font-size: 0.875rem;
  font-weight: 600;
  flex-shrink: 0;
}

.activity-score.success {
  background: rgba(16, 185, 129, 0.1);
  color: var(--success-green);
}

.activity-score.warning {
  background: rgba(245, 158, 11, 0.1);
  color: var(--warning-orange);
}

.activity-status.processing {
  background: rgba(37, 99, 235, 0.1);
  color: var(--primary-blue);
}

/* === 애니메이션 === */
@keyframes float-slow {
  0%, 100% { transform: translateY(0px) rotate(0deg); }
  50% { transform: translateY(-20px) rotate(180deg); }
}

@keyframes float-gentle {
  0%, 100% { transform: translateY(0px); }
  50% { transform: translateY(-15px); }
}

@keyframes progress-animate {
  from { stroke-dashoffset: 314; }
  to { stroke-dashoffset: 78.5; }
}

/* === 반응형 디자인 === */
@media (max-width: 1024px) {
  .welcome-header {
    grid-template-columns: 1fr;
    gap: 3rem;
    text-align: center;
  }
  
  .progress-visual {
    justify-content: center;
  }
  
  .features-grid {
    grid-template-columns: 1fr;
  }
}

@media (max-width: 768px) {
  .container {
    padding: 0 1rem;
  }
  
  .welcome-title {
    font-size: 2.5rem;
  }
  
  .welcome-subtitle {
    font-size: 1.75rem;
  }
  
  .features-title {
    font-size: 2rem;
  }
  
  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }
  
  .quick-actions {
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }
  
  .btn-quick-primary,
  .btn-quick-secondary {
    width: 100%;
    max-width: 300px;
    justify-content: center;
  }
  
  .activity-header {
    flex-direction: column;
    gap: 1rem;
    text-align: center;
  }
}

@media (max-width: 480px) {
  .welcome-title {
    font-size: 2rem;
  }
  
  .welcome-subtitle {
    font-size: 1.5rem;
  }
  
  .features-title {
    font-size: 1.75rem;
  }
  
  .stats-grid {
    grid-template-columns: 1fr;
  }
  
  .feature-content {
    padding: 2rem;
  }
  
  .feature-action {
    padding: 0 2rem 2rem;
  }
  
  .recent-activity {
    padding: 2rem;
  }
  
  .activity-item {
    padding: 1rem;
  }
}

/* === 다크 모드 및 접근성 === */
@media (prefers-color-scheme: dark) {
  :root {
    --background-main: var(--gray-900);
    --text-primary: var(--gray-100);
    --text-secondary: var(--gray-400);
  }
}

@media (prefers-reduced-motion: reduce) {
  *,
  *::before,
  *::after {
    animation-duration: 0.01ms !important;
    animation-iteration-count: 1 !important;
    transition-duration: 0.01ms !important;
  }
}

/* === 고대비 모드 === */
@media (prefers-contrast: high) {
  .btn-quick-primary,
  .btn-feature {
    border: 2px solid currentColor;
  }
  
  .stat-card,
  .feature-card,
  .recent-activity {
    border: 2px solid var(--gray-300);
  }
}
</style>
