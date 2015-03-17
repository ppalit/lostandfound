create table reporter(first_name varchar(20),last_name varchar(20),email_id varchar(40) primary key, phone_no varchar(20));

create table item_primary(item_id integer primary key autoincrement,category varchar(20),sub_category varchar(20),public_description varchar(400),
secret_description varchar(300), item_found_date datetime default current_timestamp, item_reported_date datetime default current_timestamp, street_address varchar(100), lat varchar(20), lng varchar(20),
 loc_type varchar(10), city varchar(50), country varchar(50), state varchar(80),reporter_id varchar(40),FOREIGN KEY(reporter_id) REFERENCES reporter(email_id));

alter table item_primary add colour varchar(100);

