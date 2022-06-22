create table Stock(
id int  primary key  auto_increment,
productId int not null,
constraint FK_StockProduct  foreign key(productId) REFERENCES Product(id),
locationId int not null,
constraint FK_StockLocation foreign key(locationId) REFERENCES Location(id),
quantity int not null
)