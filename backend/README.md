# Spring Boot, Spring Security, MongoDB - JWT Authentication & Authorization example

For more detail, please visit:
> [Spring Boot, MongoDB: JWT Authentication with Spring Security](https://bezkoder.com/spring-boot-jwt-auth-mongodb/)

## Run Spring Boot application
```
mvn spring-boot:run
```


Run below command to setup database


db.roles.insertMany([
   { name: "ROLE_BIDDER" },
   { name: "ROLE_BIDDER_MANAGER" },
   { name: "ROLE_TENDER_CREATOR" },
   { name: "ROLE_TENDER_MANAGER" },
   { name: "ROLE_ADMIN" },
   { name: "ROLE_ONBOARDING" },
   { name: "ROLE_BID_EVALUATION_EXPERT" },
   { name: "ROLE_BID_EVALUATION_CHAIRMAN" },
   { name: "ROLE_CVO" },
   { name: "ROLE_AUDIT" }
])
