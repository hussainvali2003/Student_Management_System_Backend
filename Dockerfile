# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built jar
COPY --from=build /app/target/studentrecordsystem-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app listens on
EXPOSE 9090

# Important: Bind to 0.0.0.0 so Render can connect
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=9090", "--server.address=0.0.0.0"]
