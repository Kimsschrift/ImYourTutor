<template>
  <div class="start-page">
    <!-- 네비게이션 헤더 -->
    <header class="navbar">
      <div class="nav-container">
        <div class="logo" @click="goToHome" role="button" tabindex="0" @keydown.enter="goToHome" @keydown.space="goToHome">
          <div class="logo-backdrop">
            <img src="@/assets/Logo.png" alt="ImYourTutor" class="logo-image" />
          </div>
          <span class="logo-text">ImYourTutor</span>
        </div>
        <div class="nav-actions">
          <!-- 언어 선택기 -->
          <div class="language-selector">
            <select v-model="selectedLanguage" @change="changeLanguage" class="language-dropdown" aria-label="언어 선택">
              <option value="ko">한국어</option>
              <option value="en">English</option>
              <option value="de">Deutsch</option>
            </select>
          </div>
          <div class="nav-buttons">
            <button @click="goToLogin" class="btn-secondary">{{ translations[selectedLanguage].login }}</button>
            <button @click="goToLogin" class="btn-primary">{{ translations[selectedLanguage].signup }}</button>
          </div>
          <!-- 모바일 메뉴 버튼 -->
          <button class="mobile-menu-btn" @click="toggleMobileMenu" :aria-expanded="mobileMenuOpen">
            <svg viewBox="0 0 24 24" width="24" height="24">
              <path v-if="!mobileMenuOpen" fill="currentColor" d="M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z"/>
              <path v-else fill="currentColor" d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"/>
            </svg>
          </button>
        </div>
      </div>
      <!-- 모바일 메뉴 -->
      <Transition name="mobile-menu">
        <div v-if="mobileMenuOpen" class="mobile-menu">
          <div class="mobile-menu-content">
            <div class="mobile-language-selector">
              <select v-model="selectedLanguage" @change="changeLanguage" class="mobile-language-dropdown">
                <option value="ko">한국어</option>
                <option value="en">English</option>
                <option value="de">Deutsch</option>
              </select>
            </div>
            <div class="mobile-nav-buttons">
              <button @click="goToLogin" class="mobile-btn-secondary">{{ translations[selectedLanguage].login }}</button>
              <button @click="goToLogin" class="mobile-btn-primary">{{ translations[selectedLanguage].signup }}</button>
            </div>
          </div>
        </div>
      </Transition>
    </header>

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

    <!-- 히어로 섹션 -->
    <section class="hero-section">
      <div class="hero-container">
        <div class="hero-content">
          <div class="hero-badge">
            <span class="badge-text">{{ translations[selectedLanguage].badge }}</span>
          </div>
          <h1 class="hero-title">
            {{ translations[selectedLanguage].heroTitle.split('\n')[0] }}<br>
            <span class="hero-highlight">{{ translations[selectedLanguage].heroTitle.split('\n')[1] }}</span>
          </h1>
          <p class="hero-subtitle">
            {{ translations[selectedLanguage].heroSubtitle }}
          </p>
          <div class="hero-features">
            <div class="feature-item" v-for="(feature, index) in translations[selectedLanguage].heroFeatures" :key="index">
              <svg class="feature-icon" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
              </svg>
              <span>{{ feature }}</span>
            </div>
          </div>
          <div class="hero-buttons">
            <button @click="goToLogin" class="btn-hero-primary">
              <svg class="btn-icon" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M10 18a8 8 0 100-16 8 8 0 000 16zm3.707-8.293l-3-3a1 1 0 00-1.414-1.414L9 5.586 7.707 4.293a1 1 0 00-1.414 1.414L8 7.414l2.293 2.293a1 1 0 001.414 0l3-3a1 1 0 000-1.414z" clip-rule="evenodd" />
              </svg>
              {{ translations[selectedLanguage].startFree }}
            </button>
            <button @click="scrollToFeatures" class="btn-hero-secondary">
              <svg class="btn-icon" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z" clip-rule="evenodd" />
              </svg>
              {{ translations[selectedLanguage].learnMore }}
            </button>
          </div>
        </div>
        <div class="hero-visual">
          <div class="visual-container">
            <!-- 3D 디자인 카드 -->
            <div class="design-card main-card">
              <div class="card-header">
                <div class="card-dots">
                  <span class="dot dot-red"></span>
                  <span class="dot dot-yellow"></span>
                  <span class="dot dot-green"></span>
                </div>
                <h3>{{ translations[selectedLanguage].cardTitle }}</h3>
              </div>
              <div class="card-content">
                <div class="progress-bars">
                  <div class="progress-item">
                    <span>{{ translations[selectedLanguage].progress1 }}</span>
                    <div class="progress-bar">
                      <div class="progress-fill" style="width: 85%"></div>
                    </div>
                  </div>
                  <div class="progress-item">
                    <span>{{ translations[selectedLanguage].progress2 }}</span>
                    <div class="progress-bar">
                      <div class="progress-fill" style="width: 70%"></div>
                    </div>
                  </div>
                  <div class="progress-item">
                    <span>{{ translations[selectedLanguage].progress3 }}</span>
                    <div class="progress-bar">
                      <div class="progress-fill" style="width: 90%"></div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- 플로팅 요소들 -->
            <div class="floating-elements-hero">
              <div class="floating-element element-1">
                <svg viewBox="0 0 24 24" fill="currentColor">
                  <path d="M12 .75a8.25 8.25 0 0 0-8.25 8.25v4.5c0 .61.35 1.16.9 1.43l8.25 4.125a.75.75 0 0 0 .6 0l8.25-4.125c.55-.27.9-.82.9-1.43v-4.5A8.25 8.25 0 0 0 12 .75Z" />
                </svg>
              </div>
              <div class="floating-element element-2">
                <svg viewBox="0 0 24 24" fill="currentColor">
                  <path d="M11.25 4.533A9.707 9.707 0 0 0 6 3a9.735 9.735 0 0 0-3.25.555.75.75 0 0 0-.5.707v14.25a.75.75 0 0 0 1 .707A8.237 8.237 0 0 1 6 18.75c1.995 0 3.823.707 5.25 1.886V4.533ZM12.75 20.636A8.214 8.214 0 0 1 18 18.75c.966 0 1.89.166 2.75.47a.75.75 0 0 0 1-.708V4.262a.75.75 0 0 0-.5-.707A9.735 9.735 0 0 0 18 3a9.707 9.707 0 0 0-5.25 1.533v16.103Z" />
                </svg>
              </div>
              <div class="floating-element element-3">
                <svg viewBox="0 0 24 24" fill="currentColor">
                  <path d="M4.26 10.147a60.438 60.438 0 0 0-.491 6.347A48.62 48.62 0 0 1 12 20.904a48.62 48.62 0 0 1 8.232-4.41 60.46 60.46 0 0 0-.491-6.347m-15.482 0a50.636 50.636 0 0 0-2.658-.813c-.59-.17-.832-.596-.832-1.079V6.375c0-1.036.84-1.875 1.875-1.875h.375A3.75 3.75 0 0 1 8.25 1.875v8.196a3.75 3.75 0 0 1-4.26.074ZM15.75 1.875v8.196a3.75 3.75 0 0 0 4.26.074 50.636 50.636 0 0 1 2.658-.813c.59-.17.832-.596.832-1.079V6.375a1.875 1.875 0 0 0-1.875-1.875h-.375A3.75 3.75 0 0 0 15.75 1.875Z" />
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 기능 소개 섹션 -->
    <section id="features" class="features-section">
      <div class="container">
        <div class="section-header">
          <div class="section-badge">
            <span>{{ translations[selectedLanguage].featuresBadge }}</span>
          </div>
          <h2 class="section-title">{{ translations[selectedLanguage].featuresTitle }}</h2>
          <p class="section-description">{{ translations[selectedLanguage].featuresDescription }}</p>
        </div>
        
        <div class="features-grid">
          <div 
            v-for="(feature, index) in translations[selectedLanguage].features" 
            :key="index"
            class="feature-card"
            :class="`feature-card-${index + 1}`"
          >
            <div class="feature-card-inner">
              <div class="feature-header">
                <div class="feature-icon" :class="`icon-${index + 1}`">
                  <component :is="feature.icon" />
                </div>
                <div class="feature-number">
                  <span>{{ String(index + 1).padStart(2, '0') }}</span>
                </div>
              </div>
              <div class="feature-content">
                <h3 class="feature-title">{{ feature.title }}</h3>
                <p class="feature-description">{{ feature.description }}</p>
              </div>
              <div class="feature-footer">
                <div class="feature-stats">
                  <span class="stat-label">{{ feature.statLabel }}</span>
                  <span class="stat-value">{{ feature.statValue }}</span>
                </div>
              </div>
            </div>
            <div class="feature-glow"></div>
          </div>
        </div>
        
        <!-- 통계 섹션 -->
        <div class="stats-section">
          <div class="stats-grid">
            <div v-for="(stat, index) in translations[selectedLanguage].stats" :key="index" class="stat-item">
              <div class="stat-number">{{ stat.number }}</div>
              <div class="stat-label">{{ stat.label }}</div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- CTA 섹션 -->
    <section class="cta-section">
      <div class="cta-background">
        <div class="cta-shapes">
          <div class="cta-shape shape-1"></div>
          <div class="cta-shape shape-2"></div>
          <div class="cta-shape shape-3"></div>
        </div>
      </div>
      <div class="container">
        <div class="cta-content">
          <div class="cta-badge">
            <span>{{ translations[selectedLanguage].ctaBadge }}</span>
          </div>
          <h2 class="cta-title">{{ translations[selectedLanguage].ctaTitle }}</h2>
          <p class="cta-description">{{ translations[selectedLanguage].ctaDescription }}</p>
          
          <div class="cta-features">
            <div v-for="(feature, index) in translations[selectedLanguage].ctaFeatures" :key="index" class="cta-feature">
              <svg class="cta-feature-icon" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
              </svg>
              <span>{{ feature }}</span>
            </div>
          </div>
          
          <div class="cta-actions">
            <button @click="goToLogin" class="btn-cta-primary">
              <span>{{ translations[selectedLanguage].ctaButton }}</span>
              <svg class="btn-arrow" viewBox="0 0 20 20" fill="currentColor">
                <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd" />
              </svg>
            </button>
            <div class="cta-info">
              <span class="cta-info-text">{{ translations[selectedLanguage].ctaInfo }}</span>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- 푸터 -->
    <footer class="footer">
      <div class="container">
        <div class="footer-content">
          <div class="footer-main">
            <div class="footer-logo">
              <div class="footer-logo-container">
                <img src="@/assets/Logo.png" alt="ImYourTutor" class="footer-logo-image" />
                <h3 class="footer-logo-text">ImYourTutor</h3>
              </div>
              <p class="footer-description">{{ translations[selectedLanguage].footerDescription }}</p>
              <div class="footer-social">
                <!-- 소셜 링크들 추후 추가 -->
              </div>
            </div>
            
            <div class="footer-nav">
              <div class="footer-nav-group">
                <h4 class="footer-nav-title">{{ translations[selectedLanguage].footerServices }}</h4>
                <ul class="footer-nav-list">
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerPdfLearning }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerAiGeneration }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerMultiLanguage }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerRealTimeEval }}</a></li>
                </ul>
              </div>
              
              <div class="footer-nav-group">
                <h4 class="footer-nav-title">{{ translations[selectedLanguage].footerSupport }}</h4>
                <ul class="footer-nav-list">
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerHelp }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerContact }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerFaq }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerPrivacy }}</a></li>
                </ul>
              </div>
              
              <div class="footer-nav-group">
                <h4 class="footer-nav-title">{{ translations[selectedLanguage].footerCompany }}</h4>
                <ul class="footer-nav-list">
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerAbout }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerCareers }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerBlog }}</a></li>
                  <li><a href="#" class="footer-nav-link">{{ translations[selectedLanguage].footerTerms }}</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        
        <div class="footer-bottom">
          <div class="footer-bottom-content">
            <p class="footer-copyright">&copy; 2024 ImYourTutor. {{ translations[selectedLanguage].footerRights }}</p>
            <div class="footer-language">
              <select v-model="selectedLanguage" @change="changeLanguage" class="footer-language-dropdown">
                <option value="ko">한국어</option>
                <option value="en">English</option>
                <option value="de">Deutsch</option>
              </select>
            </div>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup lang="ts">
