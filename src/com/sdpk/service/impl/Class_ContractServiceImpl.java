package com.sdpk.service.impl;

import java.util.ArrayList;

import com.sdpk.dao.ClaDao;
import com.sdpk.dao.Class_ContractDao;
import com.sdpk.dao.ContractDao;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.Class_ContractDaoImpl;
import com.sdpk.dao.impl.ContractDaoImpl;
import com.sdpk.model.And_ClassCourse;
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

}//end class
