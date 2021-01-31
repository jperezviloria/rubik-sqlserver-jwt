CREATE TABLE users(
    idUsers INT IDENTITY (1,1) NOT NULL,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    email VARCHAR(80) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY (idUsers)
)