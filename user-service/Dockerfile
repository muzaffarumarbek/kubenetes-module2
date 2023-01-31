FROM openjdk:11 AS jre-build
WORKDIR /app
COPY /build/libs/user-service.jar app.jar
EXPOSE 8080
CMD java -jar app.jar