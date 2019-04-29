# Business Management Database

BMDB is a full-stack template with combination of Java | Maven | Spring Framework. This can be used for starter to create a complete build-in business structure, CRUD operations, authentication, Restful API.

** Project's for education purposes at University of Wisconsin - Parkside

# Contents
1. [Technologies](#technologies)
2. [Getting Started](#getting-started)
3. [Prerequisties](#prerequisties)
4. [Installation](#installation)
5. [MySQL Workbench](#mysql-workbench)
6. [Dependencies](#dependencies)
7. [License](#license)


# Technologies
  - [Spring Framework](https://spring.io/) (Core, Spring Boot, Spring MVC, Spring REST, Spring Security, JPA)
  - [Apache Maven](https://maven.apache.org/) - Build automation tool
  - [Bootstrap](https://getbootstrap.com/) - CSS & Javacript template
  - [MySQL](https://www.mysql.com/) - SQL database management system
  - [Thymleaf](https://www.thymeleaf.org/) - Java XML/XHTML/HTML5 template Engine



# Getting Started
### Prerequisties
Please make sure have all these requirements before run an application
- [Java SE 8](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) - Runtime Enviroment
- [ Maven Command Line | mvn](https://maven.apache.org/download.cgi) - Build automation tool
- [ MySQL Workbench](https://dev.mysql.com/downloads/workbench/) - MySQL IDE
### Installation

```sh
$ git clone https://github.com/kyluong09/Business-Management.git
$ cd <dir name> 
$ mvn clean package 
$ java -jar target/app.jar

Enter http://localhost:8080 on BROWSER
```
```
There is authentication layer, you need to login with default username/password
username: admin
password: password
```




the application will run but it won't be able to interact with database unti you're done with following step`` 
#### MySQL Workbench
In order for this application to work, we need to set up a database with MySQL Workbench and SQL script which is included inside project directory
```
- Set up new connection localhost with new username/password
- Open SQL script from directory ../Business-Management/sql_script
- Execute the script
```

#### Application Properties
###### ../Business-Management-Database/src/main/resources/
After finish setting up MySQL Workbench, change ``spring.database.username/password`` value with Workbench ``username/password``

```
<!--MySQL Connection Properties-->
spring.datasource.url=jdbc:mysql://localhost:3306/Business_Management_Database
spring.datasource.username= <MySQL Workbench connection USERNAME>
spring.datasource.password= <MySQL Workbench connection PASSWORD>
```
You can also change login username/password in ``application.properties`` file
```
<!--Authentication Properties-->
spring.security.user.name=admin 
spring.security.user.password=password
spring.security.user.roles="ADMIN"
```


# Docker
You can also run project on Docker enviroment. By default, the Docker will expost PORT 8080
```sh
$ docker pull kyluong09/business-management-database
$ docker run -p 8080:8080 kyluong09/business-management-database
Go to http://localhost:8080
```


# Dependencies

| Dependency | MVNRepository |
| ------ | ------ |
| Spring Boot Starter Web | [org.springframework.boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) |
| Spring Boot Starter Data JPA | [org.springframework.boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa) |
| Spring Boot Starter Data REST | [org.springframework.boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-rest) |
| Spring Boot Starter Security | [org.springframework.boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security) |
| Spring Boot Starter Thymeleaf | [org.springframework.boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf) |
| Spring Boot Devtools | [org.springframework.boot](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools) |
| MySQL Connector Java | [MySQL](https://mvnrepository.com/artifact/mysql/mysql-connector-java) |

# License
Thi project is licensed under MIT License - see the [LICENSE](https://github.com/kyluong09/Business-Management-Database/blob/master/LICENSE) file for details


