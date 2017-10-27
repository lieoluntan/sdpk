package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.model.Contract;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午2:26:27
 * 类说明
 */

public interface ClaService {
  
  String insert(Cla cla);

  String delete(String uuid);

  String update(Cla cla);

  Cla getByUuid(String uuid);

  ArrayList<Cla> getList();

}//end class interface ClaService
