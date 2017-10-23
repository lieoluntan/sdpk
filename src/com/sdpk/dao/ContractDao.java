package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.Contract;
import com.sdpk.model.Course;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午7:46:09
 * 类说明
 */

public interface ContractDao {
  
  public boolean insert(Contract contract);

  /**
   * 获取合同列表数据
   * @return
   */
  public ArrayList<Contract> getList();

  public boolean delete(String uuid);

  public boolean update(Contract contract);

  public Contract getByUuid(String uuid);

}
