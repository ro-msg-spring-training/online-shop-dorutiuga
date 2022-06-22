create table Location(
id int  primary key auto_increment,
name varchar(60) not null,
addressCountry varchar(100) not null,
addressCity varchar(100) not null,
addressCounty varchar(70) not null,
addressStreet varchar(100) not null
)