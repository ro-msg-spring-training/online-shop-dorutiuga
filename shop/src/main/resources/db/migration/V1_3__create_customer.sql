create table Customer(
id int primary key auto_increment,
firstName varchar(40) not null,
lastName varchar(40) not null,
username varchar(40) not null unique,
password varchar(60) not null,
emailAddress varchar(50) not null
)