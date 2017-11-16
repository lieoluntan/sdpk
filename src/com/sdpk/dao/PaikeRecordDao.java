package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.PaikeRecord;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午11:04:04
 * 类说明
 */

public interface PaikeRecordDao {
  
  public boolean insert(PaikeRecord paikeRecord);

  public boolean delete(String uuid);

  public boolean update(PaikeRecord paikeRecord);

  public ArrayList<PaikeRecord> getList();

  public PaikeRecord getByUuid(String uuid);

  public ArrayList<PaikeRecord> getDateEmpList(String pai_date, String pai_empUuid);

  public ArrayList<PaikeRecord> getDateCrList(String pai_date, String pai_crUuid);

  public ArrayList<PaikeRecord> getListByclaUuid(String claUuid);

  public ArrayList<PaikeRecord> getDateClaList(String pai_date, String pai_claUuid);


}//end class interface PaikeRecordDao
