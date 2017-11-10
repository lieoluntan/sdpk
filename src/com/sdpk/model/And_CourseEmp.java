package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午5:32:52
 * 类说明
 */

public class And_CourseEmp {
  
  private String uuid;
  private String courseUuid;
  private String courseName;
  private String empUuid;
  private String empName;
  
  
  public And_CourseEmp() {
    super();
  }


  public And_CourseEmp(String courseUuid, String empUuid) {
    super();
    this.courseUuid = courseUuid;
    this.empUuid = empUuid;
  }


  @Override
  public String toString() {
    return "And_CourseEmp 开始[uuid=" + uuid + ", courseUuid=" + courseUuid + ", courseName="
        + courseName + ", empUuid=" + empUuid + ", empName=" + empName + "]一条结束";
  }


  public String getUuid() {
    return uuid;
  }


  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public String getCourseUuid() {
    return courseUuid;
  }


  public void setCourseUuid(String courseUuid) {
    this.courseUuid = courseUuid;
  }


  public String getCourseName() {
    return courseName;
  }


  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }


  public String getEmpUuid() {
    return empUuid;
  }


  public void setEmpUuid(String empUuid) {
    this.empUuid = empUuid;
  }


  public String getEmpName() {
    return empName;
  }


  public void setEmpName(String empName) {
    this.empName = empName;
  }
  
  
  
  

}//end class
