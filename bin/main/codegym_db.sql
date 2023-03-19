drop database if exists truemart;
create database truemart;
use truemart;
CREATE TABLE `users`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `role` VARCHAR(255) NOT NULL,
    `firstname` VARCHAR(255) NOT NULL,
    `lastname` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `phonenumber` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL
);

CREATE TABLE `payments`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `shop_name` VARCHAR(255) NOT NULL,
    `quantity` INT NOT NULL,
    `status` VARCHAR(255) NOT NULL,
    `payment_type` VARCHAR(255) NOT NULL
);

CREATE TABLE `order_details`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `cart_details_id` INT NOT NULL,
    `payments_id` INT NOT NULL,
    `total` INT NOT NULL
);

CREATE TABLE `cart_details`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `total` INT NOT NULL
);

CREATE TABLE `cart_item`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `product_id` INT NOT NULL,
    `carts_id` INT NOT NULL,
    `quantity` INT NOT NULL
);
CREATE TABLE `product`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `category_id` INT NOT NULL,
    `shop_id` INT NOT NULL,
    `image` VARCHAR(255) NOT NULL,
    `price` INT NOT NULL,
    `decription` TEXT NOT NULL,
    `details` TEXT NOT NULL
);

CREATE TABLE `category`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(255) NOT NULL
);

CREATE TABLE `notification`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `shop_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    `content` TEXT NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NOT NULL
);

CREATE TABLE `shop`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_name` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `shop_name` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL
);

CREATE TABLE `comment`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `post_id` INT NOT NULL,
    `comment` TEXT NOT NULL
);

CREATE TABLE `post`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `shop_id` INT NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `body` TEXT NOT NULL,
    `post_date` DATETIME NOT NULL
);

CREATE TABLE `order_item`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `order_details_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `quantity` INT NOT NULL
);

CREATE TABLE `discount`(
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `shop_id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `discount_percent` DECIMAL(8, 2) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `modified_at` TIMESTAMP NOT NULL
);

