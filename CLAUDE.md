
# ImYourTutor - E-Klausur System

AI 기반 PDF 학습 및 시험 플랫폼입니다. PDF 문서를 업로드하여 자동으로 시험 문제를 생성하고, 다국어 지원으로 맞춤형 학습 경험을 제공합니다.

## 📋 현재 구현된 기능

- ✅ Google OAuth2 인증 시스템
- ✅ 사용자 관리 및 세션 관리
- ✅ Vue.js + TypeScript 프론트엔드
- ✅ Spring Boot + JPA 백엔드
- ✅ 기본 대시보드 UI

## 🚀 개발 로드맵 - E-Klausur System

### Phase 1: 기반 구조 확장 (1-2주)

#### Backend 확장
**새로운 엔티티 추가:**
```java
// PDF 문서 관리
PdfDocumentEntity: id, userId, fileName, originalName, fileSize, uploadDate, status
// 시험 관리  
ExamEntity: id, userId, pdfDocumentId, title, questionCount, language, status, createdDate
// 문제 관리
QuestionEntity: id, examId, type, content, options, correctAnswer, points
// 답안 및 결과
AnswerEntity: id, examId, userId, questionId, userAnswer, isCorrect, points
ExamResultEntity: id, examId, userId, totalScore, completedDate
// 사용자 설정
UserSettingsEntity: id, userId, preferredLanguage, createdDate, updatedDate
```

**필수 의존성 추가:**
```gradle
// build.gradle에 추가
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'com.google.ai:generative-ai:0.4.0' // Gemini API
implementation 'org.apache.pdfbox:pdfbox:2.0.29'   // PDF 처리
implementation 'commons-io:commons-io:2.11.0'       // 파일 처리
```

**API 엔드포인트 설계:**
```
POST /api/pdf/upload          - PDF 파일 업로드
GET  /api/pdf/list           - 사용자의 PDF 목록
DELETE /api/pdf/{id}         - PDF 삭제

POST /api/exam/generate      - 시험 생성 (PDF + 설정)
GET  /api/exam/list          - 시험 목록
GET  /api/exam/{id}          - 특정 시험 조회
POST /api/exam/{id}/start    - 시험 시작
POST /api/exam/{id}/submit   - 답안 제출

GET  /api/user/settings      - 사용자 설정 조회
PUT  /api/user/settings      - 사용자 설정 업데이트
```

#### Frontend 확장
**새로운 Vue 컴포넌트:**
```
views/
├── PDFUploadView.vue        - PDF 업로드 페이지
├── ExamListView.vue         - 시험 목록 페이지
├── ExamConfigView.vue       - 시험 설정 페이지
├── ExamTakingView.vue       - 시험 진행 페이지
├── ExamResultView.vue       - 결과 페이지
└── SettingsView.vue         - 사용자 설정 페이지

components/
├── PDFUploader.vue          - 파일 업로드 컴포넌트
├── QuestionComponent.vue    - 문제 표시 컴포넌트
├── LanguageSelector.vue     - 언어 선택 컴포넌트
└── ProgressBar.vue          - 진행률 표시
```

**Pinia Store 확장:**
```typescript
// stores/pdf.ts - PDF 관리
// stores/exam.ts - 시험 관리  
// stores/settings.ts - 사용자 설정
```

### Phase 2: PDF 처리 및 Gemini API 통합 (2-3주)

#### PDF 처리 시스템
```java
@Service
public class PdfProcessingService {
    // PDF 텍스트 추출
    String extractTextFromPdf(MultipartFile file)
    // PDF 메타데이터 추출
    PdfMetadata extractMetadata(MultipartFile file)
    // 파일 저장 및 관리
    String savePdfFile(MultipartFile file, String userId)
}
```

#### Gemini API 통합
```java
@Service  
public class GeminiService {
    // 문제 생성 요청
    List<Question> generateQuestions(String pdfContent, QuestionConfig config)
    // 답안 평가 
    ExamResult evaluateAnswers(List<Answer> answers, String language)
    // 다국어 번역
    String translateContent(String content, String targetLanguage)
}
```

**문제 생성 설정 구조:**
```java
public class QuestionConfig {
    private int totalQuestions;        // 5 or 10
    private String language;           // ko, de, en
    private int multipleChoiceRatio;   // %
    private int essayRatio;           // %
    private int fillBlankRatio;       // %
}
```

