package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.ClaDao;
import com.sdpk.model.Cla;
import com.sdpk.model.Contract;
import com.sdpk.utility.DBUtility;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午3:05:53 类说明
 */

public class ClaDaoImpl implements ClaDao {

  private Connection connection;
  boolean daoFlag = false;

  public ClaDaoImpl() {
//    connection = DBUtility.open();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public boolean insert(Cla cla) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("insert into t_class(uuid,org,name,empUuid,classDate,status,remark,claNum) values (?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, cla.getUuid());
      preparedStatement.setString(2, cla.getOrg());
      preparedStatement.setString(3, cla.getName());
      preparedStatement.setString(4, cla.getEmpUuid());
      preparedStatement.setString(5, cla.getClassDate());
      preparedStatement.setString(6, cla.getStatus());
      preparedStatement.setString(7, cla.getRemark());
      preparedStatement.setString(8, cla.getClaNum());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ContractDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行ClaDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
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
          .prepareStatement("DELETE FROM t_class WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行ClaDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ClaDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, PSdelete, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method delete

  @Override
  public boolean update(Cla cla) {
    // TODO Auto-generated method stub
    PreparedStatement preparedStatement = null; //关闭数据库连接insert和update和delete用到
    try {
      connection = DBUtility.open();//打开数据库连接
       preparedStatement = connection
          .prepareStatement("UPDATE t_class SET name = ?, empUuid = ?,classDate = ?, status = ?, remark = ?, org = ?,claNum = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, cla.getName());
      preparedStatement.setString(2, cla.getEmpUuid());
      preparedStatement.setString(3, cla.getClassDate());
      preparedStatement.setString(4, cla.getStatus());
      preparedStatement.setString(5, cla.getRemark());
      preparedStatement.setString(6, cla.getOrg());
      preparedStatement.setString(7, cla.getClaNum());
      
      preparedStatement.setString(8, cla.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ClaDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ClaDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }finally{
      ResultSet rs = null; 
      DBUtility.close(rs, preparedStatement, connection);   
     }//finally关闭jdbc与数据库连接  
  }// end method update

  @Override
  public Cla getByUuid(String uuid) {
    // TODO Auto-generated method stub
    Cla claResult = new Cla();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          Cla cla = new Cla();
          cla.setUuid(rs.getString("uuid"));
          cla.setName(rs.getString("name"));
          cla.setEmpUuid(rs.getString("empUuid"));             
          cla.setClassDate(rs.getString("classDate"));
          cla.setStatus(rs.getString("status"));
          cla.setRemark(rs.getString("remark"));
          cla.setOrg(rs.getString("org"));
          cla.setClaNum(rs.getString("claNum"));
          
          claResult=cla;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClaDaoImpl的getByUuid查询失败");
        Cla claX = new Cla();
        claX.setUuid("ClaDaoImpl失败返回的uuid");
        return claX;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接  

    return claResult;
  }// end method getByUuid

  @Override
  public ArrayList<Cla> getList() {
    // TODO Auto-generated method stub
    ArrayList<Cla> claList = new ArrayList<Cla>();
    Statement statement = null;//finally关闭数据库连接  
    ResultSet rs = null;//关闭数据库连接get和getlist会用到
    try {
      connection = DBUtility.open();//打开数据库连接
         statement = connection.createStatement();
         rs = statement.executeQuery("select * from t_class");
        while (rs.next()) {
          Cla cla = new Cla();
          cla.setUuid(rs.getString("uuid"));
          cla.setName(rs.getString("name"));
          cla.setEmpUuid(rs.getString("empUuid"));             
          cla.setClassDate(rs.getString("classDate"));
          cla.setStatus(rs.getString("status"));
          cla.setRemark(rs.getString("remark"));
          cla.setOrg(rs.getString("org"));
          cla.setClaNum(rs.getString("claNum"));
          
          claList.add(cla);
        }
        
        return claList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClaDaoImpl的getList查询失败");
        Cla claX = new Cla();
        claX.setUuid("ClaDaoImpl的getList失败返回的uuid");
        ArrayList<Cla> claListX = new ArrayList<Cla>();
        claListX.add(claX);
        return claListX;
    }finally{   
      DBUtility.close(rs, statement, connection);   
     }//finally关闭jdbc与数据库连接

    
  }//emd method getList

}// end class
