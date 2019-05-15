# Demo Application

This project was created with [Spring Boot](https://spring.io/projects/spring-boot) version 2.1.4 release.  
**Test cases are to simply demonstrate understanding of JUnit and Mockito, not to cover all edge cases and scenarios.**  
Run `mvn install` in pom.xml to install dependencies before running the project.

# Prerequisites
1. JDK 1.8
2. Spring Boot version 2.1.4.

## Build

Modify the datasource in application.properties to your local instance. 

Run pom.xml `mvn install` to compile and build the project. Build artifacts will be stored in the `target/` directory, with the file name as `example-0.1.jar`.

## Run

Run the `java -jar target/example-0.1.jar` command from project root folder `demo` in your local system. The API will be running at Tomcat on port `8080`, with context path `/employee`.

