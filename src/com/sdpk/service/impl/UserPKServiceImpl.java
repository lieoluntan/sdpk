package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.UserPKDao;
import com.sdpk.dao.impl.UserPKDaoImpl;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.UserPK;
import com.sdpk.service.UserPKService;
import com.sdpk.utility.M_msg;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 下午12:39:00
 * 类说明
 */

public class UserPKServiceImpl implements UserPKService{
  
  private UserPKDao userPKDao= new UserPKDaoImpl();
  public M_msg m_msg = new M_msg();

  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(UserPK userPK) {
 // TODO Auto-generated method stub
    userPK.setUuid(null);

    userPK.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在userPKServiceImpl收到数据 ："+userPK.toString()+"收到结束!");
    boolean daoFlag = userPKDao.insert(userPK);
    if(daoFlag)
    {
    return userPK.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }

  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = userPKDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="userPKDao delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(UserPK userPK) {
    // TODO Auto-generated method stub
    String uuid = userPK.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = userPKDao.update(userPK);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="userPKService update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println(msg);
      return msg;
    }
  }//end method update

  @Override
  public UserPK getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      UserPK userPK = userPKDao.getByUuid(uuid);
    return userPK;
    }else{
      System.out.println("UserPKServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      UserPK userPKx= new UserPK();
    return userPKx;
    }
  }//end method getByUuid

  @Override
  public ArrayList<UserPK> getList() {
    // TODO Auto-generated method stub
    ArrayList<UserPK> userPKlist = userPKDao.getList();

    return userPKlist;
  }//end method getList()

}//end class
