@echo off

call mvnw clean package dockerfile:build -DskipTests

kubectl delete -f kubernetes\mail.yml
kubectl create -f kubernetes\mail.yml

pause