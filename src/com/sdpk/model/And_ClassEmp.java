package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午5:14:44
 * 类说明
 */

public class And_ClassEmp {
  private String uuid;
  private String classUuid;
  private String className;
  private String empUuid;
  private String empName;
  
  public And_ClassEmp() {
    super();
  }

  public And_ClassEmp(String classUuid, String empUuid) {
    super();
    this.classUuid = classUuid;
    this.empUuid = empUuid;
  }

  @Override
  public String toString() {
    return "And_ClassEmp 开始[uuid=" + uuid + ", classUuid=" + classUuid + ", className=" + className
        + ", empUuid=" + empUuid + ", empName=" + empName + "]一条结束";
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getClassUuid() {
    return classUuid;
  }

  public void setClassUuid(String classUuid) {
    this.classUuid = classUuid;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
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
