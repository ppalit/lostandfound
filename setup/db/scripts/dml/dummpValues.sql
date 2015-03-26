PRAGMA foreign_keys=ON;
BEGIN TRANSACTION;

INSERT INTO "reporter" VALUES('Priyabrata','Palit','priyabrata.palit@gmail.com','8764583648','GOOGLE','2015-03-22 15:05:42');
INSERT INTO "reporter" VALUES('Siddhartha','Behera','siddharthabehera@gmail.com','784235667425','FACEBOOK','2015-03-22 15:05:42');
INSERT INTO "reporter" VALUES('Anuskha','Sharma','anuksha.sharma@gmail.com','784235667425','FACEBOOK','2015-03-22 15:05:42');
INSERT INTO "reporter" VALUES('Sunny','Leony','sunny.leony@gmail.com','54235235','EMAIL','2015-03-22 15:05:42');
INSERT INTO "reporter" VALUES('Chitangana','Singh','chitra.singh@gmail.com','25425234','GOOGLE','2015-03-22 15:05:42');

INSERT INTO "item_primary" VALUES(1,'category1','sub_category1','public_description public_description public_description public_description','secret_description secret_description','2015-03-22 15:05:42','2015-03-22 15:05:42','street_address1 street_address','68.722885','-101.09166','APPROXIMATE','Edinburgh','USA','PA','priyabrata.palit@gmail.com','blue');
INSERT INTO "item_primary" VALUES(2,'category5','sub_category3','this is public descriptifihdfjon8','this is secret_description4 ',NULL,'2015-03-21 23:44:15','street_address2 street_address3','53.542','-34.722885','APPROXIMATE','Philadelphia','USA','PA',NULL,'brown');
INSERT INTO "item_primary" VALUES(3,'category3','sub_category1','jbjhbhg','bjhbjhb',NULL,'2015-03-22 15:05:42','nhbjvh','40.05638499145965','-75.1325717443147','ROOFTOP','Philadelphia','United States',NULL,'anuksha.sharma@gmail.com','green');
INSERT INTO "item_primary" VALUES(4,'category3','sub_category1','sbdfhdb','fdsjfjhg',NULL,'2015-03-22 15:25:52','kfdhjfhg','40.05650890217629','-75.13263043853169','ROOFTOP','Philadelphia','United States',NULL,'anuksha.sharma@gmail.com','red');
INSERT INTO "item_primary" VALUES(5,'category3','sub_category1','hbsdjhfvhgs','dbfhdgvghv jdbjfh',NULL,'2015-03-22 15:35:18','dfshgdv','40.05650890217629','-75.13263043853169','ROOFTOP','Philadelphia','United States',NULL,'sunny.leony@gmail.com','green');
INSERT INTO "item_primary" VALUES(6,'category1','sub_category5','','',NULL,'2015-03-22 22:14:08','','55.86220432158161','-3.399508610787734','APPROXIMATE','Edinburgh','United Kingdom',NULL,'chitra.singh@gmail.com','');
INSERT INTO "item_primary" VALUES(7,'category1','sub_category2','','',NULL,'2015-03-22 22:14:13','','55.832907803641696','-3.135836735787734','ROOFTOP','Edinburgh','United Kingdom',NULL,'chitra.singh@gmail.com','black');
INSERT INTO "item_primary" VALUES(8,'category5','sub_category5','','',NULL,'2015-03-22 22:14:17','','56.05132705305858','-3.042452946725234','ROOFTOP','Musselburgh','United Kingdom',NULL,'sunny.leony@gmail.com','black');
INSERT INTO "item_primary" VALUES(9,'category5','sub_category5','','',NULL,'2015-03-22 22:14:38','','56.13100371608679','-7.461703435006484','ROOFTOP','Musselburgh','United Kingdom',NULL,'chitra.singh@gmail.com','green');
INSERT INTO "item_primary" VALUES(10,'category3','sub_category5','','',NULL,'2015-03-22 22:14:43','','56.088121380027985','-7.489169255318984','ROOFTOP','Musselburgh','United Kingdom',NULL,'siddharthabehera@gmail.com','green');
INSERT INTO "item_primary" VALUES(11,'category2','sub_category1','','',NULL,'2015-03-22 22:14:51','','56.0006774854029','-5.890658513131484','APPROXIMATE','Musselburgh','United Kingdom',NULL,'sunny.leony@gmail.com','green');
INSERT INTO "item_primary" VALUES(12,'category1','sub_category5','','',NULL,'2015-03-24 17:07:18','','','','','','',NULL,'siddharthabehera@gmail.com','brown');
INSERT INTO "item_primary" VALUES(13,'category2','sub_category5','','',NULL,'2015-03-24 17:07:34','','20.2960587','85.82453980000003','APPROXIMATE','Bhubaneshwar','India',NULL,'chitra.singh@gmail.com','red');
INSERT INTO "item_primary" VALUES(14,'category1','sub_category2','','',NULL,'2015-03-24 17:07:47','','20.460838262915406','85.90968384296878','ROOFTOP','Cuttack','India',NULL,'chitra.singh@gmail.com','reed');
INSERT INTO "item_primary" VALUES(15,'category5','sub_category3','this is public description8','this is secret_description4 ',NULL,'2015-03-24 20:10:21','street_address2 street_address3','40.056118','-75.132747','APPROXIMATE','Philadelphia','USA','PA','priyabrata.palit@gmail.com','black');
INSERT INTO "item_primary" VALUES(16,'category5','sub_category2','','',NULL,'2015-03-25 18:49:44','','','','','','',NULL,'siddharthabehera@gmail.com','white');
DELETE FROM sqlite_sequence;
INSERT INTO "sqlite_sequence" VALUES('item_primary',16);

COMMIT;
