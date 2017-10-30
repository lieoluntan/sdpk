package com.sdpk.utility;

import java.util.Map;

import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Employee;

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
  
  public ClassRoom MapToClassRoom(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String name = (String) map.get("name");
    String campus = (String) map.get("campus");
    String remark = (String) map.get("remark");
    

    ClassRoom classRoom = new ClassRoom(uuid,name,campus,remark);
    return classRoom;
  }// end method MapToEmp
  
public Employee MapToEmp(Map<String,Object> map){
    
    String uuid = (String) map.get("uuid");
    String name = (String) map.get("name");
    String empNum = (String) map.get("empNum");
    String phone = (String) map.get("phone");
    String depart = (String) map.get("depart");
    String job = (String) map.get("job");
    String permissionTempl = (String) map.get("permissionTempl");
    String course = (String) map.get("course");
    String remark = (String) map.get("remark");
    
    Employee emp = new Employee(uuid,name, empNum, phone, depart, job, permissionTempl, course, remark);
    return emp;
  }//end method MapToEmp

}//end class T_DataMap2Bean
