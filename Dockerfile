# Use OpenJDK 21 as base image
FROM openjdk:21

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

# Run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
