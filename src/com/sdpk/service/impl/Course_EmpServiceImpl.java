package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.CourseDao;
import com.sdpk.dao.Course_EmpDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.dao.impl.Course_EmpDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.Cla;
import com.sdpk.model.Course;
import com.sdpk.model.Course_Emp;
import com.sdpk.model.Employee;
import com.sdpk.service.Course_EmpService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午5:55:21
 * 类说明
 */

public class Course_EmpServiceImpl implements Course_EmpService{
  
  private Course_EmpDao course_EmpDao = new Course_EmpDaoImpl();
  private CourseDao courseDao = new CourseDaoImpl();
  private EmployeeDao employeeDao = new EmployeeDaoImpl();
  public M_msg m_msg = new M_msg();
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(Course_Emp course_Emp) {
    // TODO Auto-generated method stub
    String courUuid = course_Emp.getCourseUuid();
    String empUuid = course_Emp.getEmpUuid();
    
  //1、判断数据库中是否已存在重复关系
    ArrayList<Course_Emp> CCList = course_EmpDao.getListBycourse(courUuid);
    for (Course_Emp one : CCList) {
      String oneEmpUuid = one.getEmpUuid();
      if(empUuid.equals(oneEmpUuid)){
        String msg = "不保存，数据库中已存在相同关系记录";
        m_msg.setAddMsg(msg);
        return msg;
      }
      
    }
    //判断1结束
    course_Emp.setUuid(null);
    course_Emp.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在And_ClassEmpServiceImpl收到数据 ：" + course_Emp.toString() + "收到结束!");
    
    //2、判断从基础班级表和员工表中有找到数据
    Course cour = courseDao.getByUuid(courUuid);
    Employee emp = employeeDao.getByUuid(empUuid);
    String courName = cour.getName();
    String empName = emp.getName();
    if (courName != null && courName != "" && courName.length() != 0) {
      if (empName != null && empName != "" && empName.length() != 0) {
        course_Emp.setCourseName(courName);
        course_Emp.setEmpName(empName);
        boolean daoFlag = course_EmpDao.insert(course_Emp);
        if (daoFlag) {
          return course_Emp.getUuid();
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
      String msg = "数据库里查到的课程名为空，导致关系数据不添加";
      m_msg.setAddMsg(msg);
      return msg;
    }

  }// end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = course_EmpDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="course_EmpServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String deleteByCour(String courseUuid) {
    // TODO Auto-generated method stub
    if(courseUuid!=null&&courseUuid!=""&& courseUuid.length() != 0)
    {
      boolean daoFlag = course_EmpDao.deleteByCour(courseUuid);
      
        if(daoFlag)
        {
        return courseUuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="course_EmpServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public ArrayList<Course_Emp> getListByCour(String courseUuid) {
    // TODO 11月10日21点留
    ArrayList<Course_Emp> list = course_EmpDao.getListBycourse(courseUuid);
    ArrayList<Course_Emp> reList =new ArrayList<Course_Emp>();
    for(Course_Emp one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String courUuid = one.getCourseUuid();
      String empUuid = one.getEmpUuid();
      Course cour = courseDao.getByUuid(courUuid);
      Employee emp = employeeDao.getByUuid(empUuid);
      String courName = cour.getName();
      String empName = emp.getName();
      
      Course_Emp copyOne = new Course_Emp();
      copyOne.setCourseUuid(courUuid);
      copyOne.setCourseName(courName);
      copyOne.setEmpUuid(empUuid);
      copyOne.setEmpName(empName);
      
      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla

  @Override
  public ArrayList<Course_Emp> getListByEmp(String empUuidA) {
    // TODO Auto-generated method stub
    ArrayList<Course_Emp> list = course_EmpDao.getListByEmp(empUuidA);
    ArrayList<Course_Emp> reList =new ArrayList<Course_Emp>();
    //返回的关联表的ArrayList<Course_Emp>里没有课程名和员工名，从基本表里查
    for(Course_Emp one : list){
      //1、从基础班级表和员工表中找到班级名和员工名,保证基础表修改了名称，关联表也能知道
      String courUuid = one.getCourseUuid();
      String empUuid = one.getEmpUuid();
      Course cour = courseDao.getByUuid(courUuid);
      Employee emp = employeeDao.getByUuid(empUuid);
      String courName = cour.getName();
      String empName = emp.getName();
      
      Course_Emp copyOne = new Course_Emp();
      copyOne.setCourseUuid(courUuid);
      copyOne.setCourseName(courName);
      copyOne.setEmpUuid(empUuid);
      copyOne.setEmpName(empName);
      
      String oldUuid =  one.getUuid();
      copyOne.setUuid(oldUuid);
      reList.add(copyOne);
    }

    return reList;
  }//end method getListBycla

}//end class
