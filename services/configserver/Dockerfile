FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package

FROM openjdk:21-jdk-slim

WORKDIR /app
COPY --from=build /app/target/configserver-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8888

ENTRYPOINT ["java", "-jar", "app.jar"]
