# Microservices 

This project was initiated to apply best practices and patterns for microservices using Spring Boot technology.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system, for my example i am using Linux CentOS 7, Other OS should have similar steps.

### Prerequisites

* [Java 8+](http://openjdk.java.net/install/) - Programming language
* [Maven](https://maven.apache.org/) - Dependency Management 
* [Docker](https://www.docker.com/) - Containerization tool
* [Docker-Compose](https://docs.docker.com/compose/install/) - Container Orchestration tool
* [MySql](https://dev.mysql.com/downloads/workbench/) - RDBMS (or you can choose any DB that you are comfortable with)

### Before you start

Take a good look on docker and docker-compose, try to build your docker image, deploy it to docker and run it, and try using docker-compose to run your image with other data image (ex: db image).

Since we are learning and practicing microservices, it is highly recommended to know about docker, thats why i am asking you to do the above.  

### Installing

#### Installing Java
First you need to check what java version installed on your machine, in your terminal type :
```
java -version
```

if output contains 'jre' keywork then you need to install java jdk version, you can follow this site
for java installation [How to install java on macOS](https://tecadmin.net/install-java-8-on-centos-rhel-and-fedora/).

#### Installing Maven
After Java JDK version is being installed, we need to install Maven from Apache site, in your terminal type :

```
cd /usr/local
wget http://www-eu.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz
```

Now Extract your downloaded file :

```
sudo tar xzf apache-maven-3.5.4-bin.tar.gz
sudo ln -s apache-maven-3.5.4 maven
```
Once your extraction is finished successfully we'll set environment variables for maven :

```
sudo vi /etc/profile.d/maven.sh
```

after opening file using vim tool (vi), click on 'i' keyboard, this will activate vi in editing mode, 
navigate to the end of your file and type :

```
export M2_HOME=/usr/local/maven
export PATH=${M2_HOME}/bin:${PATH}
```
then click on 'esc' button and type ' :wq ', it is a command shortcut to write and quit.

reload your environment variables with this command :

```
source /etc/profile.d/maven.sh
```

check your installation by typing 'mvn -version', you should see output similar to the below  :

```
Apache Maven 3.5.4 (1edded0938998edf8bf061f1ceb3cfdeccf443fe; 2018-06-17T22:33:14+04:00)
Maven home: /usr/local/maven
Java version: 1.8.0_181, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.6", arch: "x86_64", family: "mac"
Muhammads-MacBook-Pro:~ MBA$ 
```

#### Installing Docker
For installing docker, follow docker documentation on their official [website](https://docs.docker.com/docker-for-mac/install/), and choose your OS from left menu.

#### Installing Docker Compose
In your terminal run the below command :

```
sudo curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
```

Then add executable permissions to your binary :

```
sudo chmod +x /usr/local/bin/docker-compose
```

Test your installation :

```
docker-compose --version
```

## Project structure

#### mba-microservices
1-[licensing-service](https://github.com/MBA90/microservices/tree/master/licensing-service)
2-[config-service] (https://github.com/MBA90/microservices/tree/master/config-service)
	
Project is consisted of main project (mba-microservices) and it contain each service as a sub module also there is <b>config-service</b> which will be used as a centralized config service provider.

Microservices main project contains pom.xml which includes sub modules definition, common properties, dependencies and plugins.

Common plugins in main projects are :

1- <b>Maven Dockerfile plugin</b> : this plugin reads Dockerfile in your project class path and it can build & deploy docker images, this plugin is not included in the main project, it is included in each service of your project, to build and deploy docker image navigate to your service (ex:confsrv) then run the below where Dockerfile & pom.xml exists :

```
mvn package
```

### Running services locally (without docker)
1-First you need to run configuration server, navigate to /config-service folder and run :

```
mvn spring-boot:run
```
for more information about configuration server check config-service [README.md](https://github.com/mba/microservices/tree/master/config-service).

2-Then you can run any service after that with the same way

### Running services with docker
1-Make sure that you've created and deployed your image successfully to docker using mvn deploy command.
2-At the root main project (microservices) you'll find docker-compose.yml file, in your command line type :

```
docker-compose up
```
This command will create docker network adapters between services inside and start them together, then services can integrate with each other internally by name (licensingser,configser & db). 

examine service "licensingser" attributes and check attribute <b>depends_on</b>, in this attribute you define services that licensingser needs before starting up,it will fire db & configser services then starts licensingser.

Seems fine now, we are assuring that licensingser will start after db & configser is up, but is that enough !!!.

Actually no it is not, service configser will really starts before licensingser, but the problem that configser needs time to start up and running,to completely finish it start up process and if licensingser try to boot while configser is not ready yet licensingser will shutdown with error code because configser is not ready yet, so we are in trouble here. 

licensingser needs configser up and running and in a healthy state, how can we assure such check before really starts licensingser !!!.

Check licensing-service [Dockerfile](https://github.com/mba/microservices/tree/master/licensing-service)

## Building tools

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributing

Participating in project are most welcome, but no direct push to master, just a reviewed pull request will be merged into master,
committed code should be well formatted and documented.

## Authors

* **Muhammad Abdelhadi** - *Initial work* - [MBA90](https://github.com/MBA90)

## License

This project is licensed under the GPL License - see the [LICENSE.md](https://github.com/mba90/microservices/blob/master/LICENSE) file for details

## References
<b>Spring microserivces in action</b> book - by - <b>John Carnell</b>.
