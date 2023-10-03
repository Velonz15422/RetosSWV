FROM eclipse-temurin:17-jdk-alpine

ARG WAR_FILE=./target/*.jar

COPY ${WAR_FILE} webapp.jar

CMD ["java", "-Dspring.profiles.active=dev", "-jar", "webapp.jar"]
