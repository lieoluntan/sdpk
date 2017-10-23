package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.ContractDao;
import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午7:47:21
 * 类说明
 */

public class ContractDaoImpl implements ContractDao{

  private Connection connection;
  boolean daoFlag = false;

  public ContractDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在CourseDaoImpl连接!");
  }

  @Override
  public boolean insert(Contract contract) {
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
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行ContractDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }//end try catch
  }//edn method insert 

  @Override
  public ArrayList<Contract> getList() {
    // TODO Auto-generated method stub
    ArrayList<Contract> contractList = new ArrayList<Contract>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_contract");
        while (rs.next()) {
          Contract contract = new Contract();
          contract.setUuid(rs.getString("uuid"));
          contract.setOddNum(rs.getString("oddNum"));
          contract.setStuUuid(rs.getString("stuUuid"));             
          contract.setCampus(rs.getString("campus"));
          contract.setAccount(rs.getString("account"));
          contract.setOperator(rs.getString("operator"));
          contract.setFee(rs.getString("fee"));
          contract.setFeeType(rs.getString("feeType"));
          contract.setFeeMode(rs.getString("feeMode"));
          contract.setItemName(rs.getString("itemName"));
          contract.setAmount(rs.getString("amount"));
          
          contractList.add(contract);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ContractDaoImpl的getList查询失败");
        Contract contractX = new Contract();
        contractX.setUuid("ContractDaoImpl的getList失败返回的uuid");
        ArrayList<Contract> contractListX = new ArrayList<Contract>();
        contractListX.add(contractX);
        return contractListX;
    }

    return contractList;
  }//emd method getList

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_contract WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行ContractDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ContractDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean update(Contract contract) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_contract SET oddNum = ?, stuUuid = ?,campus = ?, account = ?, operator = ?, fee = ?, feeType = ?, feeMode = ?, itemName = ?, amount = ? WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, contract.getOddNum());
      preparedStatement.setString(2, contract.getStuUuid());
      preparedStatement.setString(3, contract.getCampus());
      preparedStatement.setString(4, contract.getAccount());
      preparedStatement.setString(5, contract.getOperator());
      preparedStatement.setString(6, contract.getFee());
      preparedStatement.setString(7, contract.getFeeType());
      preparedStatement.setString(8, contract.getFeeMode());
      preparedStatement.setString(9, contract.getItemName());
      preparedStatement.setString(10, contract.getAmount());
      preparedStatement.setString(11, contract.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ContractDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ContractDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method update

  @Override
  public Contract getByUuid(String uuid) {
    // TODO Auto-generated method stub
    Contract contractResult = new Contract();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_contract WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          Contract contract = new Contract();
          contract.setUuid(rs.getString("uuid"));
          contract.setOddNum(rs.getString("oddNum"));
          contract.setStuUuid(rs.getString("stuUuid"));             
          contract.setCampus(rs.getString("campus"));
          contract.setAccount(rs.getString("account"));
          contract.setOperator(rs.getString("operator"));
          contract.setFee(rs.getString("fee"));
          contract.setFeeType(rs.getString("feeType"));
          contract.setFeeMode(rs.getString("feeMode"));
          contract.setItemName(rs.getString("itemName"));
          contract.setAmount(rs.getString("amount"));
          
          contractResult=contract;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ContractDaoImpl的getByUuid查询失败");
        Contract contractX = new Contract();
        contractX.setUuid("ContractDaoImpl失败返回的uuid");
        return contractX;
    }

    return contractResult;
  }// end method getByUuid

}//end class ContractDaoImpl
