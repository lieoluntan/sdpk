package com.sdpk.service;

import java.text.ParseException;
import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午10:56:15
 * 类说明
 */

public interface PaikeRecordService {
  /**
   * 单个新增
   * @param paikeRecord
   * @return
   */
  String insert(PaikeRecord paikeRecord);
  
  /**
   * 批量新增
   * @param PR_List
   * @return
   * 关系：调用了单个保存的dao
   */
  String insert_batch(ArrayList<PaikeRecord> PR_List);

  String delete(String uuid);

  String update(PaikeRecord paikeRecord);

  /**
   * 获取数据库表里所有的记录
   * @return
   */
  ArrayList<PaikeRecord> getList();
  
  /**
   * 获取数据库表里指定班级的记录
   * @return
   */
  ArrayList<PaikeRecord> getListByclaUuid(String claUuid);

  PaikeRecord getByUuid(String uuid);

  /**
   * 单个查询冲突
   * @param paikeRecord
   * @return
   * @throws ParseException
   */
  PaikeRecord selectConflict(PaikeRecord paikeRecord) throws ParseException;
  
  /**
   * 批量查询冲突
   * @param PR_List
   * @return 
   * 关联：调用了单个冲突查询
   */
  ArrayList<PaikeRecord> selectConflict_batch(ArrayList<PaikeRecord> PR_List);
  

}//end class interface PaikeRecordService
