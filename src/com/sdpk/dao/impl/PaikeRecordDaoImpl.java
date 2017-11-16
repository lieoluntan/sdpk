package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.PaikeRecordDao;
import com.sdpk.model.Contract;
import com.sdpk.model.PaikeRecord;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午11:06:25
 * 类说明
 */

public class PaikeRecordDaoImpl implements PaikeRecordDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public PaikeRecordDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在PaikeRecordDaoImpl连接!");
  }

  @Override
  public boolean insert(PaikeRecord paikeRecord) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_paike_all(uuid,claUuid,courseUuid,empUuid,classroomUuid,keDateTime,keStartTime,keLongTime,status,weekSome) values (?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, paikeRecord.getUuid());
      preparedStatement.setString(2, paikeRecord.getClaUuid());
      preparedStatement.setString(3, paikeRecord.getCourseUuid());
      preparedStatement.setString(4, paikeRecord.getEmpUuid());
      preparedStatement.setString(5, paikeRecord.getClassroomUuid());
      preparedStatement.setString(6, paikeRecord.getKeDateTime());
      preparedStatement.setString(7, paikeRecord.getKeStartTime());
      preparedStatement.setString(8, paikeRecord.getKeLongTime());
      preparedStatement.setString(9, paikeRecord.getStatus());
      preparedStatement.setString(10, paikeRecord.getWeekSome());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行PaikeRecordDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行PaikeRecordDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }//end try catch
  }//end method insert 

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_paike_all WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行PaikeRecordDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行PaikeRecordDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean update(PaikeRecord paikeRecord) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_paike_all SET claUuid = ?, courseUuid = ?,empUuid = ?, classroomUuid = ?, keDateTime = ?, keStartTime = ?, keLongTime = ?, status = ? WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, paikeRecord.getClaUuid());
      preparedStatement.setString(2, paikeRecord.getCourseUuid());
      preparedStatement.setString(3, paikeRecord.getEmpUuid());
      preparedStatement.setString(4, paikeRecord.getClassroomUuid());
      preparedStatement.setString(5, paikeRecord.getKeDateTime());
      preparedStatement.setString(6, paikeRecord.getKeStartTime());
      preparedStatement.setString(7, paikeRecord.getKeLongTime());
      preparedStatement.setString(8, paikeRecord.getStatus());
      preparedStatement.setString(9, paikeRecord.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行PaikeRecordDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行PaikeRecordDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method update

  @Override
  public ArrayList<PaikeRecord> getList() {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = new ArrayList<PaikeRecord>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_paike_all");
        while (rs.next()) {
          PaikeRecord paikeRecord = new PaikeRecord();
          paikeRecord.setUuid(rs.getString("uuid"));
          paikeRecord.setClaUuid(rs.getString("claUuid"));
          paikeRecord.setCourseUuid(rs.getString("courseUuid"));             
          paikeRecord.setEmpUuid(rs.getString("empUuid"));
          paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
          paikeRecord.setKeDateTime(rs.getString("keDateTime"));
          paikeRecord.setKeStartTime(rs.getString("keStartTime"));
          paikeRecord.setKeLongTime(rs.getString("keLongTime"));
          paikeRecord.setStatus(rs.getString("status"));
          
          paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecord paikeRecordX = new PaikeRecord();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecord> paikeRecordListX = new ArrayList<PaikeRecord>();
        paikeRecordListX.add(paikeRecordX);
        return paikeRecordListX;
    }

    return paikeRecordList;
  }//emd method getList
  
  @Override
  public ArrayList<PaikeRecord> getListByclaUuid(String claUuid) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = new ArrayList<PaikeRecord>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_paike_all WHERE claUuid ="+"'"+claUuid+"'");
        while (rs.next()) {
          PaikeRecord paikeRecord = new PaikeRecord();
          paikeRecord.setUuid(rs.getString("uuid"));
          paikeRecord.setClaUuid(rs.getString("claUuid"));
          paikeRecord.setCourseUuid(rs.getString("courseUuid"));             
          paikeRecord.setEmpUuid(rs.getString("empUuid"));
          paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
          paikeRecord.setKeDateTime(rs.getString("keDateTime"));
          paikeRecord.setKeStartTime(rs.getString("keStartTime"));
          paikeRecord.setKeLongTime(rs.getString("keLongTime"));
          paikeRecord.setStatus(rs.getString("status"));
          paikeRecord.setWeekSome(rs.getString("weekSome"));
          
          paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecord paikeRecordX = new PaikeRecord();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecord> paikeRecordListX = new ArrayList<PaikeRecord>();
        paikeRecordListX.add(paikeRecordX);
        return paikeRecordListX;
    }

    return paikeRecordList;
  }//end method getListByclaUuid

  @Override
  public PaikeRecord getByUuid(String uuid) {
    // TODO Auto-generated method stub
    PaikeRecord paikeRecordResult = new PaikeRecord();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_paike_all WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          PaikeRecord paikeRecord = new PaikeRecord();
          paikeRecord.setUuid(rs.getString("uuid"));
          paikeRecord.setClaUuid(rs.getString("claUuid"));
          paikeRecord.setCourseUuid(rs.getString("courseUuid"));             
          paikeRecord.setEmpUuid(rs.getString("empUuid"));
          paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
          paikeRecord.setKeDateTime(rs.getString("keDateTime"));
          paikeRecord.setKeStartTime(rs.getString("keStartTime"));
          paikeRecord.setKeLongTime(rs.getString("keLongTime"));
          paikeRecord.setStatus(rs.getString("status"));
          
          paikeRecordResult=paikeRecord;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getByUuid查询失败");
        PaikeRecord paikeRecordX = new PaikeRecord();
        paikeRecordX.setUuid("PaikeRecordDaoImpl失败返回的uuid");
        return paikeRecordX;
    }

    return paikeRecordResult;
  }// end method getByUuid

  @Override
  public ArrayList<PaikeRecord> getDateEmpList(String pai_date, String pai_empUuid) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = new ArrayList<PaikeRecord>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_paike_all where keDateTime ="+"'"+pai_date+"'"+" and "+"empUuid ="+"'"+pai_empUuid+"'");
        while (rs.next()) {
          PaikeRecord paikeRecord = new PaikeRecord();
          paikeRecord.setUuid(rs.getString("uuid"));
          paikeRecord.setClaUuid(rs.getString("claUuid"));
          paikeRecord.setCourseUuid(rs.getString("courseUuid"));             
          paikeRecord.setEmpUuid(rs.getString("empUuid"));
          paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
          paikeRecord.setKeDateTime(rs.getString("keDateTime"));
          paikeRecord.setKeStartTime(rs.getString("keStartTime"));
          paikeRecord.setKeLongTime(rs.getString("keLongTime"));
          paikeRecord.setStatus(rs.getString("status"));
          
          paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecord paikeRecordX = new PaikeRecord();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecord> paikeRecordListX = new ArrayList<PaikeRecord>();
        paikeRecordListX.add(paikeRecordX);
        return paikeRecordListX;
    }

    return paikeRecordList;
  }//emd method getDateEmpList

  @Override
  public ArrayList<PaikeRecord> getDateCrList(String pai_date, String pai_crUuid) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = new ArrayList<PaikeRecord>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_paike_all where keDateTime ="+"'"+pai_date+"'"+" and "+"classroomUuid ="+"'"+pai_crUuid+"'");
        while (rs.next()) {
          PaikeRecord paikeRecord = new PaikeRecord();
          paikeRecord.setUuid(rs.getString("uuid"));
          paikeRecord.setClaUuid(rs.getString("claUuid"));
          paikeRecord.setCourseUuid(rs.getString("courseUuid"));             
          paikeRecord.setEmpUuid(rs.getString("empUuid"));
          paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
          paikeRecord.setKeDateTime(rs.getString("keDateTime"));
          paikeRecord.setKeStartTime(rs.getString("keStartTime"));
          paikeRecord.setKeLongTime(rs.getString("keLongTime"));
          paikeRecord.setStatus(rs.getString("status"));
          
          paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecord paikeRecordX = new PaikeRecord();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecord> paikeRecordListX = new ArrayList<PaikeRecord>();
        paikeRecordListX.add(paikeRecordX);
        return paikeRecordListX;
    }

    return paikeRecordList;
  }//emd method getDateCrList

  @Override
  public ArrayList<PaikeRecord> getDateClaList(String pai_date, String pai_claUuid) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = new ArrayList<PaikeRecord>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_paike_all where keDateTime ="+"'"+pai_date+"'"+" and "+"claUuid ="+"'"+pai_claUuid+"'");
        while (rs.next()) {
          PaikeRecord paikeRecord = new PaikeRecord();
          paikeRecord.setUuid(rs.getString("uuid"));
          paikeRecord.setClaUuid(rs.getString("claUuid"));
          paikeRecord.setCourseUuid(rs.getString("courseUuid"));             
          paikeRecord.setEmpUuid(rs.getString("empUuid"));
          paikeRecord.setClassroomUuid(rs.getString("classroomUuid"));
          paikeRecord.setKeDateTime(rs.getString("keDateTime"));
          paikeRecord.setKeStartTime(rs.getString("keStartTime"));
          paikeRecord.setKeLongTime(rs.getString("keLongTime"));
          paikeRecord.setStatus(rs.getString("status"));
          
          paikeRecordList.add(paikeRecord);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("PaikeRecordDaoImpl的getList查询失败");
        PaikeRecord paikeRecordX = new PaikeRecord();
        paikeRecordX.setUuid("PaikeRecordDaoImpl的getList失败返回的uuid");
        ArrayList<PaikeRecord> paikeRecordListX = new ArrayList<PaikeRecord>();
        paikeRecordListX.add(paikeRecordX);
        return paikeRecordListX;
    }

    return paikeRecordList;
  }//emd method getDateCrList

  

}//end class PaikeRecordDaoImpl
