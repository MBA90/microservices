FROM openjdk:8-jdk-alpine

RUN  apk update && apk upgrade && apk add netcat-openbsd && apk add curl

# Add JCE 8 Jar files required for encyrpt & decrypt
RUN cd /tmp/ && curl -k -LO "http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip" -H 'Cookie: oraclelicense=accept-securebackup-cookie'\ 
	&& unzip jce_policy-8.zip && rm jce_policy-8.zip
RUN cp -v /tmp/UnlimitedJCEPolicyJDK8/*.jar /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/

RUN mkdir -p /usr/local/configservice

ADD target/config-service-0.0.1-SNAPSHOT.jar /usr/local/configservice

ADD docker/run.sh run.sh

RUN chmod +x run.sh

CMD ./run.sh