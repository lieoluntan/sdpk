package com.sdpk.dao;

import java.util.ArrayList;

import com.sdpk.model.ClassRoom;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-30 上午9:50:22
 * 类说明
 */

public interface ClassRoomDao {
  
  public boolean insert(ClassRoom classRoom);

  public boolean delete(String uuid);

  public boolean update(ClassRoom classRoom);

  public ClassRoom getByUuid(String uuid);

  public ArrayList<ClassRoom> getList();

}
