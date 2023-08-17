FROM openjdk:17-jdk-alpine

LABEL maintainer="Aayush M <aayushmeshram.9003@gmail.com>"

RUN mkdir /app

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]