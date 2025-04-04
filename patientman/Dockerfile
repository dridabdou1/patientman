# Use an official Maven image with OpenJDK 17
FROM maven:3.8.5-openjdk-17 AS builder

# Set working directory
WORKDIR /app

# Copy maven configuration files first for better layer caching
COPY pom.xml .
COPY .mvn/ .mvn/
COPY mvnw .

# Install dependencies separately (for better layer caching)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src/ ./src/

# Package the application but skip tests to speed up build
RUN mvn clean package -DskipTests

# Use a smaller JRE image for the final image
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port 4000
EXPOSE 4000

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]