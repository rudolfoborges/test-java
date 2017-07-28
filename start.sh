#!/bin/bash

./gradlew -p campaign clean build

./gradlew -p user clean build

./gradlew -p eureka-server clean build

./gradlew -p questao3 clean build

docker-compose up --build
