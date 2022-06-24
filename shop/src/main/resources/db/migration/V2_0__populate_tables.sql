insert into supplier (name) values ('Inline Distributing');
insert into supplier (name) values ('Richbay Supply');
insert into supplier (name) values ('Charter Supply');
insert into supplier (name) values ('Harvest Food');


insert into productCategory (description, name) values ('This Vermont-based retailer has been a big name in fly-fishing and outdoor gear', 'Dog beds');
insert into productCategory (description, name) values ('Putting together their furniture may be a tough task, but at least Ikea supports your relaxation too.', 'Bedding');
insert into productCategory (description, name) values ('For more than a century, Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.', 'Jewelry');
insert into productCategory (description, name) values ('Target is known for its positioning across product categories, including affordable fashion, electronics, and cleaning supplies', 'Grocery essentials');


insert into location (addressCity, addressCountry, addressStreet, name) values ('Milan', 'Italy', '9 Shasta Park', 'MAggs');
insert into location (addressCity, addressCountry, addressStreet, name) values ('Ipoti', 'NG', '26566 Bluejay Center', 'Photolist');
insert into location (addressCity, addressCountry, addressStreet, name) values ('Piskorevci', 'HR', '506 Mitchell Court', 'Skinte');
insert into location (addressCity, addressCountry, addressStreet, name) values ('Марnhо', 'MK', '578 Spaight Trail', 'Jaxspan');


insert into product (imageUrl, description, name, price, weight, categoryId, supplierId) values ('https://picsum.photos/200/100', 'Best bed for dogs', 'Dogs bed ', 30.00, 12.22, 1, 2);
insert into product (imageUrl, description, name, price, weight, categoryId, supplierId) values ('https://picsum.photos/200/200', 'It’s an easy way to revitalise your bedroom and get in the mood for summer.', 'Bed linen for a seaside sleep', 45.63, 33.29, 2, 4);
insert into product (imageUrl, description, name, price, weight, categoryId, supplierId) values ('https://picsum.photos/200/300', 'Swarovski has put the sparkle in gowns, tiaras, jewelry, sculptures, and even luxury cars.', 'Swarovski', 91.97, 8.22, 3, 1);
insert into product (imageUrl, description, name, price, weight, categoryId, supplierId) values ('https://picsum.photos/200/400', 'Farm grown bio carrots', 'BIO Carrots', 59.96, 74.58, 4, 2);



insert into stock (quantity, locationId, productId) values (35, 1, 4);
insert into stock (quantity, locationId, productId) values (65, 4, 2);
insert into stock (quantity, locationId, productId) values (67, 3, 1);
insert into stock (quantity, locationId, productId) values (121, 2, 3);


insert into customer (emailAddress, firstName, lastName, password, username) values ('test@microsoft.com', 'Boris', 'Boris', 'test', 'test');
insert into customer (emailAddress, firstName, lastName, password, username) values ('test2@cloudflare.com', 'John', 'Doe', 'test2', 'test2');
insert into customer (emailAddress, firstName, lastName, password, username) values ('test3@ebay.com', 'Mark', 'Mendelssohn', 'test3', 'test3');
insert into customer (emailAddress, firstName, lastName, password, username) values ('test4@tinyurl.com', 'Alex', 'Sack', 'test4', 'test4');



insert into orders (addressCity, addressCountry, addressStreet, createdAt, customerId) values ('Roma', 'Italy', '158 Saint Paul Pass', '2019-12-01 3:20:07', 1);
insert into orders (addressCity, addressCountry, addressStreet, createdAt, customerId) values ('New Jersey', 'United States', '1362 Old Mount Ave', '2019-06-19 17:51:27', 4);
insert into orders (addressCity, addressCountry, addressStreet, createdAt, customerId) values ('Bektas', 'Indonesia', '96360 West Java Place', '2019-08-27 09:40:26', 3);
insert into orders (addressCity, addressCountry, addressStreet, createdAt, customerId) values ('Ontario', 'Canada', '10 Ave Saint Marcelo', '2019-08-07 12:34:16', 2);


insert into revenue (date, sum, locationId) values ('2019-03-02 ', 25.19, 1);
insert into revenue (date, sum, locationId) values ('2019-09-23 ', 17.68, 3);
insert into revenue (date, sum, locationId) values ('2019-03-03 ', 5.24, 2);
insert into revenue (date, sum, locationId) values ('2019-12-01 ', 27.5, 4);



insert into OrderDetail (quantity, orderId, productId) values (5, 2, 3);
insert into OrderDetail (quantity, orderId, productId) values (8, 1, 4);
insert into OrderDetail (quantity, orderId, productId) values (1, 3, 1);
insert into OrderDetail (quantity, orderId, productId) values (1, 4, 2);
