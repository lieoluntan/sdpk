package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.ContractDao;
import com.sdpk.dao.impl.ContractDaoImpl;
import com.sdpk.model.Contract;
import com.sdpk.model.Student;
import com.sdpk.service.ContractService;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午5:55:04
 * 类说明
 */

public class ContractServiceImpl implements ContractService{

  private ContractDao contractDao= new ContractDaoImpl();
  
  @Override
  public String insert(Contract contract) {
//    
   
    contract.setUuid(null);

    contract.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在StudentServiceImpl收到数据 ："+contract.toString()+"收到结束!");
    boolean daoFlag = contractDao.insert(contract);
    if(daoFlag)
    {
    return contract.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }

  }//end method insert

  @Override
  public ArrayList<Contract> getList() {
    // TODO Auto-generated method stub
    ArrayList<Contract> contractlist = contractDao.getList();

    return contractlist;
  }//end method getList()

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = contractDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ContractServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println("ContractServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
      return msg;
    }
    
  }//end method delete

  @Override
  public String update(Contract contract) {
    // TODO Auto-generated method stub
    String uuid = contract.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = contractDao.update(contract);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      String msg="ContractServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println("ContractServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
      return msg;
    }
  }//end method update

  @Override
  public Contract getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      Contract contract = contractDao.getByUuid(uuid);
    return contract;
    }else{
      System.out.println("ContractServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      Contract contractX= new Contract();
    return contractX;
    }
  }//end method getByUuid

}//end class ContractServiceImpl