CREATE TABLE `Rating`(
    `rating_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `product_id` INT NOT NULL,
    `score` VARCHAR(255) NOT NULL,
    `re_marks` VARCHAR(255) NOT NULL,
    `date_records` DATETIME NOT NULL
);

ALTER TABLE
    `notification` ADD CONSTRAINT `notification_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `order_details` ADD CONSTRAINT `order_details_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `order_details` ADD CONSTRAINT `order_details_payments_id_foreign` FOREIGN KEY(`payments_id`) REFERENCES `payments`(`id`);
ALTER TABLE
    `cart_details` ADD CONSTRAINT `cart_details_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `cart_item` ADD CONSTRAINT `cart_item_carts_id_foreign` FOREIGN KEY(`carts_id`) REFERENCES `cart_details`(`id`);
ALTER TABLE
    `cart_item` ADD CONSTRAINT `cart_item_product_id_foreign` FOREIGN KEY(`product_id`) REFERENCES `product`(`id`);
ALTER TABLE
    `Rating` ADD CONSTRAINT `rating_product_id_foreign` FOREIGN KEY(`product_id`) REFERENCES `product`(`id`);
ALTER TABLE
    `product` ADD CONSTRAINT `product_category_id_foreign` FOREIGN KEY(`category_id`) REFERENCES `category`(`id`);
ALTER TABLE
    `product` ADD CONSTRAINT `product_shop_id_foreign` FOREIGN KEY(`shop_id`) REFERENCES `shop`(`id`);
ALTER TABLE
    `notification` ADD CONSTRAINT `notification_shop_id_foreign` FOREIGN KEY(`shop_id`) REFERENCES `shop`(`id`);
ALTER TABLE
    `post` ADD CONSTRAINT `post_shop_id_foreign` FOREIGN KEY(`shop_id`) REFERENCES `shop`(`id`);
ALTER TABLE
    `comment` ADD CONSTRAINT `comment_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
ALTER TABLE
    `comment` ADD CONSTRAINT `comment_post_id_foreign` FOREIGN KEY(`post_id`) REFERENCES `post`(`id`);
ALTER TABLE
    `order_item` ADD CONSTRAINT `ordercodegym_db_item_product_id_foreign` FOREIGN KEY(`product_id`) REFERENCES `product`(`id`);
ALTER TABLE
    `order_item` ADD CONSTRAINT `order_item_order_details_id_foreign` FOREIGN KEY(`order_details_id`) REFERENCES `order_details`(`id`);
ALTER TABLE
    `discount` ADD CONSTRAINT `discount_shop_id_foreign` FOREIGN KEY(`shop_id`) REFERENCES `shop`(`id`);
ALTER TABLE
    `Rating` ADD CONSTRAINT `rating_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `users`(`id`);
    

insert into users(username, password, role, firstname, lastname , email, phonenumber, address) values
("admin", "123456", "Admin", "Adonis", "Davis" , "admin123@gmail.com", "0123456789", "616 AERICK ST INGLEWOOD CA 90301-9207 USA"),
("user01", "123456", "Customer", "Conal", "Jones", "conal@gmail.com", "0123456789", "1150 YALE ST SANTA MONICA CA 90403-4828 USA"),
("user02", "123456", "Producter", "Ricardo", "Perry", "ricardo@gmail.com", "0123426789", "5306 HERMITAGE AVE VALLEY VILLAGE CA 91607-2514 USA"),
("leno", "123456", "Customer", "Leon", "Brown", "leno@gmail.com", "0123456789", "19201 RINALDI ST PORTER RANCH CA 91326-16ND USA");


insert into shop(user_name, password, shop_name, address) values
("shoplea", "123456", "X Store", " LOS ANGELES/USA"),
("tuni", "123456", "Tuni Store", " LOS ANGELES/USA"),
("tuby099", "123456", "Tu bycatu", " LOS ANGELES/USA"),
("emily", "123456", "Emily Shop", " LOS ANGELES/USA"),
("heybey555", "123456", "HEYBEY", " LOS ANGELES/USA");


insert into category(category_name) values
("Phone"),
("Tivi"),
("Footwear"),
("Sport"),
("Accessories"),
("Book"),
("Clock"),
("Fashion"),
("Household appliances"),
("Cameras and Camcorders");


INSERT INTO payments (id, order_id, shop_name, quantity, status, payment_type) VALUES 
(1, 5, 'HEYBEY',6, 'sent', 'check'),
(2, 1, 'Emily Shop', 7, 'paid', 'credit card'),
(3, 4, 'Tu bycatu', 5, 'issued', 'store value card'),
(4, 2, 'Tuni Store', 4, 'partially paid', 'cash'),
(5, 3, 'X Store', 3, 'sent', 'Electronic bank transfers');

INSERT INTO product (id, name, category_id, shop_id, image, price, decription, details) VALUES
(1, 'Laptop Dell Gaming Inspiron 7501 X3MRY1', 5, 4, 'laptop7501.png', 2000, 'Dell 7501 X3MRY1 laptop owns a luxurious and classy design with delicate silver color. The machine is solidly finished in terms of a light, elegant exterior and even trimming at the edges. Weighing only 1.75kg is one of the advantages of this laptop, you can carry it anywhere with ease, without feeling heavy', 'made in China, CPU Intel Core i7-10750H, CPU Core i7, RAM 8GB, hard disk drive 512GB SSD M.2 NVMe /'),
(2, 'iPhone 11 Pro Max 64GB', 1, 3, 'iphone11Pro.png', 5000, 'The biggest iPhone in Apple’s lineup, the iPhone 11 Pro Max looks like an incremental upgrade over the iPhone XS Max but it brings some significant changes under the hood. There’s a triple camera setup at the back now, letting you choose between the Wide, Ultra Wide, and Telephoto lenses. The Camera app makes it seamless to pick one or the other, presenting the Ultra Wide camera as a 0.5x zoom, which is certainly an interesting perspective. All this is backed by improved HDR and a brand new Night Mode, which means you get excellent image and video quality in most conditions. For the first time in years, Apple’s phones not only compete, but often surpass the competition in terms of low light photography', 'Brand Apple, Model iPhone 11 Pro Max, Processor hexa-core, RAM	4GB, Internal storage 4GB, Operating system	iOS 13' ),
(3, 'Radeon RX 5600 XT GAMING MX', 3, 2, 'cardmx.png', 458, 'Great gaming experiences are created by bending the rules. The all new RDNA powered Radeon RX 5600 series for exceptional performance and High-fidelity gaming. Take control with Radeon RX 5600 series and experience powerful, accelerated gaming customized for you', 'Graphics AMD Radeon RX 5700, Bran MSI, Graphics 6 GB, GPU Clock 1620 MHz'),
(4, 'Apple AirPods Pro', 4, 1, 'airpodpro01.png', 399, 'Active Noise Cancellation blocks outside noise, so you can immerse yourself in music. Transparency mode for hearing and interacting with the world around you. Spatial audio with dynamic head tracking places sound all around you. Adaptive EQ automatically tunes music to your ears. Three sizes of soft, tapered silicone tips for a customizable fit', 'Brand Apple, Model Name	AirPods Pro, Color White, Form Factor In Ear, Connectivity USB, Bluetooth 5.0'),
(5, 'Acer Predator Aethon 301 TKL Gaming Keyboard', 2, 5, 'keyboard01.png', 69, 'The Gaming Predator Aethon 301 TKL mechanical keyboard is a mechanical keyboard product that is popular with young people, especially among gamers. The Aethon 301 TKL is compact and the bounce of each shortcut is very responsive, especially the sound emitted when large typing increases the feeling of victory when playing games', 'Brand Acer, Connectivity USB, Style	Aethon TKL, Item 14.6 x 5.77 x 1.05 inches, Included USB Cable');

select * from users where id = 5;

