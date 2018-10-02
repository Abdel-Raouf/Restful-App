# Learn How to Develop A Restful Web Apps

**Using** the following *technologies*: 

[Angular.js](https://angular.io/) - Google's Open-Source Javascript Framework for building user interfaces.

[Typescript](https://www.typescriptlang.org/) - TypeScript is a strongly-typed superset of JavaScript.

[Java](https://www.oracle.com/technetwork/java/index.html) - Java is a general-purpose computer-programming language that is concurrent, class-based and object-oriented.

[Maven](https://maven.apache.org/) - Apache Maven is a software project management and comprehension tool.

[Hibernate](https://hibernate.org/) - Hibernate [ORM](http://hibernate.org/orm/what-is-an-orm/) enables developers to more easily write applications whose data outlives the application process. 

[Apache Tomee](http://tomee.apache.org/) - Apache TomEE (pronounced "Tommy") is the Java Enterprise Edition of Apache Tomcat (Tomcat + Java EE = TomEE) that combines several Java enterprise projects including Apache OpenEJB, Apache OpenWebBeans, Apache OpenJPA, Apache MyFaces and others.

[PostgreSQL](https://www.postgresql.org/) - PostgreSQL is a powerful, open source object-relational database system which has a strong reputation for reliability, feature robustness, and performance.

**Using** the following Architecture style:

[Representational State Transfer (REST)](https://spring.io/understanding/REST) - REST as an approach to developing web services as an alternative to other distributed-computing specifications such as [SOAP](https://www.tutorialspoint.com/soap/what_is_soap.htm). 

**More** *Calrification*:

[Main_points.pdf](https://github.com/Abdel-Raouf/Restful-App/blob/master/main_points.pdf).

#Feel free to contribute

![App look](https://github.com/Abdel-Raouf/Restful-App/blob/master/images/Screenshot%20from%202018-10-01%2006-54-41.png)
![App look](https://github.com/Abdel-Raouf/Restful-App/blob/master/images/Screenshot%20from%202018-10-01%2006-53-51.png)
![App look](https://github.com/Abdel-Raouf/Restful-App/blob/master/images/Screenshot%20from%202018-10-01%2006-54-18.png)

# Implemented Features

- Get - To Retrieve information.
- Post - To Create a new entity.

# Feature Suggestions

- PUT - To Update an existing entity.
- Delete - To Request that a resource be removed.
- [Dockerize The Application](https://github.com/docker/labs/tree/master/developer-tools/nodejs/porting/) - Shipping application on [Docker](https://www.docker.com/).

# Set up the Development Environment For Front-End:

1. Install [Node.js® and npm](https://nodejs.org/en/download/) if they are not already on your machine.
2. Navigate to [Front-end-Angular.js](https://github.com/Abdel-Raouf/Restful-App/tree/master/Front-end-Angular.js) Directory using Terminal(Linux/Mac) or CMD(Windows).
3. Launch the Server: 
```
$ npm start
```
4. Open your browser on http://localhost:4200

# Set up the Development Environment For Back-End:

1. Install [NetBeans](https://netbeans.org/downloads/) 
2. Download [Apache TomEE plume](http://tomee.apache.org/download-ng.html) and Extract Files. 
3. Open NetBeans and Navigate To: File --> Open Project --> [Back-End-Java](https://github.com/Abdel-Raouf/Restful-App/tree/master/Back-end-Java) Directory.
4. Navigate to services Tab beside projects Tab. Then Right-click on servers to add a new server, then choose Apache Tomcat or TomEE and Navigate to the Directory of the Extracted folder of Apache Tomee Plume.
5. Navigate to Projects Tab and Right-click on EJBRestfulWebService0 --> build. Then EJBRestfulWebService0 --> Run.

# Set up the Development Environment For Database:

  ##### 1.  For Windows/Mac:
  1. Download [PostgreSQL](https://www.postgresql.org/download/windows/) installer for windows
      OR [PostgreSQL](https://www.postgresql.org/download/macosx/) installer for Mac.
  2. Using the graphical tool for managing and developing your databases
  3. Use default username: postgres and password: 123456
  4. Create database: mydb , then connect to the mydb database.
  5. Create table company:
  ```
CREATE TABLE COMPANY(
  ID INT PRIMARY KEY NOT NULL,
  NAME TEXT NOT NULL,
  ADDRESS CHAR(50),
  SALARY REAL
);
​
  ```
 ##### 2. For Linux:
 1. Download and install [PostgreSQL](https://www.postgresql.org/download/) for Your Linux Distribution.
 2. Using Terminal:
    1. Access a database console in terminal: ``` sudo -u postgres psql postgres ```
    2. Change password for an existing user postgres (default user): ``` ALTER USER postgres WITH PASSWORD '123456'; ```
    3. Create a Database: ``` CREATE DATABASE mydb; ```
    4. Connect to the Database: ``` \c mydb; ```
    5. Create Table Company:
    ```
    CREATE TABLE COMPANY(
      ID INT PRIMARY KEY NOT NULL,
      NAME TEXT NOT NULL,
      ADDRESS CHAR(50),
      SALARY REAL
    );
    ```
