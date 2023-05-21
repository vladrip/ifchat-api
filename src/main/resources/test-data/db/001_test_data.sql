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


insert into person (uid, first_name, last_name, phone_number, tag, online_at)
values ('aO88iCDWDEaOrvMGIYW0L8Yapig1', 'Vladyslav', 'Ripskyi', '+380123456789', 'vladrip', '2023-03-16 05:06:20.000000'),
       ('cB4o1nENC4WIEhzYiNlNvyF2bj83', 'Adam', 'Brown', '+12345678900', 'ymattiazzo9', '2022-02-17 22:52:53.000000');
--        ('Hadlee', 'Channon', '+54613 973 4854', null, '2022-02-10 18:37:49.000000'),
--        ('Joleen', 'Domengue', '+3578606401457', 'jdomengue3', '2022-02-13 13:48:30.000000'),
--        ('Davin', 'Woolliams', '+648843632187', 'dwoolliams4', '2022-01-14 10:18:15.000000'),
--        ('Merilee', 'Leupold', '+86126 623 0683', 'mleupold5', '2022-01-28 15:53:02.000000'),
--        ('Constanta', 'Peerman', '+605412794295', null, '2022-02-17 00:01:32.000000'),
--        ('Peri', 'Beazley', '+19146157700', 'pbeazley7', '2022-02-26 18:25:53.000000'),
--        ('Carey', 'Marvel', '+375574 882 6125', 'cmarvel8', '2022-01-14 02:43:35.000000'),
--        ('Bibbye', 'Audas', '+866598469050', 'baudas1', '2022-01-27 02:41:47.000000'),
--        ('Nert', 'Mandy', '+9769059034149', null, '2022-02-27 00:14:13.000000'),
--        ('Marley', 'Thirlaway', '+557247078414', null, '2022-02-09 01:15:53.000000'),
--        ('Nerte', 'Lasty', '+862761603592', 'nlastyc', '2022-01-20 16:34:40.000000'),
--        ('Mackenzie', 'Beville', '+863043623354', null, '2022-02-25 01:40:27.000000'),
--        ('Nanice', 'Bleier', '+621165278676', null, '2022-02-19 00:27:05.000000'),
--        ('Michale', 'McWhannel', '+628678864234', 'mmcwhannelf', '2021-11-24 03:21:18.000000'),
--        ('Sherwynd', 'Drinkwater', '+866112311696', 'sdrinkwaterg', '2022-02-25 01:28:28.000000'),
--        ('Nani', 'de Zamora', '+2491171435088', 'ndezamorah', '2021-12-21 17:41:01.000000'),
--        ('Nissie', 'De Luna', '+811974276682', 'ndelunai', '2022-02-17 12:01:24.000000'),
--        ('Celie', 'Scrine', '+3804093968623', 'cscrinej', '2022-02-04 16:59:53.000000');


--groups ids: 6,7,9,10,18,20,25,26,28
insert into chat_member (chat_id, person_uid, chat_muted)
values (1, 'aO88iCDWDEaOrvMGIYW0L8Yapig1', false),
       (1, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', false),
       (6, 'aO88iCDWDEaOrvMGIYW0L8Yapig1', false),
       (6, 'cB4o1nENC4WIEhzYiNlNvyF2bj83', false);

-- insert into message (chat_id, sender_uid, sent_at, content)
-- values
