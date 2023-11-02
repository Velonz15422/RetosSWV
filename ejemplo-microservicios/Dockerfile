FROM eclipse-temurin:17-jdk-alpine

ARG WAR_FILE=./mascotas/target/*.jar

COPY ${WAR_FILE} webapp.jar

CMD ["java", "-Dspring.profiles.active=dev", "-jar", "webapp.jar"]

EXPOSE 8080