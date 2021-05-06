# EmployeeData_REST_API
A smiple REST API that allows user to interact with data on server about an employee, such as their name, email, phone number, job title, salary, date of birth, and age. You can retrieve data with HTTP GET, or modify data with POST, PUT, and DELETE. 

<img align="right" src="https://user-images.githubusercontent.com/49771001/117326104-553b2e00-ae5f-11eb-855d-8479fb0a4959.jpg">

### Table of Contents
- [Objective](#Objective)
- [Usage](#Usage)
- [References](#References)
- [Instructions](#Instructions)
- [Further Developments](#Further-Developments)

## Objective
- To build a REST API with Spring Boot and Java in IntelliJ IDEA to keep track of Employee Information
- Utilize HTTP GET, POST, PUT, and DELETE to interact with Data

## Usage
- Download EmployeeData.jar
- In Terminal, type "java -jar EmployeeData.jar" + ENTER  
- Server will run and you can navigate to localhost:8080/api/v1/employee to view site

## References 
- [https://www.tutorialspoint.com/spring_boot/](https://www.tutorialspoint.com/spring_boot/index.htm)
- [https://spring.io/guides/tutorials/rest/](https://spring.io/guides/tutorials/rest/?fbclid=IwAR0KXMlz4Sk2SydDRWtMLbXQpiL_fMYeFuYJcthGfL7RjAsZcZwEzi8bGqs)
- [https://www.codecademy.com/articles/what-is-rest](https://www.codecademy.com/articles/what-is-rest)
- Amigoscode Tutorial on Spring Boot: [Youtube](https://www.youtube.com/watch?v=9SGDpanrc8U)
- Amigoscode: [GitHub](https://github.com/amigoscode/spring-data-jpa-course)


## Instructions on how to Recreate
1. Use Spring initializr to create zip file for our project
    - Can use Spring Initializr on IntelliJ IDEA or [https://start.spring.io/](https://start.spring.io/)
    - Select Maven Project, Java 16, package as Jar
    - Add Dependencies: Spring Web, Spring Data JPA, PostgreSQL Driver
2. Unzip files and open folder with IntelliJ IDEA
3. Creating Package of Employee with class of all functions related to Employee
     - Class Employee: holds all data and getter/setter functions
     - Class EmployeeController: API Layer that uses GET, POST, PUT, and DELETE to interact with Server Layer
     - Class EmployeeServer: Server Layer that holds business logic to interacte with Data Access Layer
     - Class EmployeeRepository, Data Access Layer that will interact with database and sends data to API Layer
     - Class EmployeeConfig, function that initializes the known data into database
5. Creating and connecting to database
      - Use Postgres App to run database server: [https://postgresapp.com/](https://postgresapp.com/)
      - Commands on Terminal
        - "psql": to enter interactive shell
        - "\l": to see list of databases running on postgres
        - type "CREATE DATABASE employee;"
        - type "GRANT ALL PRIVILEGES ON DATABASE "employee" to (User);"
        - type "\d" to list relations of any database to applications
        - type "GRANT ALL PRIVILEGES ON DATABASE "employee" to postgres;"
        - type "\c employee" to connect to database on Computer
        - Add annotations (@Entity n @Table) to your Employee Class
        - Then, You will need to connect to database from application
        - type "SELECT * FROM employee;" to view all data in database
6. Packaging and using our API
    - On Malvern Tab
        a. clean - clears target folder
        b. install - does validate, complie, test, package, and verify code into new target folder
    - You now have a file to run on command line to create multiple instances
    - Navigate into folder (target) with .jar file
    - run "java -jar demo-*-SNAPSHOT.jar" to run an instance of your server 
    - Can change server port with command below:
    - "java -jar demo-*-SNAPSHOT.jar --server.port=8081"

## Further Developments
1. Creating full regristration system
2. Improve Security for server
