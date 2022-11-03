FROM openjdk:17-alpine
EXPOSE 8080
COPY build/libs/library-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "library-0.0.1-SNAPSHOT.jar"]