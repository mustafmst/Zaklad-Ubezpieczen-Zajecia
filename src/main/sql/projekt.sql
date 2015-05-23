drop database IF EXISTS projekt;
create database projekt;
use  projekt;

drop table IF EXISTS Appointment;
drop table IF EXISTS Service;
drop table IF EXISTS Customer;
drop table IF EXISTS User;
drop table IF EXISTS TempLogin;
drop table IF EXISTS History;
#select * from User;
#select * from Customer;
#select * from Service;
#select * from Appointment;
#select * from History;
#select * from TempLogin;
create table User(
	userId int primary key not null auto_increment,
    login varchar(30)  not null UNIQUE ,
    password blob not null,
    stanowisko varchar(20) not null,
    status int not null, /*Customer 0, Director 1, Secretary 2, Accountant 3, Advisor 4*/
	imie varchar(30) not null,
    nazwisko varchar(30) not null
);

#insert into Service (pesel_fk,user_fk,serviceCost, insuranceCost, description, dateOfService, dateOfAddService) Values
#(123456789,2, 100, 200, 'Opis bla bla',CURDATE(),CURDATE());

#select * from User;
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
    serviceCost float not null,
    insuranceCost float not null,
    description varchar(255) not null,
    dateOfService date not null,
    dateOfAddService date not null,
    FOREIGN KEY(pesel_fk) REFERENCES Customer(pesel),
    FOREIGN KEY(user_fk) REFERENCES User(userId)
);


create table Appointment(
	appointmentId int primary key not null auto_increment,
    pesel varchar(20) not null,	
    id_advisor int not null,
    dateofAddAppointment date not null, 
    hours time not null,
    FOREIGN KEY (id_advisor) REFERENCES User(userId)
);

create table History(
	hisId int primary key not null auto_increment,
    userId int not null,
    dateOfChange datetime not null,
    whatChange varchar(30) not null
);

create table TempLogin(
	id int primary key not null auto_increment,
	userId int
	);

#select * from TempLogin;







/************************************************** INSERTY ******************************************************/
insert into TempLogin(userId) values (1);

INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('root',MD5('root'),'Director',1, 'Piotr','Nowak' );
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Damian',MD5('Damian'),'Advisor',4 ,'Damian','Mamla');
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Basia',MD5('Basia'),'Secretary',2, 'Basia','Foczka1' );
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Kasia',MD5('Kasia'),'Accountant',3,'Kasia','Foczka2' );
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('Pawel',MD5('Pawel'),'Advisor',4 ,'Pawel','Kruk');
INSERT INTO User (login,password,stanowisko,status,imie,nazwisko) VALUES ('a',MD5('a'),'Secretary',2, 'a','a' );

INSERT INTO Customer (pesel,firstName,lastName,phone,adress,email) VALUES ('123456789','Kamil','Bartu',276456321, '33-123 Kolo','kamil@bartu.com' );
INSERT INTO Customer (pesel,firstName,lastName,phone,adress,email) VALUES ('987654321','Beata','Koza',876543232, '33-123 Kolo','kamil@bartu.com' );
INSERT INTO Customer (pesel,firstName,lastName,phone,adress,email) VALUES ('123456799','Pawel','Gosc',124124124, '33-123 Kolo','kamil@bartu.com' );
INSERT INTO Customer (pesel,firstName,lastName,phone,adress,email) VALUES ('543267890','Michal','Git',154654734, '33-123 Kolo','kamil@bartu.com' );
INSERT INTO Customer (pesel,firstName,lastName,phone,adress,email) VALUES ('333333333','Monika','Siema',457453453, '33-123 Kolo','kamil@bartu.com' );



INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours) VALUES ('987654321',2,'2015-04-10', '09:00:00');
INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours) VALUES ('123456799',5,'2015-04-10', '09:00:00');
INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours) VALUES ('543267890',2,'2015-04-10', '10:00:00');
INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours) VALUES ('333333333',5,'2015-04-10', '14:00:00');
INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours) VALUES ('123456789',5,'2015-04-10', '08:00:00');




