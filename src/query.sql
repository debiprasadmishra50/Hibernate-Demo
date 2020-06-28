show databases;

Create database hb_student_tracker;
Use hb_student_tracker;

Drop table if exists student;

Create table student(
	id int(11) NOT NULL Auto_Increment Primary Key,
    first_name varchar(45) default Null,
    last_name varchar(45) default Null,
    email varchar(45) default Null
);

show tables;

desc student;

Select * from student;

Alter table student Auto_Increment = 3000; <!-- New entries will start from 3000 -->