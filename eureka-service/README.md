# Eureka Service Discovery

## Distributed Architecture & Service Discovery
In any distributed architecture, we need to find the physical address of where a machine is located. This concept has been around since the beginning of distributed computing and is known formally as service discovery. Service discovery can be something as simple as maintaining a property file with the addresses of all the remote services used by an application, or something as formalized (and complicated) as a UDDI (Universal Description, Discovery, and Integration) repository

## Service Discovery in Non-cloud-based environment
Whenever you have an application calling resources spread across multiple servers, it needs to locate the physical location of those resource. In the non-cloud world, this service location resolution was often solved through a combination of DNS and a net- work load balancer. Figure 4.1 illustrates this model.

However, in the cloud where you have to deal with massive amounts of transactions and redundancy, a centralized piece of network infrastructure doesn’t ultimately work as well because it doesn’t scale effectively and isn’t cost-efficient. Let’s now look at how you can implement a robust-service discovery mechanism for cloud- based applications.

## Service Discovery in cloud-based microservice environment
The solution for a cloud-based microservice environment is to use a service-discovery mechanism that’s:
1-Highly available
2-Peer-to-peer
3-Load balanced
4-Resilient
5-Fault-tolerant

### The architecture of service discovery
To get the big picture of service discovery architecture, you need to understand four concepts. 
These general concepts are shared across all <b>service discovery implementations</b>:
1-Service registration
2-Client lookup of service address
3-Information sharing
4-Health monitoring

### Implement Service Discovery using Spring Eureka Service as server
1-Add the following dependency in pom.xml file.

```
<dependencies>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-eureka-server</artifactId>
		<version>1.4.6.RELEASE</version>
	</dependency>
</dependencies>
```
2-Add the following properties in application.yml file under resources.

```
server:
   port: 8761 
eureka:
   client:
      registerWithEureka: false 
      fetchRegistry: false 
   server: 
      waitTimeInMsWhenSyncEmpty: 5
```

3-Add Application bootstrap class to start eureka service.
4-Now you can run this command in terminal however navigate where eureka pom.xml file located, in browser type this URL <b> http://localhost:8761/ <b/>

```
mvn spring-boot:run
```

To make sure Eureka service is up and running hit the following url in browser. 

```
http://localhost:8761
```

### Registering services with Spring Eureka

At this point i have a Spring-based Eureka server up and running.
Now, i will configure orgnaization and licensing services to register themselves with eureka server.
This work is done in preparation for having a service client look up a service from your Eureka registry.

1-Add the Spring Eureka client dependency org-service pom.xml.

 ```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

2-Tell Spring Boot to register the organization service with Eureka, you can achieve that by add the following configuration in bootstrap.yml. 

```
eureka:
   instance:
      perferIpAddress: true # Register the IP of the service rather than the server name.
   client:
      registerWithEureka: true # Register the service with Eureka.
      fetchRegistry: true # Pull down a local copy of the registry.
      serviceUrl:
         defaultZone: http://localhost:8761/eureka/ # Location of the Eureka Service.
```

##### At this point i have a single service registered with your Eureka service.

I can use Eureka’s REST API to see the contents of the registry. To see all the instances of a service, hit the following GET endpoint:

```
http://<eureka service>:8761/eureka/apps/<APPID>
```

For instance, to see the organization service in the registry you can call 

```
http://localhost:8761/eureka/apps/orgservice.
```

### Using service discovery to look up a service
Now i have the organization and licensing service registered with Eureka. I can also have the licensing service call the organization service without having direct knowledge of the location of any of the organization services. The licensing service will look up the physical location of the organization by using Eureka.

#### Three different Spring/Netflix client libraries in which a service consumer can interact with Ribbon
* Spring Discovery client.
* Spring Discovery client enabled RestTemplate.
* Netflix Feign client.

In this project i used the second option (<b>Spring Discovery client enabled RestTemplate</b>) as service consumer.

#### Invoking services with Ribbon-aware Spring RestTemplate
* To use a Ribbon-aware RestTemplate class, you need to define a Rest- Template bean construction method with a Spring Cloud annotation called @Load- Balanced. For the licensing service. 
[Apliication.java](https://github.com/MBA90/microservices/blob/master/licensing-service/src/main/java/com/mba/license/Application.java)

* to build the target URL using the Eureka service ID of the service you want to call.
[OrganizationRestTemplateClient.java](https://github.com/MBA90/microservices/blob/master/licensing-service/src/main/java/com/mba/license/service/client/OrganizationRestTemplateClient.java)

For more about service consuming using Spring Discovery client enabled RestTemplate, you can check licensing-service.


