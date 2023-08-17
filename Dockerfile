FROM openjdk:17-jdk-alpine

LABEL maintainer="Your Name <your@email.com>"

RUN mkdir /app

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]