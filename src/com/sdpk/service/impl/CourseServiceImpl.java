package com.sdpk.service.impl;

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

}//end class CourseServiceImpl
