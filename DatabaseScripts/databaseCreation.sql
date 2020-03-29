CREATE DATABASE wadproject;
SHOW DATABASES;
CREATE USER 'jdbcuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON wadproject.* TO 'jdbcuser'@'localhost';
FLUSH PRIVILEGES;
USE wadproject;

