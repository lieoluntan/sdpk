package com.sdpk.service.impl;

import java.util.UUID;

import com.sdpk.dao.ContractDao;
import com.sdpk.dao.impl.ContractDaoImpl;
import com.sdpk.model.Contract;
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
    // TODO Auto-generated method stub
    contract.setUuid(null);

    contract.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在ContractServiceImpl收到数据 ："+contract.toString()+"收到结束!");
    contractDao.insert(contract);
    return contract.getUuid();
  }//end method insert

}//end class ContractServiceImpl
