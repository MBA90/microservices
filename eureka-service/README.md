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
4-Now you can run this command in terminal however navigate where eureka pom.xml file located, in browser type this URL <b>http://localhost:8761/<b/>

```
mvn spring-boot:run
```
Up to here i build spring eureka server, and now i need to register the services in eureka serivce.

 
