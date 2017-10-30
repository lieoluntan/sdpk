package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Course;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午3:50:36
 * 类说明
 */

public interface CourseService {
  
  String insert(Course course);

  String delete(String uuid);

  String update(Course course);

  ArrayList<Course> getListCourse();

  Course getByUuid(String uuid);

}
