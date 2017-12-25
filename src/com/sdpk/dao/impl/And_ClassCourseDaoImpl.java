package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.And_ClassCourseDao;
import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.And_ClassStu;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午3:26:53
 * 类说明
 */

public class And_ClassCourseDaoImpl implements And_ClassCourseDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public And_ClassCourseDaoImpl() {
//    connection = DBUtility.open();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public ArrayList<And_ClassCourse> getListBycla(String classUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassCourse> reList = new ArrayList<And_ClassCourse>();
    Statement statement = null;//finally关闭jdbc与数据库连接  
    ResultSet rs = null;//finally关闭jdbc与数据库连接  
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class_course WHERE classUuid ="+"'"+classUuid+"'");
        while (rs.next()) {
          And_ClassCourse and_ClassCourse = new And_ClassCourse();
          and_ClassCourse.setUuid(rs.getString("uuid"));
          and_ClassCourse.setClassUuid(rs.getString("classUuid"));
          and_ClassCourse.setCourseUuid(rs.getString("courseUuid"));             
          
          reList.add(and_ClassCourse);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassCourseDaoImpl的getListBycla查询失败");
        And_ClassCourse errOne = new And_ClassCourse();
        errOne.setUuid("And_ClassCourseDaoImpl的getListBycla失败返回的uuid");
        ArrayList<And_ClassCourse> errList = new ArrayList<And_ClassCourse>();
        errList.add(errOne);
        return errList;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

  }//emd method getListBycla

  @Override
  public boolean insert(And_ClassCourse and_ClassCourse) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("insert into t_class_course(uuid,classUuid,className,courseUuid,courseName) values (?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, and_ClassCourse.getUuid());
      preparedStatement.setString(2, and_ClassCourse.getClassUuid());
      preparedStatement.setString(3, and_ClassCourse.getClassName());
      preparedStatement.setString(4, and_ClassCourse.getCourseUuid());
      preparedStatement.setString(5, and_ClassCourse.getCourseName());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行And_ClassCourseDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行And_ClassCourseDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// edn method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_class_course WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行And_ClassCourseDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行And_ClassCourseDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method delete

  @Override
  public boolean deleteBycla(String classUuid) {
    // TODO Auto-generated method stub
    Statement statement = null;//finally关闭jdbc与数据库连接  
    PreparedStatement PSdelete = null; //finally关闭jdbc与数据库连接
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_class_course WHERE classUuid = ? ");
      PSdelete.setString(1, classUuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行And_ClassCourseDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行And_ClassCourseDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接 
  }// end method delete

  @Override
  public ArrayList<And_ClassCourse> getListByCour(String courseUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassCourse> reList = new ArrayList<And_ClassCourse>();
    Statement statement = null;//finally关闭jdbc与数据库连接  
    ResultSet rs = null; //finally关闭jdbc与数据库连接
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class_course WHERE courseUuid ="+"'"+courseUuid+"'");
        while (rs.next()) {
          And_ClassCourse and_ClassCourse = new And_ClassCourse();
          and_ClassCourse.setUuid(rs.getString("uuid"));
          and_ClassCourse.setClassUuid(rs.getString("classUuid"));
          and_ClassCourse.setCourseUuid(rs.getString("courseUuid"));             
          
          reList.add(and_ClassCourse);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassCourseDaoImpl的getListBycla查询失败");
        And_ClassCourse errOne = new And_ClassCourse();
        errOne.setUuid("And_ClassCourseDaoImpl的getListBycla失败返回的uuid");
        ArrayList<And_ClassCourse> errList = new ArrayList<And_ClassCourse>();
        errList.add(errOne);
        return errList;
    }finally{
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接 

  }//emd method getListBycla

}//end class
