--CREATE TABLE Persons (
--                         PersonID int UNIQUE AUTO_INCREMENT NOT NULL,
--                         LastName varchar(255) NOT NULL,
--                         FirstName varchar(255) NOT NULL,
--                         Gender varchar(80) NOT NULL,
--                         Title varchar(255) NOT NULL,
--                         Nat varchar(255) NOT NULL
--);
--
--SELECT * from Persons;
--
--INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('Jane', 'Doe', 'female', 'Mrs', 'US');

CREATE TABLE Persons3(
	PersonID int UNIQUE AUTO_INCREMENT NOT NULL,
	LastName varchar (255) NOT NULL,
	FirstName varchar (255) NOT NULL,
	Gender varchar (80) NOT NULL,
	Title varchar (255) NOT NULL,
	Nat varchar (255) NOT NULL,
	City varchar (255) NOT NULL,
	Country varchar (255) NOT NULL
);

SELECT * from Persons3;

INSERT INTO Persons3 (
	FirstName, LastName, Gender, Title, Nat, City, Country
) VALUES (
	'John', 'doe', 'male', 'Mr', 'US', 'Chicago' , 'USA'
)