# (Users-Microservice-RESTFUL-API)Spring Boot Security with JWT


In this practice is implemented the security of the API endpoints for users using JWT.

IETI - LAB03

2022-2.


## Development

This project is the continuation of the project 

[ Users-Microservice-RESTFUL-API - Data MongoDB ](https://github.com/ZulyVargas/Users-Microservice-RESTFUL-API-MongoDB.git) 


and is developed following the steps of the following repository

[ Spring Boot Security with JWT ](https://github.com/CAPJackie/spring-boot-jwt) 

#### Project structure

![estructure](img/estructure.png)

### Prerequisites


* [Gradle](https://gradle.org) - Management tool used for projects build, dependency and documentation. 
* [Java ](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html)     - Programming language and computing platform.


### Installing

To download the project run:

  ```bash
    git clone https://github.com/ZulyVargas/Users-Microservice-JWT.git
  ```

Run in Users-Microservice-JWT:

```bash
    gradle build
    gradlew bootRun
```
If you have problems, run the application from your editor of choice, suggest: **IntelliJ**.

It is necessary to add the environment variable that allows the connection to the database in the cluster of the mongodb account.

![VE1](/img/environmentVariable-1.png)
![VE2](/img/environmentVariable-2.png) 

***Example***

![run](img/run.png)


## Running the tests

### Part 1: Adding Security Configuration:

+ Open Endpoint: User's List. Should return all registered users no problem.

![openEPGET](/img/openEPGet.png)

+ Secured Endpoint: User by Id. Should not be allowed to obtain the result of the request. 

![secureEPGetById](/img/secureEPGetById.png)

### Part 2: Implementing the Authentication Controller

+ (POST) v1/auth endpoint to obtain the token:

Test user:

  ![](/img/userTestP2.png)

  ```JSON
	{
		"email": "email10@gmail.com",
	  "password": "12345"
	}
  ```

  ![P2OK](/img/P2Ok.png)

  The token and its expiration date are obtained as expected.

### Part 3: Implement JWT Request Filter

For this point the token is obtained as with the request made in part 2.

  ![TokenP3](/img/P2Ok.png)

The token returned in the response is copied and added in the Authorization header with the word Bearer:

  ![token](/img/tokenP3.png)

Result:

+ (GET) /api/v1/user


![result](/img/resultP3.png)

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html) - Integrated development environment written in Java for developing computer software.
* [Gradle](https://gradle.org) - Management tool used for projects build, dependency and documentation.
* [Java ](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html)     - Programming language and computing platform.

## Authors

* **Zuly Valentina Vargas Ram??rez** 