/******************Procedury **********************************/

delimiter $$
DROP PROCEDURE IF EXISTS ProcedureTempLogin$$
CREATE PROCEDURE ProcedureTempLogin()
	BEGIN
	Truncate table TempLogin;
END$$

#call ProcedureTempLogin();

#INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours) VALUES ('12345679',5,'2015-04-10', '08:00:00');


DELIMITER $$

DROP PROCEDURE IF EXISTS addAppointment$$

create procedure addAppointment(in zm int,in pesel varchar(20))
begin
	declare i int default 1;
    
    while( i < zm ) do
			INSERT INTO Appointment (pesel,id_advisor,dateofAddAppointment,hours)
            VALUES (pesel,5,CURDATE()-i, '09:00:00'),
				   (pesel,5,CURDATE()-i, '10:00:00'),
				   (pesel,5,CURDATE()-i, '11:00:00'),
				   (pesel,5,CURDATE()-i, '12:00:00'),
                   (pesel,5,CURDATE()-i, '13:00:00'),
                   (pesel,5,CURDATE()-i, '14:00:00');
		set i = i + 1;
	end while;
end$$



DROP PROCEDURE IF EXISTS addService$$

create procedure addService(in zm int,in pesel varchar(20),in user int)
begin
	declare i int default 1;
    
    while( i < zm ) do
			insert into Service (pesel_fk,user_fk,serviceCost, insuranceCost, description, dateOfService, dateOfAddService)
            Values (pesel,user, 100, 200, 'Opis bla bla',CURDATE()-i,CURDATE());
            
		set i = i + 1;
	end while;
end$$



/************************Triggery*******************************************/

drop trigger IF EXISTS userTrigger;

DELIMITER $$
CREATE TRIGGER userTrigger
AFTER INSERT ON User FOR EACH ROW
begin
		DECLARE vUser int;
        SELECT userId INTO vUser FROM TempLogin;   
        
        insert into History(userId, dateOfChange, whatChange)
        values (vUser, sysdate(),'Add employee');
END;
$$
DELIMITER ;

drop trigger IF EXISTS customerTrigger;

DELIMITER $$
CREATE TRIGGER customerTrigger
AFTER INSERT ON Customer FOR EACH ROW
begin
		DECLARE vUser int;
        SELECT userId INTO vUser FROM TempLogin;   
        
        insert into History(userId, dateOfChange, whatChange)
        values (vUser, sysdate(),'Add customer');
END;
$$
DELIMITER ;




drop trigger  IF EXISTS servicetTrigger;

DELIMITER $$
CREATE TRIGGER servicetTrigger
AFTER INSERT ON Service FOR EACH ROW
begin
		DECLARE vUser int;
        SELECT userId INTO vUser FROM TempLogin;
        
        insert into History(userId, dateOfChange, whatChange)
        values (vUser,sysdate(),'Add service');
END;
$$
DELIMITER ;

#insert into Service (pesel_fk,user_fk,serviceCost, insuranceCost, description, dateOfService, dateOfAddService) Values
#(123456789,2, 100, 200, 'Opis bla bla',CURDATE(),CURDATE());



drop trigger  IF EXISTS appointmentTrigger;

DELIMITER $$
CREATE TRIGGER appointmentTrigger
AFTER INSERT ON Appointment FOR EACH ROW
begin
		DECLARE vUser int;
        SELECT userId INTO vUser FROM TempLogin;

        insert into History(userId, dateOfChange, whatChange)
        values (vUser,sysdate(),'Add appointment');
END;
$$
DELIMITER ;


/*********************wywołania procedur***************************/

call addAppointment(10,'987654321');

call addAppointment(5,'543267890');

call addAppointment(10,'333333333');

call addService(10,'123456789',2);

call addService(6,'987654321',3);

call addService(5,'333333333',1);

call ProcedureTempLogin();

