# Use an official OpenJDK runtime as a parent image
#FROM adoptopenjdk/openjdk17:alpine-jre
FROM eclipse-temurin:17-jdk-focal
# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container at /app
COPY target/instituteManagement-0.0.1-SNAPSHOT.jar /app


# Run the Spring Boot application when the container launches
CMD ["java", "-jar", "instituteManagement-0.0.1-SNAPSHOT.jar"]
