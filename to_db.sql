insert into users(id, password, surname, username)
VALUES (1, 'root', 'user1s', 'user1');

insert into users(id, password, surname, username)
VALUES (2, 'root', 'user2s', 'user2');

insert into users(id, password, surname, username)
VALUES (3, 'root', 'user3s', 'user3');

insert into roles(id, role_name) VALUES (1, 'ROLE_USER');
insert into roles(id, role_name) VALUES (2, 'ROLE_ADMIN');

insert into users_roles(user_id, role_id) VALUES (1, 1);
insert into users_roles(user_id, role_id) VALUES (2, 2);
insert into users_roles(user_id, role_id) VALUES (3, 1);
insert into users_roles(user_id, role_id) VALUES (3, 2);