package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.UserPK;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 下午12:42:03
 * 类说明
 */

public interface UserPKDao {

  boolean insert(UserPK userPK);

  boolean delete(String uuid);

  boolean update(UserPK userPK);

  UserPK getByUuid(String uuid);

  ArrayList<UserPK> getList();

  UserPK getByuLogUser(String uLogUser);

}//end interface
