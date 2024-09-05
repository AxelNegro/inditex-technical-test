FROM openjdk:17-alpine
ARG JAR_FILE=target/technical-test-1.2.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]