package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sdpk.dao.StudentDao;
import com.sdpk.model.Student;
import com.sdpk.utility.DBUtility;

public class StudentDaoImpl implements StudentDao{

  
  private Connection connection;

  public StudentDaoImpl() {
      connection = DBUtility.getConnection();
      System.out.println("connection对象在StudentDaoImpl连接!");
  }
  
  
  @Override
  public void insert(Student stu) {
    
            try {
              
              PreparedStatement preparedStatement = connection
                      .prepareStatement("insert into t_student(uuid,name,studentID) values (?,?, ?)");
              // Parameters start with 1
              preparedStatement.setString(1, stu.getUuid());
              preparedStatement.setString(2, stu.getName());
              preparedStatement.setString(3, stu.getStudentID());         
              preparedStatement.executeUpdate();
        
              System.out.println("^^在执行StudentDao中的insert添加");
          } catch (SQLException e) {
              e.printStackTrace();
          }
  }//end method insert

 

}
