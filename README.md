# REST API Count Magic Number

[![Build Status]()

This is a basic model of an api created with Java 11 and Spring Boot, guided by unit and integration tests

## Problem
 Um número X é dito “mágico” quando a raiz quadrada de X existe e é um número primo.
 Escreva um programa que receba como entrada uma lista de intervalos [A,B] e retorne o
 somatório da quantidade de números mágicos encontrados em cada intervalo. É garantido
 que os números A e B serão inteiros positivos e que A será sempre menor ou igual que B
 
 Para a entrada: [[8,27], [49,49]]
 
 Resultado: 3
 
 Seriam os números 9 e 25 do primeiro intervalo e 49 do segundo

## Install

    mvn clean install

## Run the app

    mvn spring-boot:run

## Run the tests

    mvn test

## Run Docker Compose

    docker-compose up

## Route
    POST localhost:8080/api/magicnumber
## Documentation
    localhost:8080/swagger-ui.html

## Stack
- Java 11
- Spring Boot
- Spring Validation
- Lombok
- Swagger for Documentation
- TDD with JUnit
- BDD with Mockito
- Docker
- Travis
- Codecov
- Heroku
    