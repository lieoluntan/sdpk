--------------------------------------
2、学生表t_student

CREATE TABLE t_student (
  uuid varchar(50) NOT NULL,
  name varchar(30) NOT NULL,
  studentID varchar(30) DEFAULT NULL,
  school varchar(30) DEFAULT NULL,
  grade varchar(30) DEFAULT NULL,
  phone varchar(30) DEFAULT NULL,
  date varchar(30) DEFAULT NULL,
  parentName varchar(30) DEFAULT NULL,
  parentPhone varchar(30) DEFAULT NULL,
  address varchar(30) DEFAULT NULL,
  remark varchar(30) DEFAULT NULL,
  
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);
--------------------------------------
3、员工表t_employee

CREATE TABLE t_employee (
  uuid varchar(50) NOT NULL,
  name varchar(30) NOT NULL,
  empNum varchar(30) DEFAULT NULL,
  phone varchar(30) DEFAULT NULL,
  depart varchar(30) DEFAULT NULL,
  job varchar(30) DEFAULT NULL,
  permissionTempl varchar(30) DEFAULT NULL,
  course varchar(30) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL,
  
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);

--------------------------------------
4、课程表t_course

CREATE TABLE t_course (
  uuid varchar(50) NOT NULL,
  name varchar(30) NOT NULL,
  category varchar(30) DEFAULT NULL,
  describeA varchar(255) DEFAULT NULL,
  
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);

--------------------------------------
5、合同表t_contract

CREATE TABLE t_contract (
  uuid varchar(50) NOT NULL,
  oddNum varchar(30) NOT NULL,
  stuUuid varchar(50) DEFAULT NULL,
  campus varchar(30) DEFAULT NULL,
  account varchar(30) DEFAULT NULL,
  operator varchar(30) DEFAULT NULL,
  fee varchar(30) DEFAULT NULL,
  feeType varchar(30) DEFAULT NULL,
  feeMode varchar(30) DEFAULT NULL,
  itemName varchar(30) DEFAULT NULL,
  amount varchar(30) DEFAULT NULL,
  
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);

--------------------------------------
6、排课表t_paike_all

CREATE TABLE t_paike_all (
  uuid varchar(50) NOT NULL,
  claUuid varchar(50) NOT NULL,
  courseUuid varchar(50) DEFAULT NULL,
  empUuid varchar(50) DEFAULT NULL,
  classroomUuid varchar(50) DEFAULT NULL,
  keDateTime varchar(30) DEFAULT NULL,
  keStartTime varchar(30) DEFAULT NULL,
  keLongTime varchar(30) DEFAULT NULL,
  status varchar(30) DEFAULT NULL,
  
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);

--------------------------------------
7、班级表t_class

CREATE TABLE t_class (
  uuid varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  empUuid varchar(50) DEFAULT NULL,
  classDate varchar(50) DEFAULT NULL,
  status varchar(50) DEFAULT NULL,
  remark varchar(30) DEFAULT NULL,
  
  org varchar(50) DEFAULT NULL,
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);

--------------------------------------
8、教室表t_classroom

CREATE TABLE t_classroom (
  uuid varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  campus varchar(50) DEFAULT NULL,
  remark varchar(250) DEFAULT NULL,
  
  org varchar(50) DEFAULT NULL,
  createDate datetime DEFAULT NULL,
  modifyDate datetime DEFAULT NULL,
  createPeople varchar(50) DEFAULT NULL,
  modifyPeople varchar(50) DEFAULT NULL,
  
  PRIMARY KEY (uuid)
);


--------------------------------------
