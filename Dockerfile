FROM openjdk:8-jdk-alpine

ENV APP frameskip

RUN adduser -S "${APP}"
WORKDIR /home/"${APP}"
USER "${APP}"

COPY build/libs/frameskip-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/home/frameskip/app.jar"]
