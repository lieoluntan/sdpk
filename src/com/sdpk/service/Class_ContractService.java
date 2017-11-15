package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Class_Contract;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-15 下午3:47:16
 * 类说明
 */

public interface Class_ContractService {
  
  M_msg getMsg();
  
  ArrayList<Class_Contract> getListBycla(String classUuid);

  String insert(Class_Contract class_Contract);

  String delete(String uuid);

  String deleteBycla(String classUuid);

  ArrayList<Class_Contract> getListByContr(String contrUuid);

}//end interface
