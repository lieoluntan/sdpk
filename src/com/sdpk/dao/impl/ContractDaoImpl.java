package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sdpk.dao.ContractDao;
import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午7:47:21
 * 类说明
 */

public class ContractDaoImpl implements ContractDao{

  private Connection connection;

  public ContractDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在CourseDaoImpl连接!");
  }

  @Override
  public void insert(Contract contract) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_contract(uuid,oddNum,stuUuid,campus,account,operator,fee,feeType,feeMode,itemName,amount) values (?,?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, contract.getUuid());
      preparedStatement.setString(2, contract.getOddNum());
      preparedStatement.setString(3, contract.getStuUuid());
      preparedStatement.setString(4, contract.getCampus());
      preparedStatement.setString(5, contract.getAccount());
      preparedStatement.setString(6, contract.getOperator());
      preparedStatement.setString(7, contract.getFee());
      preparedStatement.setString(8, contract.getFeeType());
      preparedStatement.setString(9, contract.getFeeMode());
      preparedStatement.setString(10, contract.getItemName());
      preparedStatement.setString(11, contract.getAmount());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ContractDaoImpl中的添加insert");
    } catch (SQLException e) {
      e.printStackTrace();
    }//end try catch
  }//edn method insert 

}//end class ContractDaoImpl
