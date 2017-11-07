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
          .prepareStatement("insert into t_contract(uuid,cNum,stuUuid,cDate,org,totalCount,totalPrice,onePriceA,countA,delPriceA,countGiveA,sumCountA,sumPriceA,onePriceB,countB,delPriceB,countGiveB,sumCountB,sumPriceB) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, contract.getUuid());
      preparedStatement.setString(2, contract.getcNum());
      preparedStatement.setString(3, contract.getStuUuid());
      preparedStatement.setString(4, contract.getcDate());
      preparedStatement.setString(5, contract.getOrg());
      preparedStatement.setString(6, contract.getTotalCount());
      preparedStatement.setString(7, contract.getTotalPrice());
      preparedStatement.setString(8, contract.getOnePriceA());
      preparedStatement.setString(9, contract.getCountA());
      preparedStatement.setString(10, contract.getDelPriceA());
      preparedStatement.setString(11, contract.getCountGiveA());
      preparedStatement.setString(12, contract.getSumCountA());
      preparedStatement.setString(13, contract.getSumPriceA());
      
      preparedStatement.setString(14, contract.getOnePriceB());
      preparedStatement.setString(15, contract.getCountB());
      preparedStatement.setString(16, contract.getDelPriceB());
      preparedStatement.setString(17, contract.getCountGiveB());
      preparedStatement.setString(18, contract.getSumCountB());
      preparedStatement.setString(19, contract.getSumPriceB());
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
  }//end method insert 

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
          contract.setcNum(rs.getString("cNum"));
          contract.setStuUuid(rs.getString("stuUuid"));             
          contract.setcDate(rs.getString("cDate"));
          contract.setOrg(rs.getString("org"));
          contract.setTotalCount(rs.getString("totalCount"));
          contract.setTotalPrice(rs.getString("totalPrice"));
          
          contract.setOnePriceA(rs.getString("onePriceA"));
          contract.setCountA(rs.getString("countA"));
          contract.setDelPriceA(rs.getString("delPriceA"));
          contract.setCountGiveA(rs.getString("countGiveA"));
          contract.setSumCountA(rs.getString("sumCountA"));
          contract.setSumPriceA(rs.getString("sumPriceA"));
          
          contract.setOnePriceB(rs.getString("onePriceB"));
          contract.setCountB(rs.getString("countB"));
          contract.setDelPriceB(rs.getString("delPriceB"));
          contract.setCountGiveB(rs.getString("countGiveB"));
          contract.setSumCountB(rs.getString("sumCountB"));
          contract.setSumPriceB(rs.getString("sumPriceB"));
          
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
          .prepareStatement("UPDATE t_contract SET cNum = ?, stuUuid = ?,cDate = ?, org = ?, totalCount = ?, totalPrice = ?, onePriceA = ?, countA = ?, delPriceA = ?, countGiveA = ?, sumCountA = ?,sumPriceA = ?, onePriceB = ?, countB = ?, delPriceB = ?, countGiveB = ?, sumCountB = ?,sumPriceB = ? WHERE uuid = ? ");
      // Parameters start with 1
      
      preparedStatement.setString(1, contract.getcNum());
      preparedStatement.setString(2, contract.getStuUuid());
      preparedStatement.setString(3, contract.getcDate());
      preparedStatement.setString(4, contract.getOrg());
      preparedStatement.setString(5, contract.getTotalCount());
      preparedStatement.setString(6, contract.getTotalPrice());
      preparedStatement.setString(7, contract.getOnePriceA());
      preparedStatement.setString(8, contract.getCountA());
      preparedStatement.setString(9, contract.getDelPriceA());
      preparedStatement.setString(10, contract.getCountGiveA());
      preparedStatement.setString(11, contract.getSumCountA());
      preparedStatement.setString(12, contract.getSumPriceA());
      
      preparedStatement.setString(13, contract.getOnePriceB());
      preparedStatement.setString(14, contract.getCountB());
      preparedStatement.setString(15, contract.getDelPriceB());
      preparedStatement.setString(16, contract.getCountGiveB());
      preparedStatement.setString(17, contract.getSumCountB());
      preparedStatement.setString(18, contract.getSumPriceB());
      
      preparedStatement.setString(19, contract.getUuid());
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
          contract.setcNum(rs.getString("cNum"));
          contract.setStuUuid(rs.getString("stuUuid"));             
          contract.setcDate(rs.getString("cDate"));
          contract.setOrg(rs.getString("org"));
          contract.setTotalCount(rs.getString("totalCount"));
          contract.setTotalPrice(rs.getString("totalPrice"));
          
          contract.setOnePriceA(rs.getString("onePriceA"));
          contract.setCountA(rs.getString("countA"));
          contract.setDelPriceA(rs.getString("delPriceA"));
          contract.setCountGiveA(rs.getString("countGiveA"));
          contract.setSumCountA(rs.getString("sumCountA"));
          contract.setSumPriceA(rs.getString("sumPriceA"));
          
          contract.setOnePriceB(rs.getString("onePriceB"));
          contract.setCountB(rs.getString("countB"));
          contract.setDelPriceB(rs.getString("delPriceB"));
          contract.setCountGiveB(rs.getString("countGiveB"));
          contract.setSumCountB(rs.getString("sumCountB"));
          contract.setSumPriceB(rs.getString("sumPriceB"));
          
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
