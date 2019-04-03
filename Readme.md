local development looks the same as the previous microservice:
it need kafka on localhost only
 development branch is configured for local development
 
master config is tuned for kubernetes deployment

mvn clean install dockerfile:build - will build docker image locally, then you can deploy it local kubernetes instance

0. setup kafka
1. build docker image with maven
2. load deployment mail.yml to kubernetes
3. load mail-service.yml