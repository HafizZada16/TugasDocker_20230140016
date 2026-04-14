# Stage 1: Build the application
FROM openjdk:25-ea-slim
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
