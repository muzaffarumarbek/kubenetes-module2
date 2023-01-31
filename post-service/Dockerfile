FROM openjdk:11 AS jre-build
CMD ls
WORKDIR /app
COPY /build/libs/post-service.jar app.jar

EXPOSE 8081
CMD java -jar app.jar