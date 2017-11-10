package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Course_Emp;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午5:54:27
 * 类说明
 */

public interface Course_EmpService {

  M_msg getMsg();

  String insert(Course_Emp course_Emp);

  String delete(String uuid);

  String deleteByCour(String courseUuid);

  ArrayList<Course_Emp> getListByCour(String courseUuid);

  ArrayList<Course_Emp> getListByEmp(String empUuid);

}//end class interface 
