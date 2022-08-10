USE travelagents;
CREATE TABLE IF NOT EXISTS tblUser (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    tel CHAR(11) NOT NULL,
    address VARCHAR(255) NOT NULL,
    dob DATE,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    enable TINYINT DEFAULT 1,
    role VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

-- CREATE UNIQUE INDEX idx_username
-- ON tblUser (username);

CREATE TABLE IF NOT EXISTS tblCity (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    code INTEGER(5),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tblTourInfo (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    pricePerPerson DOUBLE NOT NULL,
    maxSlot INTEGER(5) NOT NULL,
    duration INTEGER(5) NOT NULL,
    isOneTime TINYINT NOT NULL,
    agentId INTEGER(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (agentId) REFERENCES tblUser(id)
);

CREATE TABLE IF NOT EXISTS tblImageUrl (
    id INTEGER(10) AUTO_INCREMENT,
    tourInfoId INTEGER(10) NOT NULL,
    urlImage VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tourInfoId) REFERENCES tblTourInfo(id)
);

CREATE TABLE IF NOT EXISTS tblDestination (
   id INTEGER(10) AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   content VARCHAR(1000),
   `day` INTEGER(10) NOT NULL,
   cityId INTEGER(10),
   tourInfoId INTEGER(10),
   PRIMARY KEY (id),
   FOREIGN KEY (cityId) REFERENCES tblCity(id),
   FOREIGN KEY (tourInfoId) REFERENCES tblTourInfo(id)
);

CREATE TABLE IF NOT EXISTS tblTour (
    id INTEGER(10) AUTO_INCREMENT,
    departure VARCHAR(255) NOT NULL,
    departureTime TIMESTAMP NOT NULL,
    tourInfoId INTEGER(10) NOT NULL,
    tourGuideId INTEGER(10),
    PRIMARY KEY (id),
    FOREIGN KEY (tourInfoId) REFERENCES tblTourInfo(id),
    FOREIGN KEY (tourGuideId) REFERENCES tblUser(id)
);

CREATE TABLE IF NOT EXISTS tblBooking (
    id INTEGER(10) AUTO_INCREMENT,
    totalPrice DOUBLE NOT NULL,
    status VARCHAR(100) NOT NULL DEFAULT 'CONFIRMING',
    note VARCHAR(500),
    review VARCHAR(1000),
    rating INTEGER(5),
    customerId INTEGER(10) NOT NULL,
    tourId INTEGER(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customerId) REFERENCES tblUser(id),
    FOREIGN KEY (tourId) REFERENCES tblTour(id)
);

CREATE TABLE IF NOT EXISTS tblVisitor (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    gender VARCHAR(5),
    dob DATE,
    bookingId INTEGER(10) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (bookingId) REFERENCES tblBooking(id)
);