
# Solution B

### Reference Documentation

Technical Solution B: How to create Microservices/REST API using Java with Spring boot, Gradle/Maven, Swagger (with containerization using Dockers/Kubernetes – optional)

Expectation is that there will be:

- Gradle/Maven Project to showcase microservices/REST API Implementation

- Security Implementation for microservices/REST API using JWT and Spring Security

- Swagger for API documentation

- Consume Microservices or REST API in a client application (using AngularJS or ReactJS)


### Instructions

- download the repository
- run the application

    `$ git clone https://github.com/jpmillan/solution-b.git`
    `$ cd solution-b`
    `$ mvn package`
    `$ mvn spring-boot:run`

- to access offers list, generate a jwt token first
`$ curl -v localhost:8081/member/me/offers`

- from postman, 
  execute a POST request on `http://localhost:8081/login`
with Body 

{
    "username":"testuser1",
    "password":"test123"
}

a token should be generated

{
    "username": "testuser1",
    "token": < JWT TOKEN >
}

copy the contents of the token and create a new postman GET request for `http://localhost:8081/member/me/offers`
in the headers tab, add an `Authorization` key with value of `"Bearer + < JWT TOKEN >"`, where `< JWT TOKEN >` is the value of the token response from the login api

## Tech Stack

- Java 8
- Springboot
- Spring security
- JWT
- Checkstyle
- Swagger
