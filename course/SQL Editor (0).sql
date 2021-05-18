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
insert into course values('C1','高等数学',4,'0','数学系');
insert into course values('C2','计算机网络',4,'0','计算机系');
insert into course values('C3','C语言课程设计',4,'0','计算机系');
insert into course values('C4','C++课程设计',4,'0','计算机系');
insert into course values('C5','信息管理',4,'0','信管系');
select * from course

create table teacher (
id varchar(10),
name varchar(20),
title varchar(50),
password varchar(50)
)charset=utf8;
truncate table teacher;
insert into teacher values('0001','123','222','123');
insert into teacher values('16001','王一鸣','信管系班主任','123');
insert into teacher values('16002','刘明','计算机系班主任','123');
insert into teacher values('16003','张倩','辅导员','123');
insert into teacher values('16004','孙德','院长','123');
insert into teacher values('16005','赵合','数学系班主任','123');
insert into teacher values('16006','钱茜','副院长','123');
insert into teacher values('16007','王魁','副院长','123');
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

insert into student values('16220001','王伟','123','浙江临海','计算机系','男',6,'8862941','11644@qq.com') ;
insert into student values('16220002','周丹','123','浙江椒江','信管系','女',8,'8865912','45242@qq.com') ;
insert into student values('16220003','吴晗','123','浙江金华','计算机系','女',5,'8836158','2456488@qq.com') ;
insert into student values('16220004','郑毅平','123','浙江宁波','信管系','男',7,' ','57245@qq.com') ;
insert into student values('16220005','刘琦','123','浙江诸暨','数学系','女',8,' ','9752557@qq.com') ;
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