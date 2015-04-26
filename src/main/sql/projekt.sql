

use  projekt;

drop table User;

create table User(
	userId int primary key not null auto_increment,
    login varchar(30)  not null UNIQUE ,
    password blob not null,
    stanowisko varchar(20) not null,
    status int not null, /*Customer 0, Director 1, Secretary 2, Accountant 3, Advisor 4*/
	imie varchar(30) not null,
    nazwisko varchar(30) not null
);

INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('root',MD5('root'),'Director',1, 'Piotr','Nowak' );
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Damian',MD5('Damian'),'Advisor',4 ,'Damian','Mamla');
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Basia',MD5('Basia'),'Secretary',2, 'Basia','Foczka1' );
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Kasia',MD5('Kasia'),'Accountant',3,'Kasia','Foczka2' );


#select * from User;
drop table Customer;
create table Customer(
    pesel varchar(20) not null primary key,	
    firstName varchar(30) not null,
    lastName varchar(30) not null,
    phone INT not null UNIQUE,
    adress varchar(50),
    email varchar(30)
);


#select * from Customer;

create table Service (
	serviceId int not null primary key auto_increment,
	pesel_fk varchar(20) not null,	
    user_fk int not null,
    serviceCost int not null,
    insuranceCost int not null,
    description varchar(255) not null,
    dataOfAddService date not null,
    FOREIGN KEY(pesel_fk) REFERENCES Customer(pesel),
    FOREIGN KEY(user_fk) REFERENCES User(userId)
);
select * from Service;



#insert into Service (pesel_fk,user_fk,serviceCost, insuranceCost, description, dataOfAddService) Values
#(1,2, 100, 200, 'Opis bla bla',CURDATE());

