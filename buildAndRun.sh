#!/bin/sh
if [ $(docker ps -a -f name=country | grep -w country | wc -l) -eq 1 ]; then
  docker rm -f country
fi
mvn clean package && docker build -t fr.efficom.countries/country .
docker run -d -p 9080:9080 -p 9443:9443 --name country fr.efficom.countries/country
