package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Course_Emp;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午5:59:17
 * 类说明
 */

public interface Course_EmpDao {

  ArrayList<Course_Emp> getListBycourse(String courseUuid);

  boolean insert(Course_Emp course_Emp);

  boolean delete(String uuid);

  boolean deleteByCour(String courseUuid);

  ArrayList<Course_Emp> getListByEmp(String empUuid);


}// end class interface
