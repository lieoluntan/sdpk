package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.EmployeeDao;
import com.sdpk.model.Cla;
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
  boolean daoFlag = false;

  public EmployeeDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在EmployeeDaoImpl连接!");
  }

  @Override
  public boolean insert(Employee employee) {

    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_employee(uuid,name,empNum,phone,depart,job,remark,claTeacher,sex,org,workDate,fullhalf,jobRemark) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, employee.getUuid());
      preparedStatement.setString(2, employee.getName());
      preparedStatement.setString(3, employee.getEmpNum());
      preparedStatement.setString(4, employee.getPhone());
      preparedStatement.setString(5, employee.getDepart());
      preparedStatement.setString(6, employee.getJob());
      preparedStatement.setString(7, employee.getRemark());
      preparedStatement.setString(8, employee.getClaTeacher());
      
      preparedStatement.setString(9, employee.getSex());
      preparedStatement.setString(10, employee.getOrg());
      preparedStatement.setString(11, employee.getWorkDate());
      preparedStatement.setString(12, employee.getFullhalf());
      preparedStatement.setString(13, employee.getJobRemark());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的insert添加");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      System.out.println("^^在执行EmployeeDaoImpl中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }
  }// end method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_employee WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行EmployeeDaoImpl中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean update(Employee employee) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_employee SET name = ?, empNum = ?,phone = ?, depart = ?, job = ?, remark = ?  WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, employee.getName());
      preparedStatement.setString(2, employee.getEmpNum());
      preparedStatement.setString(3, employee.getPhone());
      preparedStatement.setString(4, employee.getDepart());
      preparedStatement.setString(5, employee.getJob());
      preparedStatement.setString(6, employee.getRemark());
      preparedStatement.setString(7, employee.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行EmployeeDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行EmployeeDaoImpl中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method update

  @Override
  public Employee getByUuid(String uuid) {
    // TODO Auto-generated method stub
    Employee employeeResult = new Employee();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_employee WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          Employee employee = new Employee();
          employee.setUuid(rs.getString("uuid"));
          employee.setName(rs.getString("name"));
          employee.setEmpNum(rs.getString("empNum"));             
          employee.setPhone(rs.getString("phone"));
          employee.setDepart(rs.getString("depart"));
          employee.setJob(rs.getString("job"));
          employee.setRemark(rs.getString("remark"));
          
          employeeResult=employee;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("ClaDaoImpl的getByUuid查询失败");
        Employee employeeX = new Employee();
        employeeX.setUuid("ClaDaoImpl失败返回的uuid");
        return employeeX;
    }

    return employeeResult;
  }// end method getByUuid

  @Override
  public ArrayList<Employee> getList() {
    // TODO Auto-generated method stub
    ArrayList<Employee> employeeList = new ArrayList<Employee>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_employee");
        while (rs.next()) {
          Employee employee = new Employee();
          employee.setUuid(rs.getString("uuid"));
          employee.setName(rs.getString("name"));
          employee.setEmpNum(rs.getString("empNum"));             
          employee.setPhone(rs.getString("phone"));
          employee.setDepart(rs.getString("depart"));
          employee.setJob(rs.getString("job"));
          employee.setRemark(rs.getString("remark"));
          
          employeeList.add(employee);
        }
        
        return employeeList;
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("EmployeeDaoImpl的getList查询失败");
        Employee employeeX = new Employee();
        employeeX.setUuid("EmployeeDaoImpl的getList失败返回的uuid");
        ArrayList<Employee> employeeListX = new ArrayList<Employee>();
        employeeListX.add(employeeX);
        return employeeListX;
    }

    
  }//emd method getList

}//end class
