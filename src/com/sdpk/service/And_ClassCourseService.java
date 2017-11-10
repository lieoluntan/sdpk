package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.And_ClassStu;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午3:20:50
 * 类说明
 */

public interface And_ClassCourseService {

  M_msg getMsg();

  String insert(And_ClassCourse and_ClassCourse);

  String delete(String uuid);

  String deleteBycla(String classUuid);

  ArrayList<And_ClassCourse> getListBycla(String classUuid);

  ArrayList<And_ClassCourse> getListByCour(String courseUuid);


}//end class interface
