package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.PaikeRecordDao;
import com.sdpk.dao.impl.PaikeRecordDaoImpl;
import com.sdpk.model.Contract;
import com.sdpk.model.PaikeRecord;
import com.sdpk.service.PaikeRecordService;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午10:58:38
 * 类说明
 */

public class PaikeRecordServiceImpl implements PaikeRecordService{
  
  private PaikeRecordDao paikeRecordDao= new PaikeRecordDaoImpl();

  @Override
  public String insert(PaikeRecord paikeRecord) {
    
    paikeRecord.setUuid(null);

    paikeRecord.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在PaikeRecordServiceImpl收到数据 ："+paikeRecord.toString()+"收到结束!");
    boolean daoFlag = paikeRecordDao.insert(paikeRecord);
    if(daoFlag)
    {
    return paikeRecord.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }
  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = paikeRecordDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="PaikeRecordServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println("PaikeRecordServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(PaikeRecord paikeRecord) {
    // TODO Auto-generated method stub
    String uuid = paikeRecord.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = paikeRecordDao.update(paikeRecord);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="PaikeRecordServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println("PaikeRecordServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
      return msg;
    }
  }//end method update

  @Override
  public ArrayList<PaikeRecord> getList() {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = paikeRecordDao.getList();

    return paikeRecordList;
  }//end method getList()

  @Override
  public PaikeRecord getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      PaikeRecord paikeRecord = paikeRecordDao.getByUuid(uuid);
    return paikeRecord;
    }else{
      System.out.println("PaikeRecordServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      PaikeRecord paikeRecordX= new PaikeRecord();
    return paikeRecordX;
    }
  }//end method getByUuid

}//end class PaikeRecordServiceImpl
