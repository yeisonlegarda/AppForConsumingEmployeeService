FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 92
ARG PROJECT
ARG VERSION
COPY ./target/ThalesTestREST-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]