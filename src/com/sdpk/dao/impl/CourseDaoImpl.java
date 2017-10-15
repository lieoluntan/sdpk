package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sdpk.dao.CourseDao;
import com.sdpk.model.Course;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午4:07:51
 * 类说明
 */

public class CourseDaoImpl implements CourseDao {
  
  private Connection connection;

  public CourseDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在CourseDaoImpl连接!");
  }

  @Override
  public void insert(Course course) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_course(uuid,name,category,describeA) values (?,?, ?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, course.getUuid());
      preparedStatement.setString(2, course.getName());
      preparedStatement.setString(3, course.getCategory());
      preparedStatement.setString(4, course.getDescribe());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行CourseDaoImpl中的添加insert");
    } catch (SQLException e) {
      e.printStackTrace();
    }//end try catch
  }//edn method insert

}//end class CourseDaoImpl
