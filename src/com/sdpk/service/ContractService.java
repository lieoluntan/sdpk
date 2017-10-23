package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.model.Student;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午5:50:12 类说明
 */

public interface ContractService {

  /**
   * 
   * @param 参数contract
   * @return String类型的字段uuid
   */
  String insert(Contract contract);

  /**
   * 获取合同列表数据
   * @return
   */
  ArrayList<Contract> getList();

  String delete(String uuid);

  String update(Contract contract);

  /**
   * 根据uuid查询单条数据
   * @param uuid
   * @return
   */
  Contract getByUuid(String uuid);
}
