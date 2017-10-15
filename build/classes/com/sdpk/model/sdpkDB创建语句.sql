
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