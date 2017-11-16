package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.Class_ContractDao;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.Class_Contract;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-15 下午3:33:06
 * 类说明
 */

public class Class_ContractDaoImpl implements Class_ContractDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public Class_ContractDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public ArrayList<Class_Contract> getListBycla(String classUuid) {
    // TODO Auto-generated method stub
    ArrayList<Class_Contract> reList = new ArrayList<Class_Contract>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_class_contract WHERE classUuid ="+"'"+classUuid+"'");
        while (rs.next()) {
          Class_Contract class_Contract = new Class_Contract();
          class_Contract.setUuid(rs.getString("uuid"));
          class_Contract.setClassUuid(rs.getString("classUuid"));
          class_Contract.setContrUuid(rs.getString("contrUuid"));             
          
          reList.add(class_Contract);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Class_ContractDaoImpl的getListBycla查询失败");
        Class_Contract class_ContractX = new Class_Contract();
        class_ContractX.setUuid("Class_ContractDaoImpl的getList失败返回的uuid");
        ArrayList<Class_Contract> class_ContractXList = new ArrayList<Class_Contract>();
        class_ContractXList.add(class_ContractX);
        return class_ContractXList;
    }

  }//emd method getListBycla

  @Override
  public boolean insert(Class_Contract class_Contract) {
    // TODO Auto-generated method stub
    try {
      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_class_contract(uuid,classUuid,className,contrUuid,contrName) values (?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, class_Contract.getUuid());
      preparedStatement.setString(2, class_Contract.getClassUuid());
      preparedStatement.setString(3, class_Contract.getClassName());
      preparedStatement.setString(4, class_Contract.getContrUuid());
      preparedStatement.setString(5, class_Contract.getContrName());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行class_ContractDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行class_ContractDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
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
          .prepareStatement("DELETE FROM t_class_contract WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行class_contractDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行class_contractDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
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
          .prepareStatement("DELETE FROM t_class_contract WHERE classUuid = ? ");
      PSdelete.setString(1, classUuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行class_contractDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行class_contractDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public ArrayList<Class_Contract> getListByContr(String contrUuid) {
    // TODO Auto-generated method stub
    ArrayList<Class_Contract> reList = new ArrayList<Class_Contract>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_class_contract WHERE contrUuid ="+"'"+contrUuid+"'");
        while (rs.next()) {
          Class_Contract class_Contract = new Class_Contract();
          class_Contract.setUuid(rs.getString("uuid"));
          class_Contract.setClassUuid(rs.getString("classUuid"));
          class_Contract.setContrUuid(rs.getString("contrUuid"));             
          
          reList.add(class_Contract);
        }
        
        return reList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Class_ContractDaoImpl的getListBycla查询失败");
        Class_Contract class_ContractX = new Class_Contract();
        class_ContractX.setUuid("Class_ContractDaoImpl的getList失败返回的uuid");
        ArrayList<Class_Contract> class_ContractXList = new ArrayList<Class_Contract>();
        class_ContractXList.add(class_ContractX);
        return class_ContractXList;
    }

  }//emd method getListBycla

  @Override
  public Class_Contract getOneBycontr(String contrUuid) {
    // TODO Auto-generated method stub
    Class_Contract result = new Class_Contract();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_class_contract WHERE contrUuid ="+"'"+contrUuid+"'");
        while (rs.next()) {
          Class_Contract class_Contract = new Class_Contract();
          class_Contract.setUuid(rs.getString("uuid"));
          class_Contract.setClassUuid(rs.getString("classUuid"));
          class_Contract.setContrUuid(rs.getString("contrUuid"));             
          
          result = class_Contract;
        }
        
        return result;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Class_ContractDaoImpl的getListBycla查询失败");
        Class_Contract errX = new Class_Contract();
        errX.setUuid("And_ClassEmpDaoImpl的getList失败返回的uuid");
        return errX;
    }

  }//emd method getByUuid

}//end class
