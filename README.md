# Liquibase Migration - Java SpringBoot

This project demonstrates how to use Liquibase for managing database migrations in a Java application using JPA entities.

## Prerequisites
- Java Development Kit (JDK) installed
- Apache Maven installed
- A database server (e.g., MySQL, PostgreSQL) running

## Project Structure
- `src/main/resources`: Contains the Liquibase changelog files.
- `src/main/java`: Contains the JPA entity classes.
- `pom.xml`: Maven configuration file.


How to Run the Migrations?
12. Go to project root directory and run the following command. It will generate Change Sets based JPA entities
    ```shell script
    $ mvn clean install -DskipTests
    $ mvn liquibase:diff
    
    ```
    > if you are running this for first time, it will generate change sets for all the Entities

13. Now run the update command to generate tables entity, `DATABASECHANGELOG` and `DATABASECHANGELOGLOCK` tables
    ```shell script
    $ mvn clean install -DskipTests
    $ mvn liquibase:update
    ```
12. Now go to database see all the changes applied and tables created
13. Repeat steps 1 and 2 every time you make any changes to JPA entities

