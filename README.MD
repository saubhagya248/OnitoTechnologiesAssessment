
**PreRequisites**
Java 17
Mysql
Maven
Intellij Idea (or any IDE)

**Basic Configurations**

After assuming you already have installed Java, Maven, Intellij

Firstly install mysql-server on your computer
After installing create a database onito by using below code,
```agsl
create database onito;
```

It is suggested to create the database with the above given name,
If you are creating database with different name then make sure to replace
your database name in the repository queries.

Then update /src/main/resources/application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/onito?createTableIfNotExists=true
spring.datasource.username= <your-database-username> //provide database username
spring.datasource.password= <your-database-password> /provide database password
spring.jpa.hibernate.ddl-auto= update
```

Now you are ready to run the application.