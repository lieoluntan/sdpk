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
  
  String insert(PaikeRecord paikeRecord);

  String delete(String uuid);

  String update(PaikeRecord paikeRecord);

  ArrayList<PaikeRecord> getList();

  PaikeRecord getByUuid(String uuid);

  PaikeRecord selectConflict(PaikeRecord paikeRecord) throws ParseException;

}//end class interface PaikeRecordService
