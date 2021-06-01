# Thales
Simple employees Java web app that displays the employee information for single employee o all employe information.

## Technical specifications

### thales-ng
Angular client 

### ThalesTest
Exposes all operations to be consumed developed with spring-boot, this module contains an API and a REST, the API exposes a facade API
to consume the needed services, on REST part it's implementation and in order to calculate anual salary  an strategy pattern was used to
allow open closed principle.


### Software requirements
* Maven
* JUnit 5
* Java V.11
* Angular V.8


### Project execution

To executes the project can be easily done using docker-compose.
```bash
# Executes
 docker-compose up -d
```

In order to see swagger documentation the project must be running on local and can be accessed through:

[http://localhost:90/v1/api/swagger-ui.html]

Client can be accessed through:

[http://localhost:80]

### Run Tests

Test were made using [JUnit5](https://junit.org/junit5/), those can be executed with maven:
```bash
mvn test
```
