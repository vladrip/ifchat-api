INSERT INTO chat (name, description, type)
VALUES (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       ('Test Group', 'Big description about this test group', 'GROUP'),
       ('Richmont Mines, Inc.', 'leverage dot-com supply-chains', 'GROUP'),
       (NULL, NULL, 'PRIVATE'),
       ('Skiptube', NULL, 'GROUP'),
       ('Orix Corp Ads', NULL, 'GROUP'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       ('Jabberbean', NULL, 'GROUP'),
       (NULL, NULL, 'PRIVATE'),
       ('Kamba', 'brand proactive e-commerce', 'GROUP'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE'),
       ('Rexnord Corporation', NULL, 'GROUP'),
       ('Nuvectra Corporation', NULL, 'GROUP'),
       (NULL, NULL, 'PRIVATE'),
       ('Colgate-Palmolive Company', 'transition innovative deliverables', 'GROUP'),
       (NULL, NULL, 'PRIVATE'),
       (NULL, NULL, 'PRIVATE');


insert into person (uid, first_name, last_name, tag, online_at)
values ('FxxOZAP5lCTboBPVxZUjWBnCA6q1', 'Joe', 'Biden', 'joey', '2023-03-16 05:06:20'),
       ('cB4o1nENC4WIEhzYiNlNvyF2bj83', 'Barack', 'Obama', 'obamus', '2022-02-17 22:52:53'),
       ('VvAxL97jgNUTaEov4mzQ8avEGyH3', 'Donald', 'Trump', 'dump', '2022-02-10 18:37:49');


--groups ids: 6,7,9,10,18,20,25,26,28
insert into chat_member (chat_id, person_uid, chat_muted)
values (1, 'FxxOZAP5lCTboBPVxZUjWBnCA6q1', false),
       (1, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', false),
       (2, 'FxxOZAP5lCTboBPVxZUjWBnCA6q1', false),
       (2, 'VvAxL97jgNUTaEov4mzQ8avEGyH3', false),
       (3, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', false),
       (3, 'VvAxL97jgNUTaEov4mzQ8avEGyH3', false),
       (6, 'FxxOZAP5lCTboBPVxZUjWBnCA6q1', false),
       (6, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', false),
       (6, 'VvAxL97jgNUTaEov4mzQ8avEGyH3', false);


insert into message (chat_id, sender_uid, sent_at, content)
values (1, 'FxxOZAP5lCTboBPVxZUjWBnCA6q1', '2021-02-10 18:37:49', 'Hi'),
       (2, 'VvAxL97jgNUTaEov4mzQ8avEGyH3', '2023-06-01 12:19:57', 'Yo how u doing'),
       (3, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', '2023-02-17 15:14:23', 'Hello'),
       (6, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', '2023-06-02 20:55:10', 'Hello gentlemen. Lets play minecraft!')
