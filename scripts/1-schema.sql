CREATE SCHEMA IF NOT EXISTS travelagents;
USE travelagents;
CREATE TABLE IF NOT EXISTS tbl_user (
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

CREATE TABLE IF NOT EXISTS tbl_city (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    code INTEGER(5),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tbl_tour_info (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    price_per_person DOUBLE NOT NULL,
    max_slot INTEGER(5) NOT NULL,
    duration INTEGER(5) NOT NULL,
    is_one_time TINYINT NOT NULL,
    agent_id INTEGER(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (agent_id) REFERENCES tbl_user(id)
);

CREATE TABLE IF NOT EXISTS tbl_image_url (
    id INTEGER(10) AUTO_INCREMENT,
    tour_info_id INTEGER(10) NOT NULL,
    url_image VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (tour_info_id) REFERENCES tbl_tour_info(id)
);

CREATE TABLE IF NOT EXISTS tbl_destination (
   id INTEGER(10) AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   content VARCHAR(1000),
   `day` INTEGER(10) NOT NULL,
   city_id INTEGER(10),
   tour_info_id INTEGER(10),
   PRIMARY KEY (id),
   FOREIGN KEY (city_id) REFERENCES tbl_city(id),
   FOREIGN KEY (tour_info_id) REFERENCES tbl_tour_info(id)
);

CREATE TABLE IF NOT EXISTS tbl_tour (
    id INTEGER(10) AUTO_INCREMENT,
    departure VARCHAR(255) NOT NULL,
    departure_time TIMESTAMP NOT NULL,
    tour_info_id INTEGER(10) NOT NULL,
    tour_guide_id INTEGER(10),
    PRIMARY KEY (id),
    FOREIGN KEY (tour_info_id) REFERENCES tbl_tour_info(id),
    FOREIGN KEY (tour_guide_id) REFERENCES tbl_user(id)
);

CREATE TABLE IF NOT EXISTS tbl_booking (
    id INTEGER(10) AUTO_INCREMENT,
    total_price DOUBLE NOT NULL,
    status VARCHAR(100) NOT NULL DEFAULT 'CONFIRMING',
    note VARCHAR(500),
    review VARCHAR(1000),
    rating INTEGER(5),
    customer_id INTEGER(10) NOT NULL,
    tour_id INTEGER(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES tbl_user(id),
    FOREIGN KEY (tour_id) REFERENCES tbl_tour(id)
);

CREATE TABLE IF NOT EXISTS tbl_visitor (
    id INTEGER(10) AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    gender VARCHAR(5),
    dob DATE,
    booking_id INTEGER(10) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (booking_id) REFERENCES tbl_booking(id)
);

CREATE TABLE IF NOT EXISTS tbl_agent (
    agent_id INTEGER(10) AUTO_INCREMENT,
    agent_name VARCHAR(255) NOT NULL,
    agent_tel CHAR(11) NOT NULL,
    agent_address VARCHAR(255) NOT NULL,
    agent_email VARCHAR(255) NOT NULL,
    agent_username VARCHAR(255) NOT NULL UNIQUE,
    agent_password VARCHAR(50) NOT NULL,
    role VARCHAR(100) NOT NULL,
    PRIMARY KEY(agent_id)
);

