package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Cla;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午3:03:59
 * 类说明
 */

public interface ClaDao {
  
  public boolean insert(Cla cla);

  public boolean delete(String uuid);

  public boolean update(Cla cla);

  public Cla getByUuid(String uuid);

  public ArrayList<Cla> getList();

}
