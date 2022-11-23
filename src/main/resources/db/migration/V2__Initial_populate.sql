DELETE FROM user_roles;
DELETE FROM users;


INSERT INTO users (last_name, first_name, middle_name, email, password, phone )
VALUES ('Иванов', 'Иван', 'Иванович', 'ivan@yandex.ru', 'password', '78005553535'),
       ('Петров', 'Петр', 'Викторович', 'petr@yandex.ru', 'password', '79005003903'),
       ('Какойто', 'Какой', 'Какойтович', 'kak@yandex.ru', 'password', '78005553530');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 3);