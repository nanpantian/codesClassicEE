drop database javaee;
create database javaee;
use javaee;
create table news_table
(
 id int primary key auto_increment,
 news_title varchar(50),
 content varchar(255)
);

insert into news_table
values
(null , '���Java����' , '���Java���˳����ˡ�'),
(null , 'Java6������' , 'Java6�����ˣ����������˲��١�'),
(null , '������' , '�ȵ���һ�죬�����ˣ����������������ɵķҷ�'),
(null , '������' , '��һ�������������磬����Զ�����ҡ�����������ĺ��ӣ����й���ľ��ѡ�');
