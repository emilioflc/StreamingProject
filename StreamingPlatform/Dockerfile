FROM openjdk:8
EXPOSE 8080
ADD target/streaming-platform-docker.jar streaming-platform-docker.jar
ENTRYPOINT [ "java", "-jar", "/streaming-platform-docker.jar" ]