CREATE TABLE reservations (
	id INT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(45) NOT NULL,
    lastName VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    telephone VARCHAR(45) NOT NULL,
    date VARCHAR(45) NOT NULL,
    noGuests VARCHAR(45) NOT NULL,
    timeFrom VARCHAR(45) NOT NULL,
    timeTo VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);