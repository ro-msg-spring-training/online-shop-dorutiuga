create table OrderDetail(
id int  primary key auto_increment,
orderId int ,
constraint FK_Order foreign key (orderId) REFERENCES Orders(id),
productId int not null,
constraint FK_OrderProduct foreign key (productId) REFERENCES Product(id),
quantity int not null
)