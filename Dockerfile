# syntax=docker/dockerfile:1

FROM openjdk:8u102-jdk

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=postgres"]

