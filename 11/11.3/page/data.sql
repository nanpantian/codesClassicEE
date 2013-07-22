drop database javaee;
create database javaee;
use javaee;

create table person_table
(
 personid int primary key auto_increment,
 name varchar(255),
 age int
);

create table address_table
(
 addressid int primary key auto_increment,
 detail varchar(255),
 person_id int,
 foreign key(person_id) references person_table(personid)
);

insert into person_table
values
(null, '�����' , 500),
(null, '��˽�' , 380),
(null, '�׾���' , 21),
(null, '����' , 21);

insert into address_table
values
(null, '����ɽ���� ˮ��������' , 1),
(null, '����ȡ��·' , 1),
(null, '����ׯ' , 2),
(null, '��ջ��' , 2),
(null, '��˿��' , 3);
