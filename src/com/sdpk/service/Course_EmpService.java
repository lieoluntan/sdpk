package com.sdpk.service;

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

}//end class interface 
