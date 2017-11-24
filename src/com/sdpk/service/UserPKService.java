package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.UserPK;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 下午12:37:03
 * 类说明
 */

public interface UserPKService {
  
  M_msg getMsg();

  String insert(UserPK userPK);

  String delete(String uuid);

  String update(UserPK userPK);

  UserPK getByUuid(String uuid);

  ArrayList<UserPK> getList();

  boolean judge(UserPK userPK);

}//end interface
