package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

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
import com.sdpk.service.ClaService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午2:28:21
 * 类说明
 */

public class ClaServiceImpl implements ClaService{
  
  private ClaDao claDao= new ClaDaoImpl();
  private And_ClassEmpDao and_ClassEmpDao = new And_ClassEmpDaoImpl();
  public M_msg m_msg = new M_msg();
  private EmployeeDao employeeDao = new EmployeeDaoImpl();
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(Cla cla) {
    // TODO Auto-generated method stub
    cla.setUuid(null);

    cla.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在StudentServiceImpl收到数据 ："+cla.toString()+"收到结束!");
    boolean daoFlag = claDao.insert(cla);
    if(daoFlag)
    {
    return cla.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }

  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = claDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ClaServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(Cla cla) {
    // TODO Auto-generated method stub
    String uuid = cla.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = claDao.update(cla);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ClaServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
  }//end method update

  @Override
  public Cla getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      Cla cla = claDao.getByUuid(uuid);
      And_ClassEmp and_ClassEmp = and_ClassEmpDao.getBycla(uuid);
      Employee emp = employeeDao.getByUuid(and_ClassEmp.getEmpUuid());
      String claTeaName = emp.getName();
      if (claTeaName != null && claTeaName != "" && claTeaName.length() != 0) {
        cla.setEmpName(claTeaName);
      }else{
        String msg = "没有查到班主任名称，检查关联班级和班主任";
        m_msg.setGetOneMsg(msg);
      }
      
      
    return cla;
    }else{
      System.out.println("ClaServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      Cla claX= new Cla();
    return claX;
    }
  }//end method getByUuid

  @Override
  public ArrayList<Cla> getList() {
    // TODO Auto-generated method stub
    ArrayList<Cla> clalist = claDao.getList();

    return clalist;
  }//end method getList()

}//end class ClaServiceImpl
