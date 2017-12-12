CREATE TABLE cities (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  state_id INT(1) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE states (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  country_id INT(1) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE countries (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);