package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.And_ClassCourse;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午3:26:02
 * 类说明
 */

public interface And_ClassCourseDao {

  ArrayList<And_ClassCourse> getListBycla(String cUuid);

  boolean insert(And_ClassCourse and_ClassCourse);

  boolean delete(String uuid);

  boolean deleteBycla(String classUuid);

  ArrayList<And_ClassCourse> getListByCour(String courseUuid);

}//end class interface
