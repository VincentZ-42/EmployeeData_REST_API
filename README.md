# REST_API_with_Spring_Boot_Java

### Table of Contents
- [Objective](#Objective)
- [Usage](#Usage)
- [References](#References)
- [Instructions](#Instructions)
- [Further Developments](#Further-Developments)

## Objective

## Usage

## References 
- [https://www.tutorialspoint.com/spring_boot/](https://www.tutorialspoint.com/spring_boot/index.htm)
- [https://spring.io/guides/tutorials/rest/](https://spring.io/guides/tutorials/rest/?fbclid=IwAR0KXMlz4Sk2SydDRWtMLbXQpiL_fMYeFuYJcthGfL7RjAsZcZwEzi8bGqs)
- Amigoscode Tutorial on Spring Boot: [Youtube](https://www.youtube.com/watch?v=9SGDpanrc8U)
- Amigoscode: [GitHub](https://github.com/amigoscode/spring-data-jpa-course)

## Instructions
1. Use Spring initializr to create zip file for our project
- Can use Spring Initializr on IntelliJ IDEA or [https://start.spring.io/](https://start.spring.io/)
- Select Maven Project, Java 16, package as Jar
- Add Dependencies
  - Spring Web, Spring Data JPA, PostgreSQL Driver
2. Unzip files and open folder with IntelliJ IDEA
3. Creating Package of Employee with class of all functions related to Employee
  - Class of Employee
  - Create Class EmployeeController, this will serve as API for GET, POST, PUT, and DELETE to interact with Service Layer
  - Create Class EmployeeServer, this will serve as functions to interacte with data layer
    - Input Properties to use Postgres database
  - Create Class EmployeeRepository, this will contain all functions that will interact with database (accessing Data)
  - Create Class EmployeeConfig, this is our function that initializes the known data into database
5. Creating and connect to database
  - Used Postgres App to create our database: Link to Download: [https://postgresapp.com/](https://postgresapp.com/)
  - type "psql" to enter interactive shell
  - type "\l" to see list of databases running on postgres
  - type "CREATE DATABASE employee;"
  - type "GRANT ALL PRIVILEGES ON "employee" to (User);"
  - type "\d" to list relations of any database to applications
  - type "GRANT ALL PRIVILEGES ON "employee" to postgres;"
  - type "\c employee" to connect to database on Computer
  - uncomment spring boot start data jpa dependency
  - YOu will need to connect to database from application as well
  - type "SELECT * FROM employee;" to view all data in database
6. Packaging andusing our API
  - Delete Target folder in IntelliJ
  - On Malvern Tab
    a. clean - clears target folder
    b. install - does validate, complie, test, package, and verify code into new target folder
  - You now have a file to run on command line to create multiple instances
    - Navigate into fodlr with .jar file
    - run "java -jar demo-*-SNAPSHOT.jar" to run an instance of your server 

## Further Developments
1. Creating full regristration system
2. Improve Security for server
