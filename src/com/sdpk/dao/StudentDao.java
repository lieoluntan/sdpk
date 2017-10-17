package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Student;

/**
 * @author xiepingping
 * 
 */
public interface StudentDao {

  public boolean insert(Student stu);

  public boolean delete(String uuid);

  public boolean update(Student student);

  public ArrayList<Student> getList();

  public Student getByUuid(String uuid);

}
