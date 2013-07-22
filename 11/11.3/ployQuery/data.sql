drop database javaee;
create database javaee;
use javaee;
create table person_table
(
 id int primary key auto_increment,
 person_type varchar(255),
 name varchar(255),
 gender varchar(2),
 address_country varchar(255),
 address_detail varchar(255),
 address_zip varchar(255),
 comments varchar(255),
 salary double,
 title varchar(255),
 department varchar(255),
 employee_id int,
 manager_id int,
 foreign key(employee_id) references person_table(id),
 foreign key(manager_id ) references person_table(id)
);

insert into person_table
values
(null , '��ͨ��' , 'Yeeku' , '��' , '�й�' , '���' , '434333' , NULL , NULL , NULL , NULL , NULL , NULL),
(null , '����' , 'Grace' , 'Ů' , '����' , '����' , '523034' , NULL , 12000 , '��Ŀ����' , '�з���' , NULL , NULL),
(null , 'Ա��' , '����' , '��' , '�й�' , '����' , '523034' , NULL , 4500 , '��Ŀ�鳤' , NULL , NULL , 2),
(null , 'Ա��' , '������' , 'Ů' , '�й�' , '����' , '523034' , NULL , 5500 , '��Ŀ����' , NULL , NULL , 2),
(null , '�˿�' , 'С��' , '��' , '�й�' , '����' , '233034' , 'ϲ������' , NULL , NULL , NULL , 2 , NULL);
