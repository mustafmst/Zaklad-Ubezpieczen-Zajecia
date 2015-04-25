

use  projekt;

drop table Appointment;
drop table Customer;
drop table User;

create table User(
	userId int primary key not null auto_increment,
    login varchar(30)  not null UNIQUE ,
    password blob not null,
    stanowisko varchar(20) not null,
    status int not null /*Customer 0, Director 1, Secretary 2, Accountant 3, Advisor 4*/
);

INSERT INTO User (login,password,stanowisko,status) VALUES ('root',MD5('root'),'Director',1 );
INSERT INTO User (login,password,stanowisko,status) VALUES ('Damian',MD5('Damian'),'Advisor',4 );
INSERT INTO User (login,password,stanowisko,status) VALUES ('Basia',MD5('Basia'),'Secretary',2 );
INSERT INTO User (login,password,stanowisko,status) VALUES ('Kasia',MD5('Kasia'),'Accountant',3 );



create table Customer(
    pesel varchar(20) not null primary key,	
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    phone INT not null UNIQUE,
    adress varchar(50),
    email varchar(30)
);


create table Appointment(
    pesel varchar(20) not null primary key,	
    id_advisor INT,
    hours DATETIME,
    
    FOREIGN KEY (`id_advisor`) REFERENCES `User`(`userId`)
);

INSERT INTO Appointment (pesel,id_advisor,hours) VALUES ('987654321',1,'2015-04-10 09:00:00');
INSERT INTO Appointment (pesel,id_advisor,hours) VALUES ('123456789',1,'2015-04-10 09:00:00');
INSERT INTO Appointment (pesel,id_advisor,hours) VALUES ('543267890',1,'2015-04-10 10:00:00');
INSERT INTO Appointment (pesel,id_advisor,hours) VALUES ('333333333',1,'2015-04-10 15:00:00');


