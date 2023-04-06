CREATE TABLE toppings
(
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    id   INTEGER       NOT NULL AUTO_INCREMENT,
    email VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_toppings
(
    user_id    INTEGER NOT NULL,
    topping_id INTEGER NOT NULL
);