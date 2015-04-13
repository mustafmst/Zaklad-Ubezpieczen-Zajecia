create database projekt;

use  projekt;


drop table User;

create table User(
	user_id int primary key not null auto_increment,
    login varchar(30)  not null UNIQUE ,
    password blob not null,
    stanowisko varchar(20) not null,
    status int not null /*Customer 0, Director 1, Secretary 2, Accountant 3, Advisor 4*/
);

INSERT INTO User (login,password,stanowisko,status) VALUES ('root',MD5('root'),'Director',1 );
INSERT INTO User (login,password,stanowisko,status) VALUES ('Damian',MD5('Damian'),'Advisor',4 );
INSERT INTO User (login,password,stanowisko,status) VALUES ('Basia',MD5('Basia'),'Secretary',2 );
INSERT INTO User (login,password,stanowisko,status) VALUES ('Kasia',MD5('Kasia'),'Accountant',3 );


select * from User;
