@echo off

call mvnw clean package dockerfile:build -DskipTests

kubectl delete -f kubernetes\mail-service.yml
timeout 5 > NUL
kubectl delete -f kubernetes\mail.yml
timeout 5 > NUL
kubectl apply -f kubernetes\mail.yml
timeout 5 > NUL
kubectl apply -f kubernetes\mail-service.yml

