-- liquibase formatted sql

-- changeset alkor:1
CREATE TABLE users (
                       user_id INTEGER generated by default as identity PRIMARY KEY,
                       username VARCHAR(32) NOT NULL unique,
                       password VARCHAR(255) NOT NULL,
                       first_name VARCHAR(16) NOT NULL,
                       last_name VARCHAR(16) NOT NULL,
                       phone VARCHAR(16) NOT NULL,
                       avatar_path VARCHAR(255),
                       role VARCHAR(16) NOT NULL,
                       register_date TIMESTAMP,
                       CONSTRAINT phone_user_constraint CHECK (phone LIKE ('+7%'))
);

INSERT INTO users (username, password, first_name, last_name, phone, role)
VALUES ('admin0@mail.ru', '$2a$12$lV7lTQdu3Elm7m3bdAAxWOs3GjvMSIYUYE7gGMqO/KF2NLakrCWdu', 'Admin0', 'Admialov', '+77777777777', 'ADMIN');
