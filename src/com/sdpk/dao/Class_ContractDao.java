package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Class_Contract;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-15 下午3:30:31
 * 类说明
 */

public interface Class_ContractDao {
  
  ArrayList<Class_Contract> getListBycla(String classUuid);

}//end interface
