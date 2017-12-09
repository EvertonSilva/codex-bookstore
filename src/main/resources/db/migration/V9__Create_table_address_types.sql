CREATE TABLE `address_types` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `addresses_address_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address_type_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`)
);