package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Employee;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午4:47:37
 * 类说明
 */

public interface EmployeeService {
  
  String insert(Employee employee);

  String delete(String uuid);

  String update(Employee employee);

  Employee getByUuid(String uuid);

  ArrayList<Employee> getList();

  ArrayList<Employee> getclaTeaList();

}
