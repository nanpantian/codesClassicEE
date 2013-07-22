drop database if exists auction;

create database auction;

use auction;

#�û���
create table auction_user(
  user_id int(11) auto_increment,
  username varchar(50) not null,
  userpass varchar(50) not null,
  email varchar(100) not null,
  primary key(user_id),
  unique(username)
);

INSERT INTO auction_user (username,userpass,email) VALUES ('tomcat','tomcat','luganlin88@163.com');
INSERT INTO auction_user (username,userpass,email) VALUES ('mysql','mysql','luganlin88@163.com');

#��Ʒ�����
create table kind(
  kind_id int(11) auto_increment,
  kind_name varchar(50) not null, 
  kind_desc varchar(255) not null,
  primary key(kind_id)
);

INSERT INTO kind (kind_name,kind_desc) VALUES ('computer hardware','cheap price');
INSERT INTO kind (kind_name,kind_desc) VALUES ('estate','rare house');

#��Ʒ״̬��
create table state(
  state_id int(11) auto_increment,
  state_name varchar(50),
  primary key(state_id)
);

INSERT INTO state (state_name) VALUES ('in auaction');
INSERT INTO state (state_name) VALUES ('succeeded');
INSERT INTO state (state_name) VALUES ('faied');

#��Ʒ��
drop table item;
create table item(
  item_id int(11) auto_increment,
  item_name varchar(255) not null,
  item_remark varchar(255) not null,
  item_desc varchar(255),
  kind_id int(11) not null, 
  addtime date not null,
  endtime date not null,
  init_price double not null, 
  max_price double not null, 
  owner_id int(11) not null, 
  winer_id int(11), 
  state_id int(11) not null, 
  primary key(item_id),
  FOREIGN KEY(kind_id) REFERENCES kind(kind_id), 
  FOREIGN KEY(owner_id) REFERENCES auction_user(user_id),
  FOREIGN KEY(winer_id) REFERENCES auction_user(user_id),
  FOREIGN KEY(state_id) REFERENCES state(state_id)
); 

describe item;

INSERT INTO item ( item_name , item_remark , item_desc, kind_id, addtime , endtime, init_price,  max_price,  owner_id,  winer_id,  state_id)
	VALUES ( 'motherboard', 'old motherboard', 'old motherboard usable', 1, '2009-02-06', CURDATE()+92, 230, 250, 1,  null,  1);

INSERT INTO item ( item_name , item_remark , item_desc, kind_id, addtime , endtime, init_price,  max_price,  owner_id,  winer_id,  state_id)
	VALUES ( 'display card', 'old display card', 'old card usable', 1, '2009-10-10', CURDATE()-2, 210, 210, 2,  null,  3);

INSERT INTO item ( item_name , item_remark , item_desc, kind_id, addtime , endtime, init_price,  max_price,  owner_id,  winer_id,  state_id)
	VALUES ( 'house', 'old house', '40 years old', 2, '2009-12-12', CURDATE()-5, 21000, 25000, 2,  1,  2);

select * from item;

#������ʷ��
create table bid(
  bid_id int(11) auto_increment,
  user_id int(11) not null,
  item_id int(11) not null,
  bid_price double not null,
  bid_date date not null, 
  primary key(bid_id),
  unique(item_id , bid_price),
  FOREIGN KEY(user_id) REFERENCES auction_user(user_id), 
  FOREIGN KEY(item_id) REFERENCES item(item_id)   
);

INSERT INTO bid ( user_id , item_id , bid_price, bid_date)
	VALUES ( 2, 1, 250, CURDATE()-2);
INSERT INTO bid ( user_id , item_id , bid_price, bid_date)
	VALUES ( 1, 3, 25000, CURDATE()-6);

select * from bid;

