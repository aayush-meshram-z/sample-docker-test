FROM openjdk:17-jdk-alpine

LABEL maintainer="Aayush M <aayushmeshram.9003@gmail.com>"

RUN java -version

COPY . /usr/src/myapp/
WORKDIR /usr/src/myapp/
RUN set -Eeux \
    && apk --no-cache add maven \
    # smoke test to verify if maven is available
    && mvn --version
RUN mvn package

# Stage 2 (to create a downsized "container executable", ~180MB)
FROM eclipse-temurin:17-jre-alpine
RUN apk --no-cache add ca-certificates
WORKDIR /root/
COPY --from=builder /usr/src/OTT-App/target/app.jar .

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "./app.jar"]