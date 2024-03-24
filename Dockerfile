FROM khipu/openjdk17-alpine:latest
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean build
EXPOSE 8080
CMD ["java", "-jar", "build/libs/support-service-0.0.1.jar"]
RUN adduser -D 10001
USER 10001
