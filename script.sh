#!/bin/bash

# Start the MongoDB container
docker run -d -p 27017:27017 --name lotlock_mongodb mongo:latest

# Wait for MongoDB to start
sleep 3

# Run the MongoDB commands
docker exec -it lotlock_mongodb bash -c "echo '
use lotlock_db
db.roles.insertMany([
   { name: \"ROLE_FARMER\" },
   { name: \"ROLE_PROCESSOR\" },
   { name: \"ROLE_DISTRIBUTOR\" },
   { name: \"ROLE_RETAILER\" },
   { name: \"ROLE_ADMIN\" },
   { name: \"ROLE_ONBOARDING\" },
   { name: \"ROLE_CONSUMER\" },
   { name: \"ROLE_GOVERNMENT\" },
   { name: \"ROLE_CVO\" },
   { name: \"ROLE_SUSTAINABILITY_AUDITOR\" }
])
' | mongosh"

# Start the MinIO container
docker run -d \
  --name lotlock_minio \
  -p 9000:9000 \
  -p 9001:9001 \
  -e "MINIO_ROOT_USER=root" \
  -e "MINIO_ROOT_PASSWORD=Qwerty@321" \
  quay.io/minio/minio:RELEASE.2022-01-25T19-56-04Z server /data --console-address ":9001"


# Navigate to the frontend directory and run npm commands
cd frontend
npm install --legacy-peer-deps
npm run serve
