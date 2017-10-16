package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.CourseDao;
import com.sdpk.dao.impl.CourseDaoImpl;
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
    courseDao.insert(course);
    return course.getUuid();
  }

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      courseDao.delete(uuid);
      return uuid;
    }else{
      System.out.println("CourseServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
      return uuid;
    }
    
  }//end method delete

  @Override
  public String update(Course course) {
    // TODO Auto-generated method stub
    String uuid = course.getUuid();
    if(uuid!=null&&uuid!="")
    {
      courseDao.update(course);
      return uuid;
    }else{
      System.out.println("CourseServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
      return uuid;
    }
  }//end method update

  @Override
  public ArrayList<Course> getListCourse() {
    // TODO Auto-generated method stub
    
    ArrayList<Course> courselist = courseDao.getListCourse();
    
    return courselist;
  }//end method getListCourse

}//end class CourseServiceImpl
