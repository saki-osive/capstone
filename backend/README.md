# Spring Boot, Spring Security, MongoDB - JWT Authentication & Authorization example

For more detail, please visit:
> [Spring Boot, MongoDB: JWT Authentication with Spring Security](https://bezkoder.com/spring-boot-jwt-auth-mongodb/)

## Run Spring Boot application
```
mvn spring-boot:run
```


Run below command to setup database


db.roles.insertMany([
   { name: "ROLE_FARMER" },
   { name: "ROLE_PROCESSOR" },
   { name: "ROLE_TENDER_CREATOR" },
   { name: "ROLE_RETAILER" },
   { name: "ROLE_ADMIN" },
   { name: "ROLE_ONBOARDING" },
   { name: "ROLE_CONSUMER" },
   { name: "ROLE_GOVERNMENT" },
   { name: "ROLE_CVO" },
   { name: "ROLE_SUSTAINABILITY_AUDITOR" }
])
