FROM openjdk:17-jdk-alpine
COPY /target/spring-boot-docker.jar java-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","java-app.jar"]