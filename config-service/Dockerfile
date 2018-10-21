FROM openjdk:8-jdk-alpine

RUN  apk update && apk upgrade && apk add netcat-openbsd

RUN mkdir -p /usr/local/configservice

ADD target/config-service-0.0.1-SNAPSHOT.jar /usr/local/configservice

ADD docker/run.sh run.sh

RUN chmod +x run.sh

CMD ./run.sh