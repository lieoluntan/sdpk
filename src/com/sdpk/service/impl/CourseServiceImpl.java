package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.CourseDao;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.model.Cla;
import com.sdpk.model.Course;
import com.sdpk.service.CourseService;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午3:51:46
 * 类说明
 */

public class CourseServiceImpl implements CourseService{
  
  private CourseDao courseDao= new CourseDaoImpl();

  @Override
  public String insert(Course course) {
    // TODO Auto-generated method stub
    course.setUuid(null);

    course.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在CourseDaoImpl收到数据 ："+course.toString()+"收到结束!");
    boolean daoFlag = courseDao.insert(course);
    if(daoFlag)
    {
    return course.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }

  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = courseDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,CourseDaoImpl层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="CourseDaoImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(Course course) {
    // TODO Auto-generated method stub
    String uuid = course.getUuid();
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = courseDao.update(course);
      
      if(daoFlag)
      {
      return uuid;
      }else{
        return "修改不成功,dao层执行有出错地方,请联系管理员";
      }
    }else{
      String msg="CourseServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员";
      System.out.println(msg);
      return msg;
    }
  }//end method update

  @Override
  public ArrayList<Course> getListCourse() {
    // TODO Auto-generated method stub
    
    ArrayList<Course> courselist = courseDao.getListCourse();
    
    return courselist;
  }//end method getListCourse

  @Override
  public Course getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      Course course = courseDao.getByUuid(uuid);
    return course;
    }else{
      System.out.println("CourseServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      Course courseX= new Course();
    return courseX;
    }
  }//end method getByUuid

}//end class CourseServiceImpl
