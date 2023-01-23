#
# Build stage
#
FROM maven:3.6.3-jdk-11 AS build
COPY . .

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/school-management-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]