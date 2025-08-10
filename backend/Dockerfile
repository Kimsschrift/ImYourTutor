# Build stage
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew build -x test

# Runtime stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트는 Render에서 동적으로 할당
EXPOSE $PORT

# 애플리케이션 실행
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8081}", "-jar", "app.jar"]