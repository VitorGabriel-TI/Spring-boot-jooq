CREATE TABLE IF NOT EXISTS users (
    username VARCHAR(50) NOTNULL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL 
);