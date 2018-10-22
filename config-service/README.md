# Configuration server

People who works in microservices project especially if there projects are hosted in containers platforms such as docker have a problem where to put there service configuration and how to make it dynamic, remember that after building docker image and pushing this image to some kind of docker image repository it become immutable and you can't modify it, so what can we do to achieve such goal.

Spring provides a solution for this with module called "Spring Boot Cloud Server", it allows you to encapsulate all your configuration files for all your services and put it in a centralized place, and provide clients for your services to communicate with configuration server.

### Configuration server config files setup
In this repository i am using file system module for development only, if you want to run Configuration server in production it is recommended to do this through GIT which by default gives you versions feature for your configuration file.

Check application.yml resource file, I used classpath files as configuration files for my project.

#### Configuration server setup
1-Set environment variable "ENCRYPT_KEY" Or add <b>encrypt.key</b> in <b>bootstrap.yml</b> to a value which will represents your encryption key.

```
encrypt: 
  key: "mykey" 
```

2-Start your configuration server and check server logs, you will find URLS "/encrypt [POST]" & "/decrypt [POST]", you can encrypt your properties using these urls. 
3-Disable the server-side decryption of properties in Spring Cloud Config. This is done by setting the Spring Cloud Config’s src/main/ resources/bootstrap.yml file to set the property spring.cloud.config.server.encrypt.enabled: false. That’s all you have to do on the Spring Cloud Config server.


```
spring:
  cloud:
     config:
       server:
           encrypt:
              enabled: false
```

if you leave it as its default value "true" then when you call configuration url "http://host:port/{service}/{profile}" it will return property decrypted which is a behavior that we don't want it on production for sure.

#### Consumer server setup (ex:licensing-service)
1-Set environment variable "ENCRYPT_KEY" Or add <b>encrypt.key</b> in <b>bootstrap.yml</b> to same key value as configuration server.

```
encrypt: 
  key: "mykey" 
```

2-Add the below RSA dependencies to enable properties decryption on server side :

```
	<dependency>
	    <groupId>org.springframework.security</groupId>
	    <artifactId>spring-security-rsa</artifactId>
	    <version>1.0.7.RELEASE</version>
	</dependency>
```
