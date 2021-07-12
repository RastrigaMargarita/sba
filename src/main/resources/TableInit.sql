DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS productlist;
DROP TABLE IF EXISTS customers;

CREATE TABLE `store`.`customers` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `name` VARCHAR(45) NULL,
                                     PRIMARY KEY (`id`));

CREATE TABLE `store`.`productlist` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `title` VARCHAR(45) NULL,
                                     `price` DOUBLE NULL,
                                     PRIMARY KEY (`id`));

CREATE TABLE `store`.`purchases` (
                                     `id` INT NOT NULL AUTO_INCREMENT,
                                     `price` DOUBLE NULL,
                                     `product` integer REFERENCES productlist (`id`),
                                     `customer` integer REFERENCES customers (`id`),
                                     PRIMARY KEY (`id`));


