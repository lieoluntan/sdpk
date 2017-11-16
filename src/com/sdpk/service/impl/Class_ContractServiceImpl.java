package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.ClaDao;
import com.sdpk.dao.Class_ContractDao;
import com.sdpk.dao.ContractDao;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.Class_ContractDaoImpl;
import com.sdpk.dao.impl.ContractDaoImpl;
import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;
import com.sdpk.model.Class_Contract;
import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.service.Class_ContractService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-15 下午3:49:21
 * 类说明
 */

public class Class_ContractServiceImpl implements Class_ContractService{
  
  private Class_ContractDao class_ContractDao = new Class_ContractDaoImpl();
  private ClaDao claDao = new ClaDaoImpl();
  private ContractDao contractDao= new ContractDaoImpl();
  public M_msg m_msg = new M_msg();
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }
  

  @Override
  public ArrayList<Class_Contract> getListBycla(String classUuid) {
    // TODO Auto-generated method stub
    ArrayList<Class_Contract> list = class_ContractDao.getListBycla(classUuid);
    ArrayList<Class_Contract> reList =new ArrayList<Class_Contract>();
    for(Class_Contract one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String cUuid = one.getClassUuid();
      String contrUuid = one.getContrUuid();
      Cla cla = claDao.getByUuid(cUuid);
      Contract contr = contractDao.getByUuid(contrUuid);
      String cName = cla.getName();
      String contrName = contr.getcNum();
      
      Class_Contract copyOne = new Class_Contract();
      copyOne.setClassUuid(cUuid);
      copyOne.setClassName(cName);
      copyOne.setContrUuid(contrUuid);
      copyOne.setContrName(contrName);
      
      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla


  @Override
  public String insert(Class_Contract class_Contract) {
    // TODO Auto-generated method stub
    String cUuid = class_Contract.getClassUuid();
    String contrUuid = class_Contract.getContrUuid();
    
  //一对一判断，一个合同存一个班级,班级合同表的特殊判断
    Class_Contract aOne = class_ContractDao.getOneBycontr(contrUuid);
    if(contrUuid.equals(aOne.getContrUuid())){
      String msg = "不保存，合同已关联班级，一个合同存一个班级";
      m_msg.setAddMsg(msg);
      return msg;
    }
    
  //1、判断数据库中是否已存在重复关系
    ArrayList<Class_Contract> CCList = class_ContractDao.getListBycla(cUuid);
    for (Class_Contract one : CCList) {
      String oneCourUuid = one.getContrUuid();
      if(contrUuid.equals(oneCourUuid)){
        String msg = "不保存，数据库中已存在相同关系记录";
        m_msg.setAddMsg(msg);
        return msg;
      }
      
    }
    //判断1结束
    class_Contract.setUuid(null);
    class_Contract.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在Class_ContractServiceImpl收到数据 ：" + class_Contract.toString() + "收到结束!");
    
    //2、判断从基础班级表和合同表中有找到数据
    Cla cla = claDao.getByUuid(cUuid);
    Contract contr = contractDao.getByUuid(contrUuid);
    String cName = cla.getName();
    String contrName = contr.getcNum();
    if (cName != null && cName != "" && cName.length() != 0) {
      if (contrName != null && contrName != "" && contrName.length() != 0) {
        class_Contract.setClassName(cName);
        class_Contract.setContrName(contrName);
        boolean daoFlag = class_ContractDao.insert(class_Contract);
        if (daoFlag) {
          return class_Contract.getUuid();
        } else {
          String msg = "插入不成功,dao层执行有出错地方,请联系管理员";
          m_msg.setAddMsg(msg);
          return msg;
          
        }

      } else {
        String msg = "数据库里查到的合同名为空，导致关系数据不添加";
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
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = class_ContractDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="Class_ContractServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete


  @Override
  public String deleteBycla(String classUuid) {
    // TODO Auto-generated method stub
    if(classUuid!=null&&classUuid!="")
    {
      boolean daoFlag = class_ContractDao.deleteBycla(classUuid);
      
        if(daoFlag)
        {
        return classUuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="Class_ContractServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete


  @Override
  public ArrayList<Class_Contract> getListByContr(String contrUuid) {
    // TODO Auto-generated method stub
    ArrayList<Class_Contract> list = class_ContractDao.getListByContr(contrUuid);
    ArrayList<Class_Contract> reList =new ArrayList<Class_Contract>();
    for(Class_Contract one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String cUuid = one.getClassUuid();
      String contrUuidA = one.getContrUuid();
      Cla cla = claDao.getByUuid(cUuid);
      Contract contr = contractDao.getByUuid(contrUuidA);
      String cName = cla.getName();
      String contrName = contr.getcNum();
      
      Class_Contract copyOne = new Class_Contract();
      copyOne.setClassUuid(cUuid);
      copyOne.setClassName(cName);
      copyOne.setContrUuid(contrUuidA);
      copyOne.setContrName(contrName);
      
      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla


  

}//end class
