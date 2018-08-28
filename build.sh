#!/bin/bash

./gradlew clean bootRepackage

//docker build --rm . --tag huangyanyan/todo-service:${VER:?invalid version}
docker push huangyanyan/todo-service:${VER:?invalid version}

export VER
docker stack deploy todo -c docker-compose.yml