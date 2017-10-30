package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.Cla;
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
    boolean daoFlag = employeeDao.insert(employee);
    if(daoFlag)
    {
    return employee.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }
  }

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = employeeDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="EmployeeServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(Employee employee) {
    // TODO Auto-generated method stub
    String uuid = employee.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = employeeDao.update(employee);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="EmployeeServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
  }//end method update

  @Override
  public Employee getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      Employee employee = employeeDao.getByUuid(uuid);
    return employee;
    }else{
      System.out.println("ContractServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      Employee employeeX= new Employee();
    return employeeX;
    }
  }//end method getByUuid

  @Override
  public ArrayList<Employee> getList() {
    // TODO Auto-generated method stub
    ArrayList<Employee> employeeList = employeeDao.getList();

    return employeeList;
  }//end method getList()

}// end class 
