create database ClassDB;

create table classes(
id varchar(50),
tea_id varchar(10),
cour_id varchar(10),
room_id varchar(50),
cour_time char(10)
)charset=utf8;
truncate table classes;
insert into classes values('1','16001','C1','01','Mon_2');
insert into classes values('2','16002','C2','02','Tues_1');
insert into classes values('3','16003','C4','03','Thurs_3');
insert into classes values('4','16004','C3','04','Fri_3');
insert into classes values('5','16005','C1','05','Wed_1');
insert into classes values('6','16006','C5','06','Tues_3');
insert into classes values('7','16007','C2','02','Wed_2');
select * from classes;

create table course(
id varchar(10),
name varchar(20),
mark int(4),
prepare varchar(10),
dep varchar(10)
)charset=utf8;
truncate table course;
insert into course values('C1','�ߵ���ѧ',4,'0','��ѧϵ');
insert into course values('C2','���������',4,'0','�����ϵ');
insert into course values('C3','C���Կγ����',4,'0','�����ϵ');
insert into course values('C4','C++�γ����',4,'0','�����ϵ');
insert into course values('C5','��Ϣ����',4,'0','�Ź�ϵ');
select * from course

create table teacher (
id varchar(10),
name varchar(20),
title varchar(50),
password varchar(50)
)charset=utf8;
truncate table teacher;
insert into teacher values('0001','123','222','123');
insert into teacher values('16001','��һ��','�Ź�ϵ������','123');
insert into teacher values('16002','����','�����ϵ������','123');
insert into teacher values('16003','��ٻ','����Ա','123');
insert into teacher values('16004','���','Ժ��','123');
insert into teacher values('16005','�Ժ�','��ѧϵ������','123');
insert into teacher values('16006','Ǯ��','��Ժ��','123');
insert into teacher values('16007','����','��Ժ��','123');
select * from teacher

create table student(
id varchar(50),
name varchar(10),
password varchar(50),
jiguan varchar(10),
department varchar(10),
sex varchar(10),
mark int(4),
tel varchar(50),
e_mail varchar(50)
)charset=utf8;

insert into student values('16220001','��ΰ','123','�㽭�ٺ�','�����ϵ','��',6,'8862941','11644@qq.com') ;
insert into student values('16220002','�ܵ�','123','�㽭����','�Ź�ϵ','Ů',8,'8865912','45242@qq.com') ;
insert into student values('16220003','����','123','�㽭��','�����ϵ','Ů',5,'8836158','2456488@qq.com') ;
insert into student values('16220004','֣��ƽ','123','�㽭����','�Ź�ϵ','��',7,' ','57245@qq.com') ;
insert into student values('16220005','����','123','�㽭����','��ѧϵ','Ů',8,' ','9752557@qq.com') ;
select * from student

create table admin(
id varchar(10),
name varchar(10),
password varchar(10)
)charset=utf8;
insert into admin values('01','01','123');
insert into admin values('02','02','123');
select * from admin

create table enrol(
stu_id varchar(50),
class_id varchar(50),
accept bit default 0,
score varchar(50)
)charset=utf8;
select * from enrol