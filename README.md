# geoserver-qa

Related Articles / Sources
* [Spring Boot Testcontainers example](https://mkyong.com/spring-boot/spring-boot-testcontainers-example/)
* [Spring Boot examples repo](https://github.com/mkyong/spring-boot)

## Technologies:
* Spring Boot 3.1.2 (Spring Web MVC, Spring Data JPA and Spring Test)
* Testcontainers 1.19.0
* PostgreSQL 15, Alpine Linux base image `postgres:15-alpine`
* Java 17
* JUnt 5
* Postman-runner 3.0.0

## Preconditions

Setup a datadir pointing to a temporary folder as in [GSCloud README instructions](https://github.com/geoserver/geoserver-cloud#development-runs)
```
$ ln -s /tmp/datadir docker-compose_datadir
```

## How to start
```
$ ./mvnw test

$ ./mvnw spring-boot:run
```



