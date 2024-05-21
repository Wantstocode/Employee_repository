create database if not exists employee_directory;
use employee_directory;

-- table structure

drop table if exists employee;

create table employee(
id int not null auto_increment primary key,
first_name varchar(50) default null,
last_name varchar(50) default null,
email varchar(50) default null
)engine=InnoDB auto_increment=1 default charset=latin1;

insert into employee values(1,"c b","kiran","kiran123@gmail.com"),
(2,"chandan","b m","chandan123@gmail.com"),
(3,"dhanush","b","dhanush23@gmail.com"),
(4,"gagan","kashyap","gagan123@gmail.com"),
(5,"irshad","","bhai123@gmail.com");


drop table if exists roles;
drop table if exists users_credentials;

create table users_credentials(
username varchar(50) not null primary key,
password varchar(100) not null,
active tinyint not null
)engine=InnoDB default charset=latin1;

insert into users_credentials values
	("kiran","{bcrypt}$2a$10$VtAIWzbPxMDefJHz5Ll5BOuTPG5YMVqNaFDUuKX7KVIqJlew8t7k2",1),
    ("chandan","{bcrypt}$2a$10$L3KG5tTqOK.xFk.P3X.A2uGa44uSOWwMenEf/ZDn43Mcqdmc03dHO",1),
    ("gagan","{bcrypt}$2a$10$8vMLu0fjA9lTFqO0MxpaIu3/jkzi1gxDrOC1Mn2g9Ai1PE3DO29Xy",1);
    
    
create table roles(
user_name varchar(50) not null,
role varchar(50),
foreign key(user_name) references users_credentials(username)
)engine=InnoDB default charset=latin1;

insert into roles values
	("kiran","ROLE_employee"),
    ("chandan","ROLE_employee"),
    ("chandan","ROLE_manager"),
    ("gagan","ROLE_manager"),
    ("gagan","ROLE_employee"),
    ("gagan","ROLE_admin");
    
    


