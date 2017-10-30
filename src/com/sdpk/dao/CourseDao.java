package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Course;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午4:05:31
 * 类说明
 */

public interface CourseDao {
  
  
  public boolean insert(Course course);

  public boolean delete(String uuid);

  public boolean update(Course course);

  public ArrayList<Course> getListCourse();

  public Course getByUuid(String uuid);

}
