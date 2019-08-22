#FROM openjdk:8-jdk-alpine
FROM gradle:4.4.0-jdk8-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

#WORKDIR /app
#ADD --chown=gradle:gradle . /home/gradle/src
#
#RUN ./gradlew build docker--stacktrace



FROM openjdk:8-jdk-alpine

VOLUME /tmp


EXPOSE 161

RUN mkdir /app
#ARG JAR_FILE

COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar
#ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


#ARG JAR_FILE
#ADD ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","app.jar"]