### Phase 3: 문제 생성 및 시험 시스템 (2-3주)

#### 지능형 문제 생성
```java
public enum QuestionType {
    MULTIPLE_CHOICE,    // 객관식
    ESSAY,             // 서술형
    FILL_IN_BLANK      // 빈칸 채우기
}
```

**Gemini API 프롬프트 템플릿:**
```
다국어 지원 프롬프트:
- Korean: "다음 PDF 내용을 바탕으로 {questionCount}개의 문제를 생성하세요..."
- German: "Basierend auf dem folgenden PDF-Inhalt erstellen Sie {questionCount} Fragen..."  
- English: "Based on the following PDF content, generate {questionCount} questions..."
```

#### 시험 진행 시스템
```typescript
// 시험 상태 관리
interface ExamState {
  currentQuestion: number;
  answers: Map<number, string>;
  timeRemaining: number;
  isCompleted: boolean;
}
```

### Phase 4: 평가 시스템 및 결과 분석 (1-2주)

#### 자동 평가 시스템
```java
@Service
public class ExamEvaluationService {
    // 객관식 자동 채점
    int scoreMultipleChoice(List<Answer> answers)
    // 서술형 Gemini API 평가  
    List<EssayScore> scoreEssayQuestions(List<EssayAnswer> answers, String language)
    // 최종 점수 계산 (100점 만점)
    ExamResult calculateFinalScore(List<Answer> answers)
}
```

**점수 계산 로직:**
- 문제당 10점 (5문제 = 50점 만점 → 100점 환산, 10문제 = 100점 만점)
- 객관식: 정답/오답 이진 평가
- 서술형: Gemini API 0-10점 평가
- 빈칸 채우기: 키워드 매칭 + 유사도 평가

### Phase 5: 다국어 지원 시스템 (1-2주)

#### i18n 구현
**Backend:**
```java
@Service
public class LocalizationService {
    String getMessage(String key, String language);
    String translateText(String text, String fromLang, String toLang);
}
```

**Frontend:**
```typescript
// i18n 설정
const messages = {
  ko: { /* 한국어 메시지 */ },
  de: { /* 독일어 메시지 */ },  
  en: { /* 영어 메시지 */ }
}
```

### Phase 6: UI/UX 개선 및 최적화 (1-2주)

#### 사용자 경험 개선
- 드래그 앤 드롭 PDF 업로드
- 실시간 시험 진행률 표시
- 반응형 디자인 개선
- 로딩 상태 및 에러 처리 강화

#### 성능 최적화
- PDF 처리 비동기화
- 파일 저장소 최적화 (로컬 → 클라우드)
- API 응답 캐싱
- 이미지 및 정적 자원 최적화

## 📁 프로젝트 구조 (개발 완료 후)

```
ImYourTutor/
├── backend/
│   ├── src/main/java/com/imyourtutor/backend/
│   │   ├── controller/
│   │   │   ├── AuthController.java
│   │   │   ├── PdfController.java
│   │   │   ├── ExamController.java
│   │   │   ├── UserController.java
│   │   │   └── SettingsController.java
│   │   ├── service/
│   │   │   ├── UserService.java
│   │   │   ├── PdfProcessingService.java
│   │   │   ├── GeminiService.java
│   │   │   ├── ExamService.java
│   │   │   ├── ExamEvaluationService.java
│   │   │   └── LocalizationService.java
│   │   ├── entity/
│   │   │   ├── UserEntity.java
│   │   │   ├── PdfDocumentEntity.java
│   │   │   ├── ExamEntity.java
│   │   │   ├── QuestionEntity.java
│   │   │   ├── AnswerEntity.java
│   │   │   ├── ExamResultEntity.java
│   │   │   └── UserSettingsEntity.java
│   │   ├── repository/
│   │   ├── dto/
│   │   ├── config/
│   │   └── util/
│   └── src/main/resources/
│       ├── application.yml
│       ├── messages/
│       │   ├── messages_ko.properties
│       │   ├── messages_de.properties
│       │   └── messages_en.properties
│       └── static/uploads/
└── frontend/
    ├── src/
    │   ├── views/
    │   │   ├── LoginView.vue
    │   │   ├── DashboardView.vue
    │   │   ├── PDFUploadView.vue
    │   │   ├── ExamListView.vue
    │   │   ├── ExamConfigView.vue
    │   │   ├── ExamTakingView.vue
    │   │   ├── ExamResultView.vue
    │   │   └── SettingsView.vue
    │   ├── components/
    │   │   ├── PDFUploader.vue
    │   │   ├── QuestionComponent.vue
    │   │   ├── LanguageSelector.vue
    │   │   ├── ProgressBar.vue
    │   │   └── ResultChart.vue
    │   ├── stores/
    │   │   ├── auth.ts
    │   │   ├── pdf.ts
    │   │   ├── exam.ts
    │   │   └── settings.ts
    │   ├── services/
    │   │   ├── api.ts
    │   │   ├── auth.ts
    │   │   ├── pdf.ts
    │   │   ├── exam.ts
    │   │   └── gemini.ts
    │   ├── i18n/
    │   │   ├── index.ts
    │   │   ├── ko.json
    │   │   ├── de.json
    │   │   └── en.json
    │   └── assets/
    └── public/
```

