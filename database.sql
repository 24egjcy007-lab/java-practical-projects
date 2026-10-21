CREATE DATABASE IF NOT EXISTS studentdb;
USE studentdb;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);

-- Optional sample record; the Java program also inserts a sample safely.
INSERT IGNORE INTO students (name, email)
VALUES ('Aarav Sharma', 'aarav@example.com');

SELECT * FROM students;