import { ref, h, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const selectedLanguage = ref('ko');
const mobileMenuOpen = ref(false);

// 다국어 번역 데이터
const translations = ref({
  ko: {
    login: '로그인',
    signup: '가입하기',
    badge: '혁신적인 AI 학습',
    heroTitle: 'AI와 함께하는\n개인 맞춤형 학습',
    heroSubtitle: 'PDF 문서를 업로드하고 AI가 생성하는 맞춤형 문제로 효과적인 학습을 경험하세요.',
    heroFeatures: ['다국어 지원 (3개 언어)', 'AI 기반 문제 생성', '실시간 평가 시스템'],
    startFree: '무료로 시작하기',
    learnMore: '더 알아보기',
    cardTitle: '학습 대시보드',
    progress1: 'PDF 분석',
    progress2: '문제 생성',
    progress3: '학습 진도',
    featuresBadge: '주요 기능',
    featuresTitle: 'ImYourTutor가 특별한 이유',
    featuresDescription: '최신 AI 기술과 교육 전문성이 결합된 혁신적인 학습 플랫폼',
    features: [
      {
        title: 'PDF 기반 학습',
        description: '학습하고 싶은 PDF 문서를 업로드하면 AI가 자동으로 핵심 내용을 분석합니다.',
        statLabel: '지원 형식',
        statValue: 'PDF',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M14 2H6C4.9 2 4 2.9 4 4v16c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V8l-6-6z' }))
      },
      {
        title: '지능형 문제 생성',
        description: '객관식, 서술형, 빈칸 채우기 등 다양한 유형의 문제를 AI가 생성합니다.',
        statLabel: '문제 수',
        statValue: '5-10개',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z' }))
      },
      {
        title: '다국어 지원',
        description: '한국어, 독일어, 영어 3개 언어로 문제 생성 및 학습이 가능합니다.',
        statLabel: '지원 언어',
        statValue: '3개국',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2z' }))
      },
      {
        title: '실시간 평가',
        description: 'AI가 답안을 실시간으로 평가하고 100점 만점으로 점수를 산출합니다.',
        statLabel: '평가 시스템',
        statValue: 'AI',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2l3.09 6.26L22 9.27l-5 4.87 1.18 6.88L12 17.77l-6.18 3.25L7 14.14 2 9.27l6.91-1.01L12 2z' }))
      }
    ],
    stats: [
      { number: '10,000+', label: '개의 문제 생성' },
      { number: '95%', label: '만족도' },
      { number: '3', label: '개 언어 지원' },
      { number: '24/7', label: '서비스 이용' }
    ],
    ctaBadge: '지금 시작하세요',
    ctaTitle: 'AI 맞춤형 학습을 체험해보세요',
    ctaDescription: 'PDF 한 장으로 시작하는 새로운 학습 경험. 지금 바로 무료로 시작하세요.',
    ctaFeatures: ['무료 체험 가능', '신용카드 불필요', '언제나 취소 가능'],
    ctaButton: '무료로 체험하기',
    ctaInfo: '✨ 새로운 AI 기술로 학습 효과를 극대화하세요',
    footerDescription: 'AI 기반 개인 맞춤형 학습 플랫폼',
    footerServices: '서비스',
    footerPdfLearning: 'PDF 학습',
    footerAiGeneration: 'AI 문제 생성',
    footerMultiLanguage: '다국어 지원',
    footerRealTimeEval: '실시간 평가',
    footerSupport: '지원',
    footerHelp: '도움말',
    footerContact: '문의하기',
    footerFaq: 'FAQ',
    footerPrivacy: '개인정보처리방침',
    footerCompany: '회사',
    footerAbout: '회사 소개',
    footerCareers: '채용',
    footerBlog: '블로그',
    footerTerms: '이용약관',
    footerRights: 'All rights reserved.'
  },
  en: {
    login: 'Login',
    signup: 'Sign Up',
    badge: 'Innovative AI Learning',
    heroTitle: 'AI-Powered\nPersonalized Learning',
    heroSubtitle: 'Upload PDF documents and experience effective learning with AI-generated customized questions.',
    heroFeatures: ['Multi-language Support (3 Languages)', 'AI-based Question Generation', 'Real-time Evaluation System'],
    startFree: 'Start Free',
    learnMore: 'Learn More',
    cardTitle: 'Learning Dashboard',
    progress1: 'PDF Analysis',
    progress2: 'Question Generation',
    progress3: 'Learning Progress',
    featuresBadge: 'Key Features',
    featuresTitle: 'Why ImYourTutor is Special',
    featuresDescription: 'An innovative learning platform combining cutting-edge AI technology with educational expertise',
    features: [
      {
        title: 'PDF-based Learning',
        description: 'Upload any PDF document and AI automatically analyzes core content to generate customized questions.',
        statLabel: 'Supported Format',
        statValue: 'PDF',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M14 2H6C4.9 2 4 2.9 4 4v16c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V8l-6-6z' }))
      },
      {
        title: 'Intelligent Question Generation',
        description: 'AI generates various types of questions including multiple choice, essay, and fill-in-the-blank.',
        statLabel: 'Questions',
        statValue: '5-10',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z' }))
      },
      {
        title: 'Multi-language Support',
        description: 'Generate questions and learn in Korean, German, and English for global learning experience.',
        statLabel: 'Languages',
        statValue: '3',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2z' }))
      },
      {
        title: 'Real-time Evaluation',
        description: 'AI evaluates answers in real-time and calculates scores out of 100 points for immediate feedback.',
        statLabel: 'Evaluation',
        statValue: 'AI',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2l3.09 6.26L22 9.27l-5 4.87 1.18 6.88L12 17.77l-6.18 3.25L7 14.14 2 9.27l6.91-1.01L12 2z' }))
      }
    ],
    stats: [
      { number: '10,000+', label: 'Questions Generated' },
      { number: '95%', label: 'Satisfaction Rate' },
      { number: '3', label: 'Languages Supported' },
      { number: '24/7', label: 'Service Available' }
    ],
    ctaBadge: 'Get Started Now',
    ctaTitle: 'Experience AI-Powered Personalized Learning',
    ctaDescription: 'Start your new learning journey with just one PDF. Try it free now.',
    ctaFeatures: ['Free Trial Available', 'No Credit Card Required', 'Cancel Anytime'],
    ctaButton: 'Try Free Now',
    ctaInfo: '✨ Maximize your learning effectiveness with new AI technology',
    footerDescription: 'AI-Powered Personalized Learning Platform',
    footerServices: 'Services',
    footerPdfLearning: 'PDF Learning',
    footerAiGeneration: 'AI Question Generation',
    footerMultiLanguage: 'Multi-language Support',
    footerRealTimeEval: 'Real-time Evaluation',
    footerSupport: 'Support',
    footerHelp: 'Help',
    footerContact: 'Contact',
    footerFaq: 'FAQ',
    footerPrivacy: 'Privacy Policy',
    footerCompany: 'Company',
    footerAbout: 'About Us',
    footerCareers: 'Careers',
    footerBlog: 'Blog',
    footerTerms: 'Terms of Service',
    footerRights: 'All rights reserved.'
  },
  de: {
    login: 'Anmelden',
    signup: 'Registrieren',
    badge: 'Innovatives KI-Lernen',
    heroTitle: 'KI-gesteuerte\npersonalisierte Lernplattform',
    heroSubtitle: 'Laden Sie PDF-Dokumente hoch und erleben Sie effektives Lernen mit KI-generierten maßgeschneiderten Fragen.',
    heroFeatures: ['Mehrsprachige Unterstützung (3 Sprachen)', 'KI-basierte Fragenerstellung', 'Echtzeit-Bewertungssystem'],
    startFree: 'Kostenlos starten',
    learnMore: 'Mehr erfahren',
    cardTitle: 'Lern-Dashboard',
    progress1: 'PDF-Analyse',
    progress2: 'Fragenerstellung',
    progress3: 'Lernfortschritt',
    featuresBadge: 'Hauptfunktionen',
    featuresTitle: 'Warum ImYourTutor besonders ist',
    featuresDescription: 'Eine innovative Lernplattform, die modernste KI-Technologie mit pädagogischer Expertise verbindet',
    features: [
      {
        title: 'PDF-basiertes Lernen',
        description: 'Laden Sie beliebige PDF-Dokumente hoch und KI analysiert automatisch die Kerninhalte zur Fragenerstellung.',
        statLabel: 'Unterstütztes Format',
        statValue: 'PDF',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M14 2H6C4.9 2 4 2.9 4 4v16c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V8l-6-6z' }))
      },
      {
        title: 'Intelligente Fragenerstellung',
        description: 'KI generiert verschiedene Fragetypen wie Multiple Choice, Aufsatz und Lückentext.',
        statLabel: 'Fragen',
        statValue: '5-10',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z' }))
      },
      {
        title: 'Mehrsprachige Unterstützung',
        description: 'Erstellen Sie Fragen und lernen Sie auf Koreanisch, Deutsch und Englisch für globales Lernen.',
        statLabel: 'Sprachen',
        statValue: '3',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2z' }))
      },
      {
        title: 'Echtzeit-Bewertung',
        description: 'KI bewertet Antworten in Echtzeit und berechnet Punkte von 100 für sofortiges Feedback.',
        statLabel: 'Bewertung',
        statValue: 'KI',
        icon: () => h('svg', { viewBox: '0 0 24 24', fill: 'currentColor' }, h('path', { d: 'M12 2l3.09 6.26L22 9.27l-5 4.87 1.18 6.88L12 17.77l-6.18 3.25L7 14.14 2 9.27l6.91-1.01L12 2z' }))
      }
    ],
    stats: [
      { number: '10.000+', label: 'Fragen generiert' },
      { number: '95%', label: 'Zufriedenheitsrate' },
      { number: '3', label: 'Sprachen unterstützt' },
      { number: '24/7', label: 'Service verfügbar' }
    ],
    ctaBadge: 'Jetzt loslegen',
    ctaTitle: 'Erleben Sie KI-gesteuerte personalisierte Lernplattform',
    ctaDescription: 'Beginnen Sie Ihre neue Lernreise mit nur einer PDF. Probieren Sie es jetzt kostenlos aus.',
    ctaFeatures: ['Kostenlose Testversion', 'Keine Kreditkarte erforderlich', 'Jederzeit kündbar'],
    ctaButton: 'Jetzt kostenlos testen',
    ctaInfo: '✨ Maximieren Sie Ihre Lerneffektivität mit neuer KI-Technologie',
    footerDescription: 'KI-gesteuerte personalisierte Lernplattform',
    footerServices: 'Dienstleistungen',
    footerPdfLearning: 'PDF-Lernen',
    footerAiGeneration: 'KI-Fragenerstellung',
    footerMultiLanguage: 'Mehrsprachige Unterstützung',
    footerRealTimeEval: 'Echtzeit-Bewertung',
    footerSupport: 'Unterstützung',
    footerHelp: 'Hilfe',
    footerContact: 'Kontakt',
    footerFaq: 'Häufige Fragen',
    footerPrivacy: 'Datenschutzrichtlinie',
    footerCompany: 'Unternehmen',
    footerAbout: 'Über uns',
    footerCareers: 'Karriere',
    footerBlog: 'Blog',
    footerTerms: 'Nutzungsbedingungen',
    footerRights: 'Alle Rechte vorbehalten.'
  }
});

const goToLogin = () => {
  router.push('/login');
};

const goToHome = () => {
  router.push('/');
};

const scrollToFeatures = () => {
  const element = document.getElementById('features');
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' });
  }
};

