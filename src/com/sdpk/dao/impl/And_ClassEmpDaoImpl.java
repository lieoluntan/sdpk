package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.And_ClassEmpDao;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午7:09:39
 * 类说明
 */

public class And_ClassEmpDaoImpl implements And_ClassEmpDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public And_ClassEmpDaoImpl() {
//    connection = DBUtility.open();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public boolean insert(And_ClassEmp and_ClassEmp) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("insert into t_class_emp(uuid,classUuid,className,empUuid,empName) values (?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, and_ClassEmp.getUuid());
      preparedStatement.setString(2, and_ClassEmp.getClassUuid());
      preparedStatement.setString(3, and_ClassEmp.getClassName());
      preparedStatement.setString(4, and_ClassEmp.getEmpUuid());
      preparedStatement.setString(5, and_ClassEmp.getEmpName());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行And_ClassEmpDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行And_ClassEmpDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// edn method insert
  
  @Override
  public ArrayList<And_ClassEmp> getListBycla(String classUuid) {
    // TODO 
    ArrayList<And_ClassEmp> reList = new ArrayList<And_ClassEmp>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class_emp WHERE classUuid ="+"'"+classUuid+"'");
        while (rs.next()) {
          And_ClassEmp and_ClassEmp = new And_ClassEmp();
          and_ClassEmp.setUuid(rs.getString("uuid"));
          and_ClassEmp.setClassUuid(rs.getString("classUuid"));
          and_ClassEmp.setEmpUuid(rs.getString("empUuid"));             
          
          reList.add(and_ClassEmp);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassEmpDaoImpl的getListBycla查询失败");
        And_ClassEmp and_ClassEmpX = new And_ClassEmp();
        and_ClassEmpX.setUuid("And_ClassEmpDaoImpl的getList失败返回的uuid");
        ArrayList<And_ClassEmp> and_ClassEmpXList = new ArrayList<And_ClassEmp>();
        and_ClassEmpXList.add(and_ClassEmpX);
        return and_ClassEmpXList;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

  }//emd method getListBycla

  @Override
  public And_ClassEmp getBycla(String classUuid) {
    // TODO Auto-generated method stub
    And_ClassEmp result = new And_ClassEmp();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class_emp WHERE classUuid ="+"'"+classUuid+"'");
        while (rs.next()) {
          And_ClassEmp and_ClassEmp = new And_ClassEmp();
          and_ClassEmp.setUuid(rs.getString("uuid"));
          and_ClassEmp.setClassUuid(rs.getString("classUuid"));
          and_ClassEmp.setEmpUuid(rs.getString("empUuid"));             
          
          result = and_ClassEmp;
        }
        
        return result;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassEmpDaoImpl的getListBycla查询失败");
        And_ClassEmp and_ClassEmpX = new And_ClassEmp();
        and_ClassEmpX.setUuid("And_ClassEmpDaoImpl的getList失败返回的uuid");
        return and_ClassEmpX;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接

  }//emd method getByUuid

  @Override
  public boolean deleteBycla(String classUuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_class_emp WHERE classUuid = ? ");
      PSdelete.setString(1, classUuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行And_ClassEmpDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行And_ClassEmpDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method delete

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    PreparedStatement PSdelete = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
      // Parameters start with 1
       PSdelete = connection
          .prepareStatement("DELETE FROM t_class_emp WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行And_ClassEmpDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行And_ClassEmpDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接
  }// end method delete

  @Override
  public ArrayList<And_ClassEmp> getListByEmp(String empUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassEmp> reList = new ArrayList<And_ClassEmp>();
    Statement statement = null;//finally关闭jdbc与数据库连接  
    ResultSet rs = null; //finally关闭jdbc与数据库连接
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class_emp WHERE empUuid ="+"'"+empUuid+"'");
        while (rs.next()) {
          And_ClassEmp and_ClassEmp = new And_ClassEmp();
          and_ClassEmp.setUuid(rs.getString("uuid"));
          and_ClassEmp.setClassUuid(rs.getString("classUuid"));
          and_ClassEmp.setEmpUuid(rs.getString("empUuid"));             
          
          reList.add(and_ClassEmp);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassEmpDaoImpl的getListBycla查询失败");
        And_ClassEmp and_ClassEmpX = new And_ClassEmp();
        and_ClassEmpX.setUuid("And_ClassEmpDaoImpl的getList失败返回的uuid");
        ArrayList<And_ClassEmp> and_ClassEmpXList = new ArrayList<And_ClassEmp>();
        and_ClassEmpXList.add(and_ClassEmpX);
        return and_ClassEmpXList;
    }finally{
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接 

  }//emd method getListByEmp

}//end class
