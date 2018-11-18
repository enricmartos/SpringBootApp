# SpringBootApp

## Description

This application is a library management system which allows you to see, edit and delete all book entries. You can add a new book as well. 

## Core technologies

*Front-end*

- JSP (JavaServer Pages)
- Bootstrap

*Back-end*

- Spring Boot

*Database*

- MySQL

*Server*

- Apache Tomcat (default embedded server provided by Spring Boot)

*Dependency management tool*

- Maven

*IDE*

- Spring Tool Suite


## Personal goals

- Get familiar with Spring Boot framework and learn how to perform basic CRUD operations
- Implement a simple microservice such as a mail sender by using the Spring Boot Rest API

## Build setup

- Clone this repo to your local machine. If you use Spring Tool Suite as IDE, open this project there:

```
# Import the project to STS

File -> Import -> Git -> Projects from Git -> Existing local repository -> Add ${Directory where you have cloned the repo} -> Import existing Eclipse projects
```

- MySQL and MySQL Workbench must be already installed in your machine. Otherwise, you will have to install them. Please notice that the default parameters (port, username and password) to enable the MySQL connection are defined on application.properties file. So, feel free to edit them in order to match one of your MySQL connections.

- Set the values of the gmail properties (username, password, subject and body) specified on application.properties file as well.

```
# Create the db

CREATE SCHEMA `lmsdb` ;
```

- Run the project as Spring Boot App

- Open your browser and test the application on *localhost:8080*

## References

I have accomplished the aforementioned goals thanks to the following courses:

- [Spring Boot + Spring MVC + JPA](https://www.youtube.com/watch?v=II8V0_ilRbU&list=PLdJYl6XU45uLIHaPBQEj-cEMynAl0oeiz&index=1)
- [Sending Email with Spring Boot Rest API - Gmail Transport Layer Security](https://www.youtube.com/watch?v=G4PUeYbqO80)
