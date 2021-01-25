

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

    `$ git clone https://github.com/jpmillan/solution-b.git`
    
    `$ cd solution-b`
    
    `$ mvn clean install`

- Run the application (via Docker)    
    `$ docker-compose up`

- to access offers list, generate a jwt token first
- from postman, 
  execute a POST request on `http://localhost:8081/login`
with Body 

 ` {
        "username":"testuser1",
        "password":"test123"
    }`  

or 

 ` {
        "username":"jp",
        "password":"test123"
    }`  


a token should be generated

{
    "username": "testuser1",
    "token": < JWT TOKEN >
}

copy the contents of the token and create a new postman GET request for `http://localhost:8081/member/me/offers`
in the headers tab, add an `Authorization` key with value of `"Bearer + < JWT TOKEN >"`, where `< JWT TOKEN >` is the value of the token response from the login api


## To Access via ReactJS app

 download the web repository

    `$ git clone https://github.com/jpmillan/solution-b-web.git`
    
    `$ cd solution-b-web`
	
	`$ npm install`
	
	`$ npm start`

access the page via  **`http://localhost:3000/`**

## Tech Stack

- Java 8
- Springboot
- Spring security
- JWT
- Checkstyle
- Swagger
- Docker
