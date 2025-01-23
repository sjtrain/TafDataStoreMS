FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY build/libs/DataStoreMS.jar app.jar


# Expose the port your application runs on
EXPOSE 8090

# Define the entry point to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]