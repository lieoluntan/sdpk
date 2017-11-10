package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.controller.EmployeeControl;
import com.sdpk.dao.And_ClassEmpDao;
import com.sdpk.dao.ClaDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.And_ClassEmpDaoImpl;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;
import com.sdpk.model.Employee;
import com.sdpk.service.And_ClassEmpService;
import com.sdpk.service.EmployeeService;
import com.sdpk.utility.M_msg;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午6:32:02 类说明
 */

public class And_ClassEmpServiceImpl implements And_ClassEmpService {

  private And_ClassEmpDao and_ClassEmpDao = new And_ClassEmpDaoImpl();
  private ClaDao claDao = new ClaDaoImpl();
  private EmployeeDao employeeDao = new EmployeeDaoImpl();
  public M_msg m_msg = new M_msg();

  @Override
  public String insert(And_ClassEmp and_ClassEmp) {
    // TODO Auto-generated method stub
    
    String cUuid = and_ClassEmp.getClassUuid();
    String eUuid = and_ClassEmp.getEmpUuid();
    
    //一对一判断，一个班级存一条班主任,班级员工表的特殊判断
    And_ClassEmp aOne = and_ClassEmpDao.getBycla(cUuid);
    if(cUuid.equals(aOne.getClassUuid())){
      String msg = "不保存，数据库中已存在一条关系记录";
      m_msg.setAddMsg(msg);
      return msg;
    }
    
    
  //1、判断数据库中是否已存在重复关系
    ArrayList<And_ClassEmp> ceList = and_ClassEmpDao.getListBycla(cUuid);
    for (And_ClassEmp one : ceList) {
      String oneEuuid = one.getEmpUuid();
      if(eUuid.equals(oneEuuid)){
        String msg = "不保存，数据库中已存在相同关系记录";
        m_msg.setAddMsg(msg);
        return msg;
      }
      
    }
    //判断1结束
    and_ClassEmp.setUuid(null);
    and_ClassEmp.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在And_ClassEmpServiceImpl收到数据 ：" + and_ClassEmp.toString() + "收到结束!");
    
    //2、判断从基础班级表和员工表中有找到数据
    Cla cla = claDao.getByUuid(cUuid);
    Employee emp = employeeDao.getByUuid(eUuid);
    String cName = cla.getName();
    String eName = emp.getName();
    if (cName != null && cName != "" && cName.length() != 0) {
      if (eName != null && eName != "" && eName.length() != 0) {
        and_ClassEmp.setClassName(cName);
        and_ClassEmp.setEmpName(eName);
        boolean daoFlag = and_ClassEmpDao.insert(and_ClassEmp);
        if (daoFlag) {
          return and_ClassEmp.getUuid();
        } else {
          String msg = "插入不成功,dao层执行有出错地方,请联系管理员";
          m_msg.setAddMsg(msg);
          return msg;
          
        }

      } else {
        String msg = "数据库里查到的员工名为空，导致关系数据不添加";
        m_msg.setAddMsg(msg);
        return msg;
      }

    } else {
      String msg = "数据库里查到的班级名为空，导致关系数据不添加";
      m_msg.setAddMsg(msg);
      return msg;
    }

  }// end method insert

  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

}// end class
