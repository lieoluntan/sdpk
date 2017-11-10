package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.And_ClassStu;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午1:27:04
 * 类说明
 */

public interface And_ClassStuService {

  M_msg getMsg();

  String insert(And_ClassStu and_ClassStu);

  String delete(String uuid);

  String deleteBycla(String classUuid);

  ArrayList<And_ClassStu> getListBycla(String classUuid);

  ArrayList<And_ClassStu> getListByStu(String stuUuid);

}// end class interface 
