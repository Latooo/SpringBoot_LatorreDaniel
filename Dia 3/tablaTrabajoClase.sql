create database explicacionJPA_P1;
use explicacionJPA_P1;

-- API CRUD de persona basada en Spring Data

create table person(
	id int primary key auto_increment,
    name varchar(255) null,
    age int not null
);


