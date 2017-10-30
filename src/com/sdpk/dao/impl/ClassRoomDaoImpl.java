package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.ClassRoomDao;
import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.utility.DBUtility;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-30 上午9:51:35
 * 类说明
 */

public class ClassRoomDaoImpl implements ClassRoomDao{
  
  private Connection connection;
  boolean daoFlag = false;
  
  public ClassRoomDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在ClaDaoImpl连接!");
  }

  @Override
  public boolean insert(ClassRoom classRoom) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_classroom(uuid,name,campus,remark) values (?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, classRoom.getUuid());
      preparedStatement.setString(2, classRoom.getName());
      preparedStatement.setString(3, classRoom.getCampus());
      preparedStatement.setString(4, classRoom.getRemark());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ClassRoomDaoImpl中的添加insert");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行ClassRoomDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
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
          .prepareStatement("DELETE FROM t_classroom WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行ClassRoomDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ClassRoomDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean update(ClassRoom classRoom) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_classroom SET name = ?, campus = ?,remark = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, classRoom.getName());
      preparedStatement.setString(2, classRoom.getCampus());
      preparedStatement.setString(3, classRoom.getRemark());
      preparedStatement.setString(4, classRoom.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行ClassRoomDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行ClassRoomDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method update

  @Override
  public ClassRoom getByUuid(String uuid) {
    // TODO Auto-generated method stub
    ClassRoom classRoomResult = new ClassRoom();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_classroom WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          ClassRoom classRoom = new ClassRoom();
          classRoom.setUuid(rs.getString("uuid"));
          classRoom.setName(rs.getString("name"));
          classRoom.setCampus(rs.getString("campus"));             
          classRoom.setRemark(rs.getString("remark"));
          
          classRoomResult=classRoom;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClassRoomDaoImpl的getByUuid查询失败");
        ClassRoom classRoomX = new ClassRoom();
        classRoomX.setUuid("ClassRoomDaoImpl失败返回的uuid");
        return classRoomX;
    }

    return classRoomResult;
  }// end method getByUuid

  @Override
  public ArrayList<ClassRoom> getList() {
    // TODO Auto-generated method stub
    ArrayList<ClassRoom> classRoomList = new ArrayList<ClassRoom>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_classroom");
        while (rs.next()) {
          ClassRoom classRoom = new ClassRoom();
          classRoom.setUuid(rs.getString("uuid"));
          classRoom.setName(rs.getString("name"));
          classRoom.setCampus(rs.getString("campus"));             
          classRoom.setRemark(rs.getString("remark"));
          
          classRoomList.add(classRoom);
        }
        
        return classRoomList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClaDaoImpl的getList查询失败");
        ClassRoom classRoomX = new ClassRoom();
        classRoomX.setUuid("ClaDaoImpl的getList失败返回的uuid");
        ArrayList<ClassRoom> classRoomListX = new ArrayList<ClassRoom>();
        classRoomListX.add(classRoomX);
        return classRoomListX;
    }

    
  }//emd method getList

}//end class
