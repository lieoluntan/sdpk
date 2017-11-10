package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午5:24:03
 * 类说明
 */

public class And_ClassStu {
  private String uuid;
  private String classUuid;
  private String className;
  private String stuUuid;
  private String stuName;
  
  public And_ClassStu() {
    super();
  }

  public And_ClassStu(String uuid,String classUuid, String stuUuid) {
    super();
    this.uuid = uuid;
    this.classUuid = classUuid;
    this.stuUuid = stuUuid;
  }

  @Override
  public String toString() {
    return "And_ClassStu 开始[uuid=" + uuid + ", classUuid=" + classUuid + ", className=" + className
        + ", stuUuid=" + stuUuid + ", stuName=" + stuName + "]一条结束";
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

  public String getStuUuid() {
    return stuUuid;
  }

  public void setStuUuid(String stuUuid) {
    this.stuUuid = stuUuid;
  }

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }
  
  
  
  
}//end class
