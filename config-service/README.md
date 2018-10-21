# Configuration server

People who works in microservices project especially if there projects are hosted in containers platforms such as docker have a problem where to put there service configuration and how to make it dynamic, remember that after building docker image and pushing this image to some kind of docker image repository it become immutable and you can't modify it, so what can we do to achieve such goal.

Spring provides a solution for this with module called "Spring Boot Cloud Server", it allows you to encapsulate all your configuration files for all your services and put it in a centralized place, and provide clients for your services to communicate with configuration server.

### Configuration server config files setup
In this repository i am using file system module for development only, if you want to run Configuration server in production it is recommended to do this through GIT which by default gives you versions feature for your configuration file.

Check application.yml resource file, I used classpath files as configuration files for my project.
