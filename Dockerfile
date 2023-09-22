FROM amazoncorretto:17.0.8-al2
EXPOSE 8080
ADD target/spring-boot-docker.jar spring-boot-docker-jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]