package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.And_ClassCourseDao;
import com.sdpk.dao.ClaDao;
import com.sdpk.dao.CourseDao;
import com.sdpk.dao.impl.And_ClassCourseDaoImpl;
import com.sdpk.dao.impl.ClaDaoImpl;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.Cla;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.service.And_ClassCourseService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午3:21:23
 * 类说明
 */

public class And_ClassCourseServiceImpl implements And_ClassCourseService{
  
  private And_ClassCourseDao and_ClassCourseDao = new And_ClassCourseDaoImpl();
  private ClaDao claDao = new ClaDaoImpl();
  private CourseDao courseDao = new CourseDaoImpl();
  public M_msg m_msg = new M_msg();
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(And_ClassCourse and_ClassCourse) {
    // TODO Auto-generated method stub
    String cUuid = and_ClassCourse.getClassUuid();
    String courUuid = and_ClassCourse.getCourseUuid();
    
  //1、判断数据库中是否已存在重复关系
    ArrayList<And_ClassCourse> CCList = and_ClassCourseDao.getListBycla(cUuid);
    for (And_ClassCourse one : CCList) {
      String oneCourUuid = one.getCourseUuid();
      if(courUuid.equals(oneCourUuid)){
        String msg = "不保存，数据库中已存在相同关系记录";
        m_msg.setAddMsg(msg);
        return msg;
      }
      
    }
    //判断1结束
    and_ClassCourse.setUuid(null);
    and_ClassCourse.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在And_ClassEmpServiceImpl收到数据 ：" + and_ClassCourse.toString() + "收到结束!");
    
    //2、判断从基础班级表和员工表中有找到数据
    Cla cla = claDao.getByUuid(cUuid);
    Course cour = courseDao.getByUuid(courUuid);
    String cName = cla.getName();
    String courName = cour.getName();
    if (cName != null && cName != "" && cName.length() != 0) {
      if (courName != null && courName != "" && courName.length() != 0) {
        and_ClassCourse.setClassName(cName);
        and_ClassCourse.setCourseName(courName);
        boolean daoFlag = and_ClassCourseDao.insert(and_ClassCourse);
        if (daoFlag) {
          return and_ClassCourse.getUuid();
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
      boolean daoFlag = and_ClassCourseDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="And_ClassCourseServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String deleteBycla(String classUuid) {
    // TODO Auto-generated method stub
    if(classUuid!=null&&classUuid!="")
    {
      boolean daoFlag = and_ClassCourseDao.deleteBycla(classUuid);
      
        if(daoFlag)
        {
        return classUuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="And_ClassCourseServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public ArrayList<And_ClassCourse> getListBycla(String classUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassCourse> list = and_ClassCourseDao.getListBycla(classUuid);
    ArrayList<And_ClassCourse> reList =new ArrayList<And_ClassCourse>();
    for(And_ClassCourse one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String cUuid = one.getClassUuid();
      String courUuid = one.getCourseUuid();
      Cla cla = claDao.getByUuid(cUuid);
      Course cour = courseDao.getByUuid(courUuid);
      String cName = cla.getName();
      String courName = cour.getName();
      
      And_ClassCourse copyOne = new And_ClassCourse();
      copyOne.setClassUuid(cUuid);
      copyOne.setClassName(cName);
      copyOne.setCourseUuid(courUuid);
      copyOne .setCourseName(courName);
      
      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla

  @Override
  public ArrayList<And_ClassCourse> getListByCour(String courseUuid) {
    // TODO Auto-generated method stub
    ArrayList<And_ClassCourse> list = and_ClassCourseDao.getListByCour(courseUuid);
    ArrayList<And_ClassCourse> reList =new ArrayList<And_ClassCourse>();
    for(And_ClassCourse one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String cUuid = one.getClassUuid();
      String courUuid = one.getCourseUuid();
      Cla cla = claDao.getByUuid(cUuid);
      Course cour = courseDao.getByUuid(courUuid);
      String cName = cla.getName();
      String courName = cour.getName();
      
      And_ClassCourse copyOne = new And_ClassCourse();
      copyOne.setClassUuid(cUuid);
      copyOne.setClassName(cName);
      copyOne.setCourseUuid(courUuid);
      copyOne .setCourseName(courName);
      
      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla

}//end class
