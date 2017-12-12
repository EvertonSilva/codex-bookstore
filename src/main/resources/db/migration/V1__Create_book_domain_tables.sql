CREATE TABLE books (
  id INT primary key,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  title VARCHAR(50) NOT NULL,
  edition VARCHAR(20) NOT NULL,
  synopsis VARCHAR(500) NOT NULL,
  isbn VARCHAR(13) NOT NULL,
  barcode VARCHAR(13) NOT NULL,
  publishYear VARCHAR(4) NOT NULL,
  numberOfPages VARCHAR(4) NOT NULL,
  height INT NOT NULL,
  width INT NOT NULL,
  depth INT NOT NULL,
  weight INT NOT NULL,
  author_id INT NOT NULL,
  sales_paremeters_id INT NOT NULL,
  price_group_id INT NOT NULL,
  publisher_id INT NOT NULL,
  created_at TIMESTAMP NOT NULL,
  update_at TIMESTAMP NOT NULL,
  
);

CREATE TABLE authors (
  id INT primary key,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,
  
);

CREATE TABLE publishers (
  id INT primary key,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  name VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE categories (
  id INT primary key,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(500) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE sales_parametrization (
  id INT primary key,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  min_sale_limit INT NOT NULL,
  periodicity INT NOT NULL,
  periodicity_unit VARCHAR(255) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE price_group (
  id INT primary key,
  enabled BOOLEAN NOT NULL DEFAULT FALSE,
  markup DECIMAL NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);

CREATE TABLE books_categories (
  id INT primary key,
  book_id INT NOT NULL,
  category_id INT NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);
-- 
-- ALTER TABLE books ADD CONSTRAINT books_fk0 FOREIGN KEY (author_id) REFERENCES authors(id);
-- 
-- ALTER TABLE books ADD CONSTRAINT books_fk1 FOREIGN KEY (sales_paremeters_id) REFERENCES sales_parametrization(id);
-- 
-- ALTER TABLE books ADD CONSTRAINT books_fk2 FOREIGN KEY (price_group_id) REFERENCES price_group(id);
-- 
-- ALTER TABLE books ADD CONSTRAINT books_fk3 FOREIGN KEY (publisher_id) REFERENCES publishers(id);
-- 
-- ALTER TABLE books_categories ADD CONSTRAINT books_categories_fk0 FOREIGN KEY (book_id) REFERENCES books(id);
-- 
-- ALTER TABLE books_categories ADD CONSTRAINT books_categoriess_fk1 FOREIGN KEY (category_id) REFERENCES categories(id);

--CREATE USER gutenberg PASSWORD 'letter4thepeople';
--GRANT ALL ON SCHEMA PUBLIC TO gutenberg;