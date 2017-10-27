package com.sdpk.utility;

import java.util.Map;

import com.sdpk.model.Cla;
import com.sdpk.model.Contract;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午1:42:03
 * 类说明
 */

public class T_DataMap2Bean {
  
  public Cla MapToCla(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String org = (String) map.get("org");
    String name = (String) map.get("name");
    String empUuid = (String) map.get("empUuid");
    String classDate = (String) map.get("classDate");
    String status = (String) map.get("status");
    String remark = (String) map.get("remark");


    Cla cla = new Cla(uuid, org, name, empUuid, classDate, status, remark);
    return cla;
  }// end method MapToEmp

}//end class T_DataMap2Bean
