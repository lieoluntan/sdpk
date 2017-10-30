package com.sdpk.utility;

import java.util.Map;

import com.sdpk.model.Cla;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Course;
import com.sdpk.model.Employee;
import com.sdpk.model.Student;

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

public Course MapToCourse(Map<String, Object> map) {

  String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
  String name = (String) map.get("name");
  String category = (String) map.get("category");
  String describe = (String) map.get("describe");

  Course course = new Course(uuid, name, category, describe);
  return course;
}// end method MapToEmp

public Student MapToStudent(Map<String, Object> map) {

  String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
  String name = (String) map.get("name");
  String studentID = (String) map.get("studentID");
  String school = (String) map.get("school");
  String grade = (String) map.get("grade");
  String phone = (String) map.get("phone");
  String date = (String) map.get("date");
  String parentName = (String) map.get("parentName");
  String parentPhone = (String) map.get("parentPhone");
  String address = (String) map.get("address");
  String remark = (String) map.get("remark");

  Student stu = new Student(uuid,name, studentID, school, grade, phone, date, parentName, parentPhone, address, remark);
  return stu;
}// end method MapToStudent

}//end class T_DataMap2Bean
