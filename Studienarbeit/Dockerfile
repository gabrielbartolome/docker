FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/gs-maven-0.1.0.jar
COPY ${JAR_FILE} buchungssystem.jar
ENTRYPOINT ["java","-jar","/buchungssystem.jar"]
