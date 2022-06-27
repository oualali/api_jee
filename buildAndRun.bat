@echo off
call mvn clean package
call docker build -t fr.efficom.countries/country .
call docker rm -f country
call docker run -d -p 9080:9080 -p 9443:9443 --name country fr.efficom.countries/country