## 🛠 시작하기

### Prerequisites
```bash
# 환경 변수 설정 (.env)
GOOGLE_CLIENT_ID=your_google_client_id
GOOGLE_CLIENT_SECRET=your_google_client_secret  
GEMINI_API_KEY=your_gemini_api_key
FRONTEND_URL=http://localhost:8080
```

### Backend 실행
```bash
cd backend
./gradlew bootRun          # Linux/Mac
# 또는
gradlew.bat bootRun       # Windows
```

### Frontend 실행
```bash
cd frontend
npm install
npm run serve
```

### 접속 정보
- Frontend: http://localhost:8080
- Backend API: http://localhost:8081
- H2 Console: http://localhost:8081/h2-console

## 🧪 테스트

### Backend 테스트
```bash
cd backend
./gradlew test
```

### Frontend 린트 및 테스트
```bash
cd frontend
npm run lint
npm run test      # (개발 예정)
```

## 🎯 핵심 기능

### 1. PDF 기반 학습
- PDF 업로드 및 텍스트 추출
- 자동 문제 생성 (Gemini AI)
- 다양한 문제 유형 지원

### 2. 맞춤형 시험 시스템
- 문제 수 선택 (5문제/10문제)
- 문제 유형 비율 설정
- 실시간 시험 진행

### 3. 지능형 평가
- 자동 채점 시스템
- AI 기반 서술형 평가
- 100점 만점 점수 환산

### 4. 다국어 지원
- 한국어, 독일어, 영어 지원
- 문제 및 평가 다국어 처리
- 사용자별 언어 설정

## 🔧 기술 스택

### Backend
- **Language:** Java 21
- **Framework:** Spring Boot 3.4.8
- **Security:** Spring Security + OAuth2
- **Database:** H2 Database + JPA
- **AI Integration:** Google Gemini API
- **PDF Processing:** Apache PDFBox
- **Build Tool:** Gradle

### Frontend
- **Framework:** Vue.js 3 + TypeScript
- **State Management:** Pinia
- **Routing:** Vue Router 4
- **HTTP Client:** Axios
- **Internationalization:** Vue I18n
- **Styling:** Sass + CSS3
- **Build Tool:** Vue CLI

## 📈 개발 일정

| Phase | 기간 | 주요 작업 |
|-------|------|----------|
| Phase 1 | 1-2주 | 기반 구조 확장, 엔티티 설계, API 설계 |
| Phase 2 | 2-3주 | PDF 처리, Gemini API 통합 |  
| Phase 3 | 2-3주 | 문제 생성, 시험 시스템 구현 |
| Phase 4 | 1-2주 | 평가 시스템, 결과 분석 |
| Phase 5 | 1-2주 | 다국어 지원 시스템 |
| Phase 6 | 1-2주 | UI/UX 개선, 성능 최적화 |

**총 개발 기간:** 8-14주

## 🚦 진행 상황

- ✅ Google OAuth2 인증 시스템
- ✅ 기본 사용자 관리
- ✅ Vue.js 프론트엔드 구조
- ⏳ PDF 업로드 시스템 (Phase 1)
- ⏳ Gemini API 통합 (Phase 2)
- ⏳ 문제 생성 시스템 (Phase 3)
- ⏳ 평가 및 채점 시스템 (Phase 4)
- ⏳ 다국어 지원 (Phase 5)
- ⏳ UI/UX 최적화 (Phase 6)

---

*이 프로젝트는 AI 기반 교육 플랫폼으로, PDF 문서를 활용한 개인 맞춤형 학습 경험을 제공합니다.*
