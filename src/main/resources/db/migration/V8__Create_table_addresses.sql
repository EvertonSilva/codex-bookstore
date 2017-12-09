CREATE TABLE `addresses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `alias` varchar(30),
  `district` varchar(30) NOT NULL,
  `number` varchar(10) NOT NULL,
  `postal_code` varchar(20) NOT NULL,
  `public_place_name` varchar(200) NOT NULL,
  `public_place_type` varchar(50) NOT NULL,
  `city_id` INT NOT NULL,
  `customer_id` INT NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);