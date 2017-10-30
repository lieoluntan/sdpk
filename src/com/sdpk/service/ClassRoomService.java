package com.sdpk.service;

import java.util.ArrayList;

import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-30 上午9:44:48
 * 类说明
 */

public interface ClassRoomService {
  
  String insert(ClassRoom classRoom);

  String delete(String uuid);

  String update(ClassRoom classRoom);

  ClassRoom getByUuid(String uuid);

  ArrayList<ClassRoom> getList();

}//end class interface
