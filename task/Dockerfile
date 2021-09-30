FROM frolvlad/alpine-java:jdk8-cleaned
ARG NAME
ENV NAME=$NAME
COPY /target/task-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
