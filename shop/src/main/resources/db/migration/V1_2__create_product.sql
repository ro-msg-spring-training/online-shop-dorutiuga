CREATE TABLE Product(
id int primary key auto_increment,
name varchar(40) not null,
description varchar(200) not null,
price double not null,
weight double not null,
categoryId int,
CONSTRAINT FK_ProductCategory foreign key(categoryId) REFERENCES ProductCategory(id),
supplierId int,
CONSTRAINT FK_ProductSupplier foreign key(supplierId) REFERENCES Supplier(id),
imageUrl varchar(100)
)