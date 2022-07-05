create table Orders(
id int primary key auto_increment,
shippedFrom int ,
constraint FK_OrderLocation foreign key(shippedFrom) REFERENCES Location(id),
customerId int,
constraint FK_OrderCustomer foreign key(customerId) REFERENCES Customer(id),
createdAt date,
addressCountry varchar(60) ,
addressCity varchar(60) ,
addressCounty varchar(60) ,
addressStreet varchar(60)
)