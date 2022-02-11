drop table if exists `book` CASCADE

CREATE TABLE books (
	bookid BIGINT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(255) NOT NULL,
	price FLOAT NOT NULL,
	stock INT NOT NULL,
	PRIMARY KEY (bookid)
);