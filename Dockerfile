# Build the app
FROM openjdk:8-jdk-alpine AS builder

ENV APP frameskip

RUN adduser -S "${APP}"
WORKDIR /home/"${APP}"
USER "${APP}"

CMD ["gradle", "build"]
COPY build/libs/frameskip-1.0-SNAPSHOT.jar app.jar

# Run the app
FROM openjdk:8-jre-alpine

ENV APP frameskip

RUN adduser -S "${APP}"
WORKDIR /home/"${APP}"
USER "${APP}"

COPY --from=builder /home/frameskip/app.jar /home/frameskip/app.jar

CMD ["java", "-jar", "/home/frameskip/app.jar"]
