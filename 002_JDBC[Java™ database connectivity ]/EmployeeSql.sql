use Employeeschema
go
Create table Employee(
empid int primary key AUTO_INCREMENT,
email varchar(50) ,
empname varchar(50),
empaddress varchar(50),
empphone varchar(10) unique
);

select * from Employee
drop table Employee;