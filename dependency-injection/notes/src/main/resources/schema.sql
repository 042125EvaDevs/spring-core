CREATE DATABASE IF NOT EXISTS user_management;

CREATE TABLE address (
  id INT PRIMARY KEY AUTO_INCREMENT,
  building_number INT,
  street_name VARCHAR(75),
  city VARCHAR(75),
  state VARCHAR(75),
  zipCode INT(5),
  unit_number VARCHAR(75)
);

CREATE TABLE user_entity (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  email VARCHAR(75) UNIQUE,
  password VARCHAR(75),
  address_id INT UNIQUE,
  FOREIGN KEY(address_id) REFERENCES address(id)
);
