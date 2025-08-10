# Render-specific Dockerfile
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copy gradle wrapper and build files
COPY gradlew gradlew.bat ./
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./

# Copy source code
COPY src/ src/

# Make gradlew executable and build
RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

# Runtime stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# Render uses dynamic port assignment
EXPOSE $PORT

# Run application with dynamic port
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8081}", "-jar", "app.jar"]