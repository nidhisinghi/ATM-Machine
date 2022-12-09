create database ATMSystem;
use ATMSystem;
show tables;

create table signup(formno varchar(20),name varchar(20),father_name varchar(20),DOB varchar(20),
gender varchar(20),Email varchar(30),MaritalStatus varchar(100),Address varchar(20),City varchar(25),
State varchar(25),Pin varchar(20));
select * from signup;
drop table signup;

create table signuptwo(formno varchar(20),Religion varchar(20),Category varchar(20),Income varchar(20),
Education varchar(20),Occupation varchar(30),Senior_Citizen varchar(100),Existing_Account varchar(20),
Aadhar_NO varchar(25),Pan_No varchar(20));
select * from signuptwo;
drop table signuptwo;

create table signupthree(formno varchar(20),Account_Type varchar(40),Card_Number varchar(16),
pin varchar(4),facility varchar(100));
select * from signupthree;
drop table signupthree;

create table login(formno varchar(20),card_Number varchar(16),pin varchar(4));
select * from login;
drop table login;

create table transactions(card_number varchar(16),pin varchar(4), date varchar(50), type varchar(20),amount varchar(20),
balance varchar(50));
select * from transactions;
drop table transactions;

create table Balance(card_number varchar(16), pin varchar(4), balance int(50));
select * from Balance;
drop table Balance;


