package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.UserPKDao;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.UserPK;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 下午12:42:55
 * 类说明
 */

public class UserPKDaoImpl implements UserPKDao{
  
  private Connection connection;
  boolean daoFlag = false;

  public UserPKDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public boolean insert(UserPK userPK) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_userPK(uuid,uLogUser,uPassWord,uName) values (?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, userPK.getUuid());
      preparedStatement.setString(2, userPK.getuLogUser());
      preparedStatement.setString(3, userPK.getuPassWord());
      preparedStatement.setString(4, userPK.getuName());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行t_userPK DaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行t_userPK 中insert,出现sql语法执行错误，请联系管理员!");
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
          .prepareStatement("DELETE FROM t_userPK WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行t_userPK中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行t_userPK中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean update(UserPK userPK) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_userPK SET uLogUser = ?, uPassWord = ?,uName = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, userPK.getuLogUser());
      preparedStatement.setString(2, userPK.getuPassWord());
      preparedStatement.setString(3, userPK.getuName());
      preparedStatement.setString(4, userPK.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行t_userPK中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行t_userPK中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method update

  @Override
  public UserPK getByUuid(String uuid) {
    // TODO Auto-generated method stub
    UserPK userPKResult = new UserPK();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_userPK WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          UserPK userPK = new UserPK();
          userPK.setUuid(rs.getString("uuid"));
          userPK.setuLogUser(rs.getString("uLogUser"));
          userPK.setuPassWord(rs.getString("uPassWord"));             
          userPK.setuName(rs.getString("uName"));
          
          userPKResult=userPK;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("t_userPK的getByUuid查询失败");
        UserPK aX = new UserPK();
        aX.setUuid("t_userPK失败返回的uuid");
        return aX;
    }

    return userPKResult;
  }// end method getByUuid

  @Override
  public ArrayList<UserPK> getList() {
    // TODO Auto-generated method stub
    ArrayList<UserPK> userPKList = new ArrayList<UserPK>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_userPK");
        while (rs.next()) {
          UserPK userPK = new UserPK();
          userPK.setUuid(rs.getString("uuid"));
          userPK.setuLogUser(rs.getString("uLogUser"));
          userPK.setuPassWord(rs.getString("uPassWord"));             
          userPK.setuName(rs.getString("uName"));
          
          userPKList.add(userPK);
        }
        
        return userPKList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClaDaoImpl的getList查询失败");
        UserPK aX = new UserPK();
        aX.setUuid("UserPKDao的getList失败返回的uuid");
        ArrayList<UserPK> aXL = new ArrayList<UserPK>();
        aXL.add(aX);
        return aXL;
    }

    
  }//emd method getList

  @Override
  public UserPK getByuLogUser(String uLogUser) {
    // TODO Auto-generated method stub
    UserPK userPKResult = new UserPK();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_userPK WHERE uLogUser ="+"'"+uLogUser+"'");
        while (rs.next()) {
          UserPK userPK = new UserPK();
          userPK.setUuid(rs.getString("uuid"));
          userPK.setuLogUser(rs.getString("uLogUser"));
          userPK.setuPassWord(rs.getString("uPassWord"));             
          userPK.setuName(rs.getString("uName"));
          
          userPKResult=userPK;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("t_userPK的getByUuid查询失败");
        UserPK aX = new UserPK();
        aX.setUuid("t_userPK失败返回的uuid");
        return aX;
    }

    return userPKResult;
  }// end method getByUuid
  
  
  

}//end class
