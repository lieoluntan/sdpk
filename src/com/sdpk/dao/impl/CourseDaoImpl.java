package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sdpk.dao.CourseDao;
import com.sdpk.model.Cla;
import com.sdpk.model.Course;
import com.sdpk.model.User;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午4:07:51
 * 类说明
 */

public class CourseDaoImpl implements CourseDao {
  
  private Connection connection;
  boolean daoFlag = false;

  public CourseDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在CourseDaoImpl连接!");
  }

  @Override
  public boolean insert(Course course) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_course(uuid,name,category,describeA,org) values (?,?, ?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, course.getUuid());
      preparedStatement.setString(2, course.getName());
      preparedStatement.setString(3, course.getCategory());
      preparedStatement.setString(4, course.getDescribe());
      preparedStatement.setString(5, course.getOrg());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行CourseDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行CourseDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }//end try catch
  }//edn method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_course WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行CourseDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行CourseDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }//end try catch
  }//end method delete

  @Override
  public boolean update(Course course) {
    // TODO Auto-generated method stub
    try {

      
      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_course SET name = ?, category = ?,describeA = ? WHERE uuid = ? ");
   // Parameters start with 1
      preparedStatement.setString(1, course.getName());
      preparedStatement.setString(2, course.getCategory());
      preparedStatement.setString(3, course.getDescribe());
      preparedStatement.setString(4, course.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行CourseDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行CourseDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }//end try catch
  }//end method update

  @Override
  public ArrayList<Course> getListCourse() {
    // TODO Auto-generated method stub
    ArrayList<Course> courList = new ArrayList<Course>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_course");
        while (rs.next()) {
          Course course = new Course();
          course.setUuid(rs.getString("uuid"));
          course.setName(rs.getString("name"));
          course.setCategory(rs.getString("category"));             
          course.setDescribe(rs.getString("describeA"));
          courList.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("CourseDaoImpl的getList查询失败");
    }

    return courList;
  }//end method getListCourse

  @Override
  public Course getByUuid(String uuid) {
    // TODO Auto-generated method stub
    Course courseResult = new Course();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_course WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          Course course = new Course();
          course.setUuid(rs.getString("uuid"));
          course.setName(rs.getString("name"));
          course.setCategory(rs.getString("category"));             
          course.setDescribe(rs.getString("describeA"));
          
          courseResult=course;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("CourseDaoImpl的getByUuid查询失败");
        Course courseX = new Course();
        courseX.setUuid("CourseDaoImpl失败返回的uuid");
        return courseX;
    }
    
    return courseResult;

  }// end method getByUuid

}//end class CourseDaoImpl
