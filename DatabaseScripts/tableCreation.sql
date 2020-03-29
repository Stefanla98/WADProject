CREATE TABLE users  (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    email VARCHAR(45),
	gender VARCHAR(45),
	telephone VARCHAR(45),
	restaurant VARCHAR(45),
	subscribed VARCHAR(45),
    PRIMARY KEY (id));
