package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.And_ClassStuDao;
import com.sdpk.dao.ClaDao;
import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.And_ClassStuDaoImpl;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.Cla;
import com.sdpk.model.Employee;
import com.sdpk.model.Student;
import com.sdpk.service.And_ClassStuService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午1:27:59
 * 类说明
 */

public class And_ClassStuServiceImpl implements And_ClassStuService{
  
  private And_ClassStuDao and_ClassStuDao = new And_ClassStuDaoImpl();
  private ClaDao claDao = new ClaDaoImpl();
  private StudentDao studentDao = new StudentDaoImpl();
  public M_msg m_msg = new M_msg();
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(And_ClassStu and_ClassStu) {
    // TODO Auto-generated method stub
    String cUuid = and_ClassStu.getClassUuid();
    String sUuid = and_ClassStu.getStuUuid();
    
  //一对一判断，一个学员关联一个班级,班级学生表的特殊判断
    And_ClassStu aOne = and_ClassStuDao.getBystu(sUuid);
    if(sUuid.equals(aOne.getStuUuid())){
      String msg = "不保存，一个学生只关联一个班级,该生关联班级:~~"+aOne.getClassName();
      m_msg.setAddMsg(msg);
      return msg;
    }
    
  //1、判断数据库中是否已存在重复关系
    ArrayList<And_ClassStu> CSList = and_ClassStuDao.getListBycla(cUuid);
    for (And_ClassStu one : CSList) {
      String oneSuuid = one.getStuUuid();
      if(sUuid.equals(oneSuuid)){
        String msg = "不保存，数据库中已存在相同关系记录";
        m_msg.setAddMsg(msg);
        return msg;
      }
      
    }
    //判断1结束
    and_ClassStu.setUuid(null);
    and_ClassStu.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在And_ClassEmpServiceImpl收到数据 ：" + and_ClassStu.toString() + "收到结束!");
    
    //2、判断从基础班级表和员工表中有找到数据
    Cla cla = claDao.getByUuid(cUuid);
    Student stu = studentDao.getByUuid(sUuid);
    String cName = cla.getName();
    String sName = stu.getName();
    if (cName != null && cName != "" && cName.length() != 0) {
      if (sName != null && sName != "" && sName.length() != 0) {
        and_ClassStu.setClassName(cName);
        and_ClassStu.setStuName(sName);
        boolean daoFlag = and_ClassStuDao.insert(and_ClassStu);
        if (daoFlag) {
          return and_ClassStu.getUuid();
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
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = and_ClassStuDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="And_ClassStuServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String deleteBycla(String classUuid) {
    // TODO Auto-generated method stub
    if(classUuid!=null&&classUuid!="")
    {
      boolean daoFlag = and_ClassStuDao.deleteBycla(classUuid);
      
        if(daoFlag)
        {
        return classUuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="And_ClassStuServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public ArrayList<And_ClassStu> getListBycla(String classUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassStu> list = and_ClassStuDao.getListBycla(classUuid);
    ArrayList<And_ClassStu> reList =new ArrayList<And_ClassStu>();
    for(And_ClassStu one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String cUuid = one.getClassUuid();
      String sUuid = one.getStuUuid();
      Cla cla = claDao.getByUuid(cUuid);
      Student stu = studentDao.getByUuid(sUuid);
      String cName = cla.getName();
      String sName = stu.getName();
      
      And_ClassStu copyOne = new And_ClassStu();
      copyOne.setClassUuid(cUuid);
      copyOne.setClassName(cName);
      copyOne.setStuUuid(sUuid);
      copyOne.setStuName(sName);

      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla

  @Override
  public ArrayList<And_ClassStu> getListByStu(String stuUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassStu> list = and_ClassStuDao.getListByStu(stuUuid);
    ArrayList<And_ClassStu> reList =new ArrayList<And_ClassStu>();
    for(And_ClassStu one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String cUuid = one.getClassUuid();
      String sUuid = one.getStuUuid();
      Cla cla = claDao.getByUuid(cUuid);
      Student stu = studentDao.getByUuid(sUuid);
      String cName = cla.getName();
      String sName = stu.getName();
      
      And_ClassStu copyOne = new And_ClassStu();
      copyOne.setClassUuid(cUuid);
      copyOne.setClassName(cName);
      copyOne.setStuUuid(sUuid);
      copyOne.setStuName(sName);

      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla

}// end class 
