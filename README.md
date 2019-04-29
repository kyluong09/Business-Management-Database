# Business Management Database

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

** Project's for education purposes at University of Wisconsin - Parkside
BMDB is a full-stack template with combination of Java | Maven | Spring Framework. This can be used for starter to create a complete build-in business structure, CRUD operations, authentication, Restful API.


# Technologies
- [Spring Framework](https://spring.io/) (Core, Spring Boot, Spring MVC, Spring REST, Spring Security, JPA)
- [Java SE 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Runtime Enviroment
- [Apache Maven](https://maven.apache.org/) - Build automation tool
- [Bootstrap](https://getbootstrap.com/) - CSS & Javacript template
- [MySQL](https://www.mysql.com/) - SQL database management system
- [Apache Maven](https://maven.apache.org/) - Build automation tool
- [Thymleaf](https://www.thymeleaf.org/) - Java XML/XHTML/HTML5 template Engine

# Installation
#### GIT
DMDB requires [Java SE 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)+ and  [Maven](https://maven.apache.org/) to run
```sh
$ git clone https://github.com/kyluong09/Business-Management.git
$ cd <dir name> 
$ mvn clean package 
$ java -jar target/app.jar
```
#### Docker
By default, the Docker will expost PORT 8080
```sh
$ docker pull kyluong09/business-management-database
$ docker run -p 8080:8080 kyluong09/business-management-database
```
