CREATE TABLE `stocks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL REFERENCES `books`(`id`),
  `quantity` INT NOT NULL,
  `sale_price` FLOAT NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);