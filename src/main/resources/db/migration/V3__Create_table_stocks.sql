CREATE TABLE `stocks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enabled` BOOLEAN NOT NULL DEFAULT FALSE,
  `book_id` INT NOT NULL REFERENCES `books`(`id`),
  `quantity` INT NOT NULL,
  `purchase_price` FLOAT NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);