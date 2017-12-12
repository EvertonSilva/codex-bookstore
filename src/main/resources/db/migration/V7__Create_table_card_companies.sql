CREATE TABLE card_companies (
  id INT NOT NULL AUTO_INCREMENT,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  name varchar(20) NOT NULL,
  code varchar(5) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);