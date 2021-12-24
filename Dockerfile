FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
COPY target/*.jar notes.jar
ENTRYPOINT ["java", "-jar", "/notes.jar"]