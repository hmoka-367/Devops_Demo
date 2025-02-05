# Use an OpenJDK base image
FROM openjdk:11-jre-slim

# Install X11 libraries to allow GUI applications to display on the host machine
RUN apt-get update && apt-get install -y \
    libx11-dev \
    libxtst6 \
    libxi6 \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy Java file and image to container
COPY DisplayImage.java .
COPY image.jpg .

# Install Maven to compile the Java file
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Compile the Java program
RUN javac DisplayImage.java

# Set the entrypoint to run the Java program
ENTRYPOINT ["java", "DisplayImage"]
