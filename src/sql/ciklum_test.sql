CREATE DATABASE IF NOT EXISTS ciklum_test;
USE ciklum_test ;

DROP TABLE IF EXISTS order_items ;
DROP TABLE IF EXISTS orders ;
DROP TABLE IF EXISTS products ;

CREATE TABLE IF NOT EXISTS orders (
id INT NOT NULL AUTO_INCREMENT,
user_id INT,
status VARCHAR(15),
created_at VARCHAR(20),
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS products (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(15),
price INT,
status ENUM('out_of_stock', 'in_stock', 'running_low'),
created_at DATETIME,
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS order_items (
order_id INT NOT NULL,
product_id INT NOT NULL,
quantity INT,
FOREIGN KEY(order_id) REFERENCES orders(id) ON DELETE CASCADE,
FOREIGN KEY(product_id) REFERENCES products(id) ON DELETE CASCADE
);

INSERT INTO products VALUES(1, 'shampoo', 80, 'in_stock', '2021-06-23 10:37');
INSERT INTO products VALUES(2, 'soap', 50, 'out_of_stock', '2021-08-01 14:09');
INSERT INTO products VALUES(3, 'hand cream', 280, 'running_low', '2021-05-10 08:54');
INSERT INTO products VALUES(4, 'toothpaste', 100, 'in_stock', '2021-06-30 12:22');

INSERT INTO orders VALUES(1, 101, 'packed', '2021-09-03 10:32');
INSERT INTO orders VALUES(2, 102, 'delivered', '2021-09-03 10:32');
INSERT INTO orders VALUES(3, 103, 'posting', '2021-09-03 10:32');

INSERT INTO order_items VALUES(2, 1, 2);
INSERT INTO order_items VALUES(2, 2, 1);
INSERT INTO order_items VALUES(2, 4, 3);
INSERT INTO order_items VALUES(1, 3, 1);
INSERT INTO order_items VALUES(3, 2, 5);