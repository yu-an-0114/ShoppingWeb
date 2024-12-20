CREATE DATABASE IF NOT EXISTS ShoppingWeb;
GRANT ALL PRIVILEGES ON ShoppingWeb.* TO 'root'@'%';
FLUSH PRIVILEGES;
USE ShoppingWeb;

CREATE TABLE member (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        member_status INT NOT NULL ,
                        phone VARCHAR(15) NOT NULL UNIQUE,
                        email VARCHAR(255) NOT NULL UNIQUE,
                        verified INT NOT NULL DEFAULT 0,
                        permission INT NOT NULL DEFAULT 1,
                        register_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        password VARCHAR(255) NOT NULL
);

CREATE TABLE category (
                          category_id INT AUTO_INCREMENT PRIMARY KEY ,
                          category_name VARCHAR(255) UNIQUE NOT NULL,
                          category_discount DOUBLE NOT NULL
);

CREATE TABLE coupon (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        member_id INT NOT NULL,
                        start_date DATETIME NOT NULL,
                        end_date DATETIME NOT NULL,
                        discount DOUBLE NOT NULL,
                        category_id INT,
                        low_limit INT,
                        FOREIGN KEY (member_id) REFERENCES member(id),
                        FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         product_name VARCHAR(255) NOT NULL,
                         price INT NOT NULL,
                         sold_out BOOLEAN NOT NULL,
                         description VARCHAR(255),
                         stock INT NOT NULL,
                         reserved_stock INT,
                         sales INT NOT NULL,
                         publish_date DATETIME NOT NULL,
                         modified_date DATETIME,
                         image VARCHAR(255) NOT NULL,
                         category_id INT NOT NULL,
                         enabled BOOLEAN NOT NULL,
                         FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        member_id INT NOT NULL,
                        order_date DATETIME NOT NULL,
                        shipping_date DATETIME,
                        delivery_date DATETIME,
                        address VARCHAR(255) NOT NULL,
                        shipping_fee INT NOT NULL,
                        coupon_id INT,
                        total_cost INT NOT NULL,
                        payment_method INT NOT NULL,
                        note VARCHAR(255),
                        order_status INT  NOT NULL,
                        FOREIGN KEY (member_id) REFERENCES member(id),
                        FOREIGN KEY (coupon_id) REFERENCES coupon(id)
);

CREATE TABLE orderLine (
                           orderLine_id INT AUTO_INCREMENT PRIMARY KEY,
                           order_id INT NOT NULL,
                           product_id INT NOT NULL,
                           quantity INT NOT NULL,
                           note VARCHAR(255),
                           FOREIGN KEY (order_id) REFERENCES orders(id),
                           FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE rating (
                        rating_id INT AUTO_INCREMENT PRIMARY KEY,
                        order_id INT NOT NULL,
                        product_id INT NOT NULL,
                        member_id INT NOT NULL,
                        rating_score INT NOT NULL,
                        rating_comment VARCHAR(255),
                        rating_date DATETIME NOT NULL,
                        FOREIGN KEY (order_id) REFERENCES orders(id),
                        FOREIGN KEY (product_id) REFERENCES product(id),
                        FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE cart (
                      cart_id INT AUTO_INCREMENT PRIMARY KEY,
                      quantity INT NOT NULL,
                      product_id INT NOT NULL,
                      user_id INT NOT NULL,
                      FOREIGN KEY (product_id) REFERENCES product(id),
                      FOREIGN KEY (user_id) REFERENCES member(id)
);


INSERT INTO member (name, member_status, phone, email, verified, permission, password)
VALUES
    ('Manager', 1, '1234567890', 'manager@manager.com', 1, 0, 'password');



