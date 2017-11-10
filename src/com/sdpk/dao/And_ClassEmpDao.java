package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.Cla;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午7:08:33
 * 类说明
 */

public interface And_ClassEmpDao {
  
  public boolean insert(And_ClassEmp and_ClassEmp);
  
  public ArrayList<And_ClassEmp> getListBycla(String classUuid);

  public And_ClassEmp getBycla(String classUuid);

}
