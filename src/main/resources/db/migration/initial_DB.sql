DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;

CREATE TYPE roles AS ENUM ('USER', 'ADMIN');
CREATE TABLE users
(
    id               BIGSERIAL PRIMARY KEY                     ,
    lastname         VARCHAR                                   ,
    firstname        VARCHAR                           NOT NULL,
    middlename       VARCHAR                                   ,
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