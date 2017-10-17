package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Student;

/**
 * @author xiepingping
 * 
 */
public interface StudentService {

  String insert(Student stu);

  String delete(String uuid);

  String update(Student student);

  ArrayList<Student> getList();

  Student getByUuid(String uuid);

}
