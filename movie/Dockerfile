FROM openjdk:17.0.2-jdk
VOLUME /tmp
COPY build/libs/movie-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]