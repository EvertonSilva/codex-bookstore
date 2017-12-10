CREATE TABLE `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enabled` BOOLEAN NOT NULL DEFAULT FALSE,
  `email` varchar(50) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);