CREATE TABLE `customers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `enabled` BOOLEAN NOT NULL DEFAULT FALSE,
  `identification_doc` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` DATE NOT NULL,
  `gender` INT NOT NULL,
  `phone` varchar(20) NOT NULL,
  `user_id` INT NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `updated_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`)
);
