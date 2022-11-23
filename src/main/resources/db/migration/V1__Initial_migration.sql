DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS product_plate;
DROP TABLE IF EXISTS abstract_object_plate;

CREATE TYPE roles AS ENUM ('USER', 'ADMIN');

CREATE TABLE abstract_object_plate (
   id INT PRIMARY KEY,
   created_at DATE,
   name VARCHAR(255),
   description TEXT
);

CREATE TABLE product_plate (
    id INT REFERENCES abstract_object_plate (id),
    calories INT,
    created_at DATE,
    name VARCHAR(255),
    description TEXT
);




CREATE TABLE users
(
    id               BIGSERIAL PRIMARY KEY                     ,
    last_name         VARCHAR                                   ,
    first_name        VARCHAR                           NOT NULL,
    middle_name       VARCHAR                                   ,
    email            VARCHAR                           NOT NULL,
    password         VARCHAR                           NOT NULL,
    registered       TIMESTAMP           DEFAULT now() NOT NULL,
    updated          TIMESTAMP           DEFAULT now() NOT NULL,
    enabled          BOOL                DEFAULT TRUE  NOT NULL,
    phone            VARCHAR
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR NOT NULL,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);