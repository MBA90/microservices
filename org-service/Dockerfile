FROM openjdk:8-jdk-alpine

RUN  apk update && apk upgrade && apk add netcat-openbsd

RUN mkdir -p /usr/local/orgservice

ADD target/org-service-0.0.1-SNAPSHOT.jar /usr/local/orgservice

ADD docker/run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh

