create table Revenue(
id int primary key auto_increment,
locationId int,
constraint FK_RevenueLocation foreign key (locationId) references Location(id),
`date` date not null,
`sum` decimal not null
)