FROM openjdk:11-jre
MAINTAINER Jean Sampaio <jean.sampaio@gmail.com>

VOLUME /tmp

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} comment-service.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/comment-service.jar"]