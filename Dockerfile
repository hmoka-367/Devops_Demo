FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/devops-demo-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
EXPOSE 8081  # Expose port 8080 for HTTP requests
ENTRYPOINT ["java", "-jar", "app.jar"]
