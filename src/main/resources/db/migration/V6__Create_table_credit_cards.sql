CREATE TABLE `credit_cards` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enabled` BOOLEAN NOT NULL DEFAULT FALSE,
  `card_number` varchar(50) NOT NULL,
  `card_holder` varchar(50) NOT NULL,
  `security_code` varchar(3) NOT NULL,
  `expiration_date` DATE NOT NULL,
  `customer_id` INT NOT NULL,
  `company_id` INT NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);