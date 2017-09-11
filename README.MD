#Maven Commands to run application:

1 mvn clean compile

2 mvn -e datanucleus:enhance

3 mvn spring-boot:run


#Table Script:

create table person(id int not null, name character varying(128) not null);

create table department(id int not null, name character varying(128) not null);

#CURL Commands:

curl -v 'http://localhost:8080/dept’

curl -d '{"name":"HR"}' -H 'Content-Type: application/json' -v 'http://localhost:8080/dept’

curl -v 'http://localhost:8080/person’

curl -d '{"name”:"Ketan"}' -H 'Content-Type: application/json' -v 'http://localhost:8080/person’