const changeLanguage = () => {
  localStorage.setItem('preferred-language', selectedLanguage.value);
};

const toggleMobileMenu = () => {
  mobileMenuOpen.value = !mobileMenuOpen.value;
};

onMounted(() => {
  const savedLanguage = localStorage.getItem('preferred-language');
  if (savedLanguage && translations.value[savedLanguage as keyof typeof translations.value]) {
    selectedLanguage.value = savedLanguage;
  }
});
</script>

<style scoped>
/* === 전역 색상 시스템 === */
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
.start-page {
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

/* === 배경 효과 === */
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
  background: radial-gradient(circle, rgba(37, 99, 235, 0.1) 0%, transparent 70%);
  border-radius: 50%;
  animation: float-slow 8s ease-in-out infinite;
}

.bg-gradient-2 {
  position: absolute;
  bottom: 10%;
  left: -15%;
  width: 800px;
  height: 800px;
  background: radial-gradient(circle, rgba(139, 92, 246, 0.08) 0%, transparent 70%);
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
  opacity: 0.1;
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

/* === 내비게이션 === */
.navbar {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background: rgba(255, 255, 255, 0.9);
  backdrop-filter: blur(16px);
  border-bottom: 1px solid rgba(229, 231, 235, 0.3);
  z-index: 1000;
  height: 80px;
  transition: var(--transition-smooth);
}

.nav-container {
  max-width: 1400px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 2rem;
  height: 100%;
}

.logo {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  cursor: pointer;
  transition: var(--transition-smooth);
  position: relative;
  z-index: 10;
}

.logo:hover {
  transform: scale(1.02);
}

.logo-backdrop {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 48px;
  height: 48px;
  background: var(--gradient-primary);
  border-radius: var(--radius-md);
  padding: 8px;
  box-shadow: var(--shadow-glow);
}

.logo-image {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

.logo-text {
  font-size: 1.5rem;
  font-weight: 700;
  background: var(--gradient-primary);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

.nav-actions {
  display: flex;
  align-items: center;
  gap: 1.5rem;
}

.language-selector {
  position: relative;
}

.language-dropdown {
  padding: 0.5rem 1rem;
  background: white;
  border: 1px solid var(--gray-200);
  border-radius: var(--radius-sm);
  font-size: 0.875rem;
  font-weight: 500;
  color: var(--gray-700);
  cursor: pointer;
  transition: var(--transition-smooth);
  box-shadow: var(--shadow-sm);
}

.language-dropdown:hover {
  border-color: var(--primary-blue);
  box-shadow: var(--shadow-md);
}

.nav-buttons {
  display: flex;
  align-items: center;
  gap: 0.75rem;
}

.btn-secondary {
  padding: 0.75rem 1.5rem;
  background: transparent;
  color: var(--gray-700);
  border: 1.5px solid var(--gray-200);
  border-radius: var(--radius-sm);
  font-weight: 600;
  font-size: 0.875rem;
  cursor: pointer;
  transition: var(--transition-smooth);
  position: relative;
  overflow: hidden;
}

.btn-secondary:hover {
  background: var(--gray-50);
  border-color: var(--primary-blue);
  color: var(--primary-blue);
  transform: translateY(-1px);
  box-shadow: var(--shadow-md);
}

.btn-primary {
  padding: 0.75rem 1.5rem;
  background: var(--gradient-primary);
  color: white;
  border: none;
  border-radius: var(--radius-sm);
  font-weight: 600;
  font-size: 0.875rem;
  cursor: pointer;
  transition: var(--transition-smooth);
  position: relative;
  overflow: hidden;
  box-shadow: var(--shadow-glow);
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 25px rgba(37, 99, 235, 0.25);
}

.btn-primary:active {
  transform: translateY(0);
}

/* 모바일 메뉴 */
.mobile-menu-btn {
  display: none;
  background: none;
  border: none;
  cursor: pointer;
  padding: 0.5rem;
  color: var(--gray-700);
  border-radius: var(--radius-sm);
  transition: var(--transition-smooth);
}

.mobile-menu-btn:hover {
  background: var(--gray-100);
}

.mobile-menu {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  background: rgba(255, 255, 255, 0.95);
  backdrop-filter: blur(16px);
  border-bottom: 1px solid var(--gray-200);
  box-shadow: var(--shadow-lg);
}

.mobile-menu-content {
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
  align-items: center;
}

.mobile-language-selector {
  width: 100%;
  max-width: 200px;
}

.mobile-language-dropdown {
  width: 100%;
  padding: 0.75rem 1rem;
  background: white;
  border: 1px solid var(--gray-200);
  border-radius: var(--radius-sm);
  font-weight: 500;
  cursor: pointer;
}

.mobile-nav-buttons {
  display: flex;
  gap: 1rem;
  width: 100%;
  max-width: 300px;
}

.mobile-btn-secondary,
.mobile-btn-primary {
  flex: 1;
  padding: 0.875rem 1.5rem;
  border-radius: var(--radius-sm);
  font-weight: 600;
  cursor: pointer;
  transition: var(--transition-smooth);
}

.mobile-btn-secondary {
  background: transparent;
  color: var(--gray-700);
  border: 1.5px solid var(--gray-200);
}

.mobile-btn-primary {
  background: var(--gradient-primary);
  color: white;
  border: none;
}

/* 모바일 메뉴 트랜지션 */
.mobile-menu-enter-active,
.mobile-menu-leave-active {
  transition: var(--transition-smooth);
}

.mobile-menu-enter-from,
.mobile-menu-leave-to {
  opacity: 0;
  transform: translateY(-10px);
}

/* === 히어로 섹션 === */
.hero-section {
  padding: 140px 0 120px;
  background: linear-gradient(135deg, #1e3a8a 0%, #4c1d95 100%);
  color: white;
  position: relative;
  overflow: hidden;
}

.hero-container {
  max-width: 1400px;
  margin: 0 auto;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 6rem;
  align-items: center;
  padding: 0 2rem;
  position: relative;
  z-index: 2;
}

.hero-content {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.hero-badge {
  display: inline-flex;
  align-items: center;
  width: fit-content;
  padding: 0.75rem 1.5rem;
  background: rgba(255, 255, 255, 0.15);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: 50px;
  font-size: 0.875rem;
  font-weight: 600;
  animation: float-gentle 4s ease-in-out infinite;
}

.badge-text {
  color: rgba(255, 255, 255, 0.95);
}

.hero-title {
  font-size: 4rem;
  font-weight: 800;
  line-height: 1.1;
  letter-spacing: -0.025em;
  margin: 0;
  color: white !important;
}

.hero-highlight {
  background: linear-gradient(135deg, #FBBF24 0%, #F59E0B 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  display: inline-block;
}

.hero-subtitle {
  font-size: 1.25rem;
  line-height: 1.6;
  opacity: 0.9;
  max-width: 600px;
  margin: 0;
  color: white !important;
}

.hero-features {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.feature-item {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  font-weight: 500;
  color: white !important;
}

.feature-icon {
  width: 20px;
  height: 20px;
  color: var(--success-green);
  flex-shrink: 0;
}

.hero-buttons {
  display: flex;
  gap: 1rem;
  flex-wrap: wrap;
}

.btn-hero-primary {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 1.25rem 2rem;
  background: linear-gradient(135deg, #FBBF24 0%, #F59E0B 100%);
  color: var(--gray-900);
  border: none;
  border-radius: var(--radius-md);
  font-size: 1.125rem;
  font-weight: 700;
  cursor: pointer;
  transition: var(--transition-bounce);
  box-shadow: 0 10px 25px rgba(251, 191, 36, 0.3);
  position: relative;
  overflow: hidden;
}

.btn-hero-primary:hover {
  transform: translateY(-3px) scale(1.02);
  box-shadow: 0 15px 35px rgba(251, 191, 36, 0.4);
}

.btn-hero-primary:active {
  transform: translateY(-1px) scale(1);
}

.btn-hero-secondary {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  padding: 1.25rem 2rem;
  background: rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(10px);
  color: white;
  border: 2px solid rgba(255, 255, 255, 0.3);
  border-radius: var(--radius-md);
  font-size: 1.125rem;
  font-weight: 600;
  cursor: pointer;
  transition: var(--transition-smooth);
}

.btn-hero-secondary:hover {
  background: rgba(255, 255, 255, 0.2);
  border-color: rgba(255, 255, 255, 0.5);
  transform: translateY(-2px);
}

.btn-icon {
  width: 20px;
  height: 20px;
}

/* === 히어로 비주얼 === */
.hero-visual {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.visual-container {
  position: relative;
  width: 100%;
  max-width: 500px;
}

.design-card {
  background: rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(20px);
  border: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: var(--radius-xl);
  padding: 2rem;
  box-shadow: 0 25px 50px rgba(0, 0, 0, 0.15);
  animation: float-card 6s ease-in-out infinite;
}

.card-header {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-bottom: 1.5rem;
}

.card-dots {
  display: flex;
  gap: 0.5rem;
}

.dot {
  width: 12px;
  height: 12px;
  border-radius: 50%;
}

.dot-red { background: #EF4444; }
.dot-yellow { background: #FBBF24; }
.dot-green { background: #10B981; }

.card-header h3 {
  color: white;
  font-size: 1.125rem;
  font-weight: 600;
  margin: 0;
}

.progress-bars {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.progress-item {
  display: flex;
  flex-direction: column;
  gap: 0.75rem;
}

.progress-item span {
  font-size: 0.875rem;
  font-weight: 500;
  color: rgba(255, 255, 255, 0.9);
}

.progress-bar {
  height: 8px;
  background: rgba(255, 255, 255, 0.2);
  border-radius: 4px;
  overflow: hidden;
}

.progress-fill {
  height: 100%;
  background: linear-gradient(90deg, #10B981 0%, #FBBF24 100%);
  border-radius: 4px;
  animation: progress-animate 2s ease-out;
}

.floating-elements-hero {
  position: absolute;
  width: 100%;
  height: 100%;
}

.floating-element {
  position: absolute;
  width: 60px;
  height: 60px;
  background: rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: var(--radius-md);
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
}

.element-1 {
  top: -20%;
  right: 10%;
  animation: float-gentle 5s ease-in-out infinite;
}

.element-2 {
  bottom: -10%;
  left: -10%;
  animation: float-gentle 6s ease-in-out infinite reverse;
}

.element-3 {
  top: 50%;
  right: -15%;
  animation: float-gentle 7s ease-in-out infinite;
}

.floating-element svg {
  width: 24px;
  height: 24px;
}

/* === 기능 섹션 === */
.features-section {
  padding: 120px 0;
  background: var(--gray-50);
  position: relative;
}

.section-header {
  text-align: center;
  max-width: 800px;
  margin: 0 auto 5rem;
}

.section-badge {
  display: inline-flex;
  align-items: center;
  padding: 0.75rem 1.5rem;
  background: rgba(37, 99, 235, 0.1);
  color: var(--primary-blue);
  border-radius: 50px;
  font-size: 0.875rem;
  font-weight: 600;
  margin-bottom: 1.5rem;
}

.section-title {
  font-size: 3rem;
  font-weight: 800;
  color: var(--gray-900);
  margin-bottom: 1.5rem;
  line-height: 1.1;
  letter-spacing: -0.025em;
}

.section-description {
  font-size: 1.25rem;
  color: var(--gray-600);
  line-height: 1.6;
  margin: 0;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
  gap: 2rem;
  margin-bottom: 5rem;
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
}

.feature-card:hover {
  transform: translateY(-8px);
  box-shadow: var(--shadow-xl);
}

.feature-card-inner {
  padding: 2.5rem;
  position: relative;
  z-index: 2;
}

.feature-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 2rem;
}

.feature-icon {
  width: 64px;
  height: 64px;
  background: var(--gradient-primary);
  border-radius: var(--radius-lg);
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  box-shadow: var(--shadow-glow);
}

.feature-icon svg {
  width: 32px;
  height: 32px;
}

.feature-number {
  padding: 0.5rem 1rem;
  background: var(--gray-100);
  border-radius: var(--radius-sm);
  font-size: 0.875rem;
  font-weight: 700;
  color: var(--gray-600);
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

.feature-footer {
  border-top: 1px solid var(--gray-100);
  padding-top: 1.5rem;
}

.feature-stats {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.stat-label {
  font-size: 0.875rem;
  color: var(--gray-500);
  font-weight: 500;
}

.stat-value {
  font-size: 1.125rem;
  color: var(--primary-blue);
  font-weight: 700;
}

.feature-glow {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  height: 4px;
  background: var(--gradient-primary);
  opacity: 0;
  transition: var(--transition-smooth);
}

.feature-card:hover .feature-glow {
  opacity: 1;
}

/* === 통계 섹션 === */
.stats-section {
  background: white;
  border-radius: var(--radius-xl);
  padding: 3rem;
  box-shadow: var(--shadow-lg);
  border: 1px solid var(--gray-200);
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 2rem;
}

.stat-item {
  text-align: center;
}

.stat-number {
  font-size: 2.5rem;
  font-weight: 800;
  color: var(--primary-blue);
  margin-bottom: 0.5rem;
}

.stat-label {
  font-size: 0.875rem;
  color: var(--gray-600);
  font-weight: 500;
}

/* === CTA 섹션 === */
.cta-section {
  padding: 120px 0;
  position: relative;
  overflow: hidden;
}

.cta-background {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: linear-gradient(135deg, #1e40af 0%, #7c2d12 100%);
}

.cta-shapes {
  position: absolute;
  width: 100%;
  height: 100%;
}

.cta-shape {
  position: absolute;
  border-radius: 50%;
  opacity: 0.1;
}

.cta-shape.shape-1 {
  top: -20%;
  right: -10%;
  width: 400px;
  height: 400px;
  background: white;
  animation: float-slow 8s ease-in-out infinite;
}

.cta-shape.shape-2 {
  bottom: -30%;
  left: -15%;
  width: 600px;
  height: 600px;
  background: rgba(255, 255, 255, 0.5);
  animation: float-slow 10s ease-in-out infinite reverse;
}

.cta-shape.shape-3 {
  top: 50%;
  left: 50%;
  width: 200px;
  height: 200px;
  background: white;
  animation: float-gentle 6s ease-in-out infinite;
  transform: translate(-50%, -50%);
}

.cta-content {
  position: relative;
  z-index: 2;
  text-align: center;
  color: white !important;
  max-width: 800px;
  margin: 0 auto;
}

.cta-badge {
  display: inline-flex;
  align-items: center;
  padding: 0.75rem 1.5rem;
  background: rgba(255, 255, 255, 0.15);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: 50px;
  font-size: 0.875rem;
  font-weight: 600;
  margin-bottom: 2rem;
}

.cta-title {
  font-size: 3.5rem;
  font-weight: 800;
  line-height: 1.1;
  margin-bottom: 1.5rem;
  letter-spacing: -0.025em;
  color: white !important;
}

.cta-description {
  font-size: 1.25rem;
  line-height: 1.6;
  opacity: 0.9;
  margin-bottom: 2.5rem;
  color: white !important;
}

.cta-features {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 2rem;
  margin-bottom: 3rem;
}

.cta-feature {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  font-weight: 500;
}

.cta-feature-icon {
  width: 20px;
  height: 20px;
  color: var(--success-green);
}

.cta-actions {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 1.5rem;
}

.btn-cta-primary {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  padding: 1.5rem 3rem;
  background: linear-gradient(135deg, #FBBF24 0%, #F59E0B 100%);
  color: var(--gray-900);
  border: none;
  border-radius: var(--radius-md);
  font-size: 1.25rem;
  font-weight: 700;
  cursor: pointer;
  transition: var(--transition-bounce);
  box-shadow: 0 15px 30px rgba(251, 191, 36, 0.4);
}

.btn-cta-primary:hover {
  transform: translateY(-4px) scale(1.05);
  box-shadow: 0 20px 40px rgba(251, 191, 36, 0.5);
}

.btn-arrow {
  width: 20px;
  height: 20px;
  transition: var(--transition-smooth);
}

.btn-cta-primary:hover .btn-arrow {
  transform: translateX(3px);
}

.cta-info {
  text-align: center;
}

.cta-info-text {
  font-size: 0.875rem;
  opacity: 0.8;
  font-style: italic;
}

/* === 푸터 === */
.footer {
  background: var(--gray-900);
  color: white !important;
  padding: 80px 0 0;
}

.footer-content {
  border-bottom: 1px solid var(--gray-800);
  padding-bottom: 3rem;
  margin-bottom: 2rem;
}

.footer-main {
  display: grid;
  grid-template-columns: 1fr 2fr;
  gap: 4rem;
}

.footer-logo-container {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  margin-bottom: 1.5rem;
}

.footer-logo-image {
  width: 40px;
  height: 40px;
}

.footer-logo-text {
  font-size: 1.5rem;
  font-weight: 700;
  color: white;
  margin: 0;
}

.footer-description {
  font-size: 1rem;
  color: #D1D5DB;
  line-height: 1.6;
  margin-bottom: 2rem;
  max-width: 300px;
}

.footer-nav {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2rem;
}

.footer-nav-title {
  font-size: 1.125rem;
  font-weight: 600;
  color: white;
  margin-bottom: 1.5rem;
}

.footer-nav-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-nav-list li {
  margin-bottom: 0.75rem;
}

.footer-nav-link {
  color: #D1D5DB;
  text-decoration: none;
  font-size: 0.875rem;
  transition: var(--transition-smooth);
}

.footer-nav-link:hover {
  color: var(--primary-blue);
}

.footer-bottom {
  padding: 2rem 0;
}

.footer-bottom-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.footer-copyright {
  color: #D1D5DB;
  font-size: 0.875rem;
  margin: 0;
}

.footer-language-dropdown {
  padding: 0.5rem 1rem;
  background: var(--gray-800);
  border: 1px solid var(--gray-700);
  border-radius: var(--radius-sm);
  color: var(--gray-300);
  font-size: 0.875rem;
  cursor: pointer;
  transition: var(--transition-smooth);
}

.footer-language-dropdown:hover {
  border-color: var(--primary-blue);
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

@keyframes float-card {
  0%, 100% { transform: translateY(0px) rotateY(0deg); }
  50% { transform: translateY(-10px) rotateY(5deg); }
}

@keyframes progress-animate {
  from { width: 0%; }
  to { width: var(--width, 100%); }
}

/* === 반응형 디자인 === */
@media (max-width: 1024px) {
  .nav-buttons {
    display: none;
  }
  
  .mobile-menu-btn {
    display: block;
  }
  
  .hero-container {
    grid-template-columns: 1fr;
    gap: 4rem;
    text-align: center;
  }
  
  .hero-title {
    font-size: 3rem;
  }
  
  .section-title {
    font-size: 2.5rem;
  }
  
  .cta-title {
    font-size: 2.5rem;
  }
  
  .features-grid {
    grid-template-columns: 1fr;
  }
  
  .footer-main {
    grid-template-columns: 1fr;
    gap: 3rem;
  }
  
  .footer-nav {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .nav-container {
    padding: 0 1rem;
  }
  
  .hero-section {
    padding: 120px 0 80px;
  }
  
  .hero-container {
    padding: 0 1rem;
    gap: 3rem;
  }
  
  .hero-title {
    font-size: 2.5rem;
  }
  
  .section-title {
    font-size: 2rem;
  }
  
  .cta-title {
    font-size: 2rem;
  }
  
  .cta-features {
    flex-direction: column;
    gap: 1rem;
  }
  
  .footer-nav {
    grid-template-columns: 1fr;
    gap: 2rem;
  }
  
  .footer-bottom-content {
    flex-direction: column;
    gap: 1rem;
    text-align: center;
  }
  
  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
    gap: 1.5rem;
  }
  
  .hero-buttons {
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }
  
  .btn-hero-primary,
  .btn-hero-secondary {
    width: 100%;
    max-width: 280px;
    justify-content: center;
  }
}

@media (max-width: 480px) {
  .hero-title {
    font-size: 2rem;
  }
  
  .section-title {
    font-size: 1.75rem;
  }
  
  .cta-title {
    font-size: 1.75rem;
  }
  
  .stats-grid {
    grid-template-columns: 1fr;
  }
  
  .feature-card-inner {
    padding: 2rem;
  }
  
  .stats-section {
    padding: 2rem;
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
  .btn-primary,
  .btn-hero-primary,
  .btn-cta-primary {
    border: 2px solid currentColor;
  }
  
  .feature-card {
    border: 2px solid var(--gray-300);
  }
}
</style>