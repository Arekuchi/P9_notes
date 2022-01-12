FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} notes.jar
CMD ["java","-jar","/notes.jar"]
EXPOSE 8181