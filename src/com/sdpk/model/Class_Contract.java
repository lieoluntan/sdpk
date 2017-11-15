package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-15 下午3:22:19
 * 类说明
 */

public class Class_Contract {
  
  private String uuid;
  private String classUuid;
  private String className;
  private String contrUuid;
  private String contrName;
  
  public Class_Contract() {
    super();
  }

  public Class_Contract(String uuid, String classUuid, String contrUuid) {
    super();
    this.uuid = uuid;
    this.classUuid = classUuid;
    this.contrUuid = contrUuid;
  }
  
  

  @Override
  public String toString() {
    return "Class_Contract 开始[uuid=" + uuid + ", classUuid=" + classUuid + ", className=" + className
        + ", contrUuid=" + contrUuid + ", contrName=" + contrName + "]结束";
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

  public String getContrUuid() {
    return contrUuid;
  }

  public void setContrUuid(String contrUuid) {
    this.contrUuid = contrUuid;
  }

  public String getContrName() {
    return contrName;
  }

  public void setContrName(String contrName) {
    this.contrName = contrName;
  }

  


}//end class
