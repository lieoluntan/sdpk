package com.sdpk.service.impl;

import java.util.UUID;

import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.Employee;
import com.sdpk.service.EmployeeService;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午4:50:04
 * 类说明
 */

public class EmployeeServiceImpl implements EmployeeService{

  private EmployeeDao employeeDao= new EmployeeDaoImpl();
  
  @Override
  public String insert(Employee employee) {
    // TODO Auto-generated method stub
    employee.setUuid(null);

    employee.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在EmployeeServiceImpl收到数据 ："+employee.toString()+"收到结束!");
    employeeDao.insert(employee);
    return employee.getUuid();
  }

}
