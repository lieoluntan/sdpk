package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.And_ClassEmp;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午6:30:32
 * 类说明
 */

public interface And_ClassEmpService {
  
  M_msg  getMsg();
  
  String insert(And_ClassEmp and_ClassEmp);
  
  String deleteBycla(String classUuid);
  
  String delete(String uuid);
  
  ArrayList<And_ClassEmp> getListBycla(String classUuid);
  
  ArrayList<And_ClassEmp> getListByEmp(String empUuid);

}//end class 
