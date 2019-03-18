# Buy Application
Buy is application to provide sales options by product.

## Architecture
This backend application build in Java,Sprint Boot and H2 database, the sample data load on apllication start. The frontend contructed on Angular framework and Boostrap components. This application is also configured to run with Docker.

## Application Setup
Clone this repository with command:

```
https://github.com/diegoandrepoli/buy.git
```

Running the docker build on create containers:

```
docker-compose build
```

Running the docker up to run application:

````
docker-compose up
````

Access application in http://localhost:4200/deal

## Running test
To run tests your need Java and Maven, execute this command:

````
mvn test
````

## Documentation
Example of backend APIs on Postman collections, to get Postman collection [here](https://www.getpostman.com/collections/97375b0bb24a8bfab7f4), the API documentation on Swagger, to acess [here](https://app.swaggerhub.com/apis-docs/diegopoli/Buy/1.0) 

## Running application without Docker
To run application without Docker your need Java and Maven installed to run backend application, angular Cli to run frontend application. The run backend application navigate on saler directory with command:
 
 ````
 cd saler
 ````
 In backend application directory running Spring Boot statup command:
 
 ```
 mvn spring-boot:run
 ```
 
 After start backend application navigate on frontent directory with command:
 
 
 ````
 cd midle
 ````
 
 In frontend directory execute Angular Cli command:
 
 ````
 ng serve
 ````
 
 ## New Releases
 New features that will be included in the next releases:
 * Order options by sale pricing.
 * Control deal by start and publish dates.
 * Fixes layout detais.
 * Add usualy messages popups.
 * Separate buy options and deals to customer pages.
 
 
 
 
 


