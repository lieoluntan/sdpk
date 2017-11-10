package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.And_ClassStuDao;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.And_ClassStu;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午1:47:37
 * 类说明
 */

public class And_ClassStuDaoImpl implements And_ClassStuDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public And_ClassStuDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public ArrayList<And_ClassStu> getListBycla(String classUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassStu> reList = new ArrayList<And_ClassStu>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_class_stu WHERE classUuid ="+"'"+classUuid+"'");
        while (rs.next()) {
          And_ClassStu and_ClassStu = new And_ClassStu();
          and_ClassStu.setUuid(rs.getString("uuid"));
          and_ClassStu.setClassUuid(rs.getString("classUuid"));
          and_ClassStu.setStuUuid(rs.getString("stuUuid"));             
          
          reList.add(and_ClassStu);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassStuDaoImpl的getListBycla查询失败");
        And_ClassStu and_ClassStuX = new And_ClassStu();
        and_ClassStuX.setUuid("And_ClassStuDaoImpl的getList失败返回的uuid");
        ArrayList<And_ClassStu> and_ClassStuXList = new ArrayList<And_ClassStu>();
        and_ClassStuXList.add(and_ClassStuX);
        return and_ClassStuXList;
    }

  }//emd method getListBycla

  @Override
  public boolean insert(And_ClassStu and_ClassStu) {
    // TODO Auto-generated method stub
    try {
      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_class_stu(uuid,classUuid,className,stuUuid,stuName) values (?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, and_ClassStu.getUuid());
      preparedStatement.setString(2, and_ClassStu.getClassUuid());
      preparedStatement.setString(3, and_ClassStu.getClassName());
      preparedStatement.setString(4, and_ClassStu.getStuUuid());
      preparedStatement.setString(5, and_ClassStu.getStuName());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行And_ClassStuDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行And_ClassStuDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// edn method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_class_stu WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行And_ClassStuDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行And_ClassStuDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean deleteBycla(String classUuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_class_stu WHERE classUuid = ? ");
      PSdelete.setString(1, classUuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行And_ClassStuDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行And_ClassStuDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public ArrayList<And_ClassStu> getListByStu(String stuUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassStu> reList = new ArrayList<And_ClassStu>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_class_stu WHERE stuUuid ="+"'"+stuUuid+"'");
        while (rs.next()) {
          And_ClassStu and_ClassStu = new And_ClassStu();
          and_ClassStu.setUuid(rs.getString("uuid"));
          and_ClassStu.setClassUuid(rs.getString("classUuid"));
          and_ClassStu.setStuUuid(rs.getString("stuUuid"));             
          
          reList.add(and_ClassStu);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("And_ClassStuDaoImpl的getListByStu查询失败");
        And_ClassStu and_ClassStuX = new And_ClassStu();
        and_ClassStuX.setUuid("And_ClassStuDaoImpl的getListByStu失败返回的uuid");
        ArrayList<And_ClassStu> and_ClassStuXList = new ArrayList<And_ClassStu>();
        and_ClassStuXList.add(and_ClassStuX);
        return and_ClassStuXList;
    }

  }//emd method getListBycla

}//end class
