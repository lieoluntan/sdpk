package com.sdpk.service;

import com.sdpk.model.Contract;
import com.sdpk.model.Course;

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
}
