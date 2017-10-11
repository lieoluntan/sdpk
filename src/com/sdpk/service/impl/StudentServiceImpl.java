package com.sdpk.service.impl;

import java.util.UUID;

import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Student;
import com.sdpk.service.StudentService;

public class StudentServiceImpl implements StudentService{

    
  private StudentDaoImpl studentDaoImpl= new StudentDaoImpl();
  
  @Override
  public String insert(Student stu) {
//    
   
    stu.setUuid(null);

    stu.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在StudentServiceImpl收到数据 ："+stu.toString()+"收到结束!");
    studentDaoImpl.insert(stu);
    return stu.getUuid();

  }



}
