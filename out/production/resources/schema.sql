CREATE TABLE IF NOT EXISTS product(
product_id INT PRIMARY KEY AUTO_INCREMENT,
device NVARCHAR(30) NOT NULL,
direction NVARCHAR(30) NOT NULL,
technologies NVARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS payment(
payment_id INT PRIMARY KEY AUTO_INCREMENT,
price FLOAT(18,2)
);

CREATE TABLE IF NOT EXISTS product_user(
id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
product_id INT,
payment_id INT NULL,
payment_active BOOLEAN,
status ENUM('active', 'inactive', 'ordered') NOT NULL DEFAULT 'inactive',

FOREIGN KEY (payment_id) REFERENCES payment(payment_id),
FOREIGN KEY (product_id) REFERENCES product(product_id)
);

