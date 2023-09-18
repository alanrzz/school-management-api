FROM amazoncorretto:17.0.8-al2
WORKDIR /app
COPY --from=build /target/school-management-0.0.1-SNAPSHOT.jar school-management.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080