drop database javaee;
create database javaee;
use javaee;

create table users_table(
 userid int auto_increment primary key,
 username varchar(64) unique, 
 password VARCHAR(64)
);
create table roles_table
(
 roleid  int auto_increment primary key,
 username varchar(64),
 userRoles varchar(32)
);
# ����һ���û�
insert into users_table 
values(null, 'yeeku','123');
# ����һ���û����Լ�����Ӧ�Ľ�ɫ
insert into roles_table 
values(null ,'yeeku','crazyit');
