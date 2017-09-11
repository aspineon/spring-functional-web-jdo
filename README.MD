curl -v 'http://localhost:8080/dept’

curl -d '{"name":"HR"}' -H 'Content-Type: application/json' -v 'http://localhost:8080/dept’

curl -v 'http://localhost:8080/person’

curl -d '{"name”:"Ketan"}' -H 'Content-Type: application/json' -v 'http://localhost:8080/person’


create table person(id int not null, name character varying(128) not null);

create table department(id int not null, name character varying(128) not null);

