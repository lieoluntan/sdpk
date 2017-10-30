package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.ClassRoomDao;
import com.sdpk.dao.impl.ClassRoomDaoImpl;
import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.service.ClassRoomService;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-30 上午9:46:29
 * 类说明
 */

public class ClassRoomServiceImpl implements ClassRoomService{
  
  private ClassRoomDao classRoomDao= new ClassRoomDaoImpl();

  @Override
  public String insert(ClassRoom classRoom) {
    // TODO Auto-generated method stub
    classRoom.setUuid(null);

    classRoom.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在ClassRoomServiceImpl收到数据 ："+classRoom.toString()+"收到结束!");
    boolean daoFlag = classRoomDao.insert(classRoom);
    if(daoFlag)
    {
    return classRoom.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }

  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = classRoomDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ClassRoomServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(ClassRoom classRoom) {
    // TODO Auto-generated method stub
    String uuid = classRoom.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = classRoomDao.update(classRoom);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ClassRoomServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
  }//end method update

  @Override
  public ClassRoom getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      ClassRoom classRoom = classRoomDao.getByUuid(uuid);
    return classRoom;
    }else{
      System.out.println("ContractServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      ClassRoom classRoomX= new ClassRoom();
    return classRoomX;
    }
  }//end method getByUuid

  @Override
  public ArrayList<ClassRoom> getList() {
    // TODO Auto-generated method stub
    ArrayList<ClassRoom> classRoomlist = classRoomDao.getList();

    return classRoomlist;
  }//end method getList()

}//end class 
