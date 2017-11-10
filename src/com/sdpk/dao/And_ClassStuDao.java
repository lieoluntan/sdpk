package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.And_ClassStu;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午1:46:59
 * 类说明
 */

public interface And_ClassStuDao {

  ArrayList<And_ClassStu> getListBycla(String classUuid);

  boolean insert(And_ClassStu and_ClassStu);

  boolean delete(String uuid);

  boolean deleteBycla(String classUuid);

  ArrayList<And_ClassStu> getListByStu(String stuUuid);

}// end class interface
