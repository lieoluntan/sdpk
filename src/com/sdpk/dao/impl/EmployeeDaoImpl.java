package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sdpk.dao.EmployeeDao;
import com.sdpk.model.Employee;
import com.sdpk.utility.DBUtility;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午4:59:08 类说明
 */

public class EmployeeDaoImpl implements EmployeeDao {

  private Connection connection;

  public EmployeeDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在EmployeeDaoImpl连接!");
  }

  @Override
  public void insert(Employee employee) {

    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_employee(uuid,name,empNum) values (?,?, ?)");
      // Parameters start with 1
      preparedStatement.setString(1, employee.getUuid());
      preparedStatement.setString(2, employee.getName());
      preparedStatement.setString(3, employee.getEmpNum());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的insert添加");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }// end method insert

}
