# AUTOMATED SETUP 

1. Change permission of the script 

    chmod +x setup.sh 

2. In the root directory of the project run

    ./setup.sh

This will set up mongo+minio and your frontend. 

3. In frontend/vue.config.js, add your IP Address in the proxy key 

4. Go to localhost:9000 and create a bucket by the name `lotlockbucket`

5. Now in a new terminal run the backend 

    cd backend 

    mvn clean package

    java -jar target/spring-boot-.....-SNAPSHOT.jar


# MANUAL SETUP 

## MongoDB Setup

    docker run -d -p 27017:27017 --name mongodb mongo:latest
    docker exec -it mongodb bash
    mongosh
    use lotlock_db


    db.roles.insertMany([
       { name: "ROLE_FARMER" },
       { name: "ROLE_PROCESSOR" },
       { name: "ROLE_DISTRIBUTOR" },
       { name: "ROLE_RETAILER" },
       { name: "ROLE_ADMIN" },
       { name: "ROLE_ONBOARDING" },
       { name: "ROLE_CONSUMER" },
       { name: "ROLE_GOVERNMENT" },
       { name: "ROLE_CVO" },
       { name: "ROLE_SUSTAINABILITY_AUDITOR" }
    ])


## Minio Setup

    docker run -d \
      -p 9000:9000 \
      -p 9001:9001 \
      -e "MINIO_ROOT_USER=root" \
      -e "MINIO_ROOT_PASSWORD=Qwerty@321" \
      quay.io/minio/minio:RELEASE.2022-01-25T19-56-04Z server /data --console-address ":9001"


## Vue.js - Frontend

    npm install --legacy-peer-deps

    npm run serve


## Spring Server - Backend

Note:: Before running the backend make sure all other services are running

    mvn clean package

    java -jar target/spring-boot-.....-SNAPSHOT.jar

