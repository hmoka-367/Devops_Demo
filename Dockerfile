FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/devops-demo-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]
