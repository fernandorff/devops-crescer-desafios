FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /app/target/hellodocker-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 9320
CMD ["java", "-jar", "/app/app.jar"]