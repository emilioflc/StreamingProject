FROM openjdk:16
VOLUME /tmp
ADD target/streaming-project.jar streaming-project.jar
ADD wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/streaming-project.jar"]
