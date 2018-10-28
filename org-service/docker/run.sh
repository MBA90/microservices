#!/bin/sh
echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIG_SERVICE_PORT"
echo "********************************************************"
while ! `nc -z configser $CONFIG_SERVICE_PORT `; do sleep 3; done
echo ">>>>>>>>>>>> Configuration Server has started"

echo "********************************************************"
echo "Waiting for the database server to start on port $DATABASE_SERVER_PORT"
echo "********************************************************"
while ! `nc -z db $DATABASE_SERVER_PORT`; do sleep 3; done
echo ">>>>>>>>>>>> Database Server has started"

echo "********************************************************"
echo "MBA Microservices "
echo "Starting Org Service + Configuration Service CONFIG_SERVICE_URI and PROFILE: dev" 
echo "********************************************************"
java -Dspring.cloud.config.uri=$CONFIG_SERVICE_URI \
	 -Dspring.profiles.active=$PROFILE \
	 -jar /usr/local/orgservice/org-service-0.0.1-SNAPSHOT.jar
	 