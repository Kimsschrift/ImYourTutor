# ImYourTutor

PDF의 내용을 기반으로 공부할 수 있는 플랫폼입니다.

## 프로젝트 구조

- `backend/` - Spring Boot 기반 백엔드 API 서버
- `frontend/` - Vue.js 기반 프론트엔드 웹 애플리케이션

## 시작하기

### Backend 실행

```bash
cd backend
./gradlew bootRun
```

Windows의 경우:
```bash
cd backend
gradlew.bat bootRun
```

### Frontend 실행

```bash
cd frontend
npm install
npm run serve
```

## 기술 스택

### Backend
- Java 21
- Spring Boot 3.4.8
- Spring Security
- Spring Data JPA
- H2 Database

### Frontend
- Vue.js 3
- TypeScript
- Vue Router
- Vue CLI
