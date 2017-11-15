package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.Class_ContractDao;
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

}//end class
