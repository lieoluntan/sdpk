package com.sdpk.model;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-27 下午1:37:22 类说明
 * 
 *          名称:班级
 */

public class Cla {

  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  
  private String name;
  private String empUuid;
  private String classDate;
  private String status;
  private String remark;
  
  private String org;

  public Cla() {
    super();
  }

  public Cla(String uuid, String org, String name, String empUuid, String classDate, String status,
      String remark) {
    super();
    this.uuid = uuid;
    this.org = org;
    this.name = name;
    this.empUuid = empUuid;
    this.classDate = classDate;
    this.status = status;
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "班级 [uuid=" + uuid + ", name=" + name + ", empUuid=" + empUuid + ", classDate="
        + classDate + ", status=" + status + ", remark=" + remark + "]结束";
  }// end method toString

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(String modifyDate) {
    this.modifyDate = modifyDate;
  }

  public String getCreatePeople() {
    return createPeople;
  }

  public void setCreatePeople(String createPeople) {
    this.createPeople = createPeople;
  }

  public String getModifyPeople() {
    return modifyPeople;
  }

  public void setModifyPeople(String modifyPeople) {
    this.modifyPeople = modifyPeople;
  }

  public String getOrg() {
    return org;
  }

  public void setOrg(String org) {
    this.org = org;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmpUuid() {
    return empUuid;
  }

  public void setEmpUuid(String empUuid) {
    this.empUuid = empUuid;
  }

  public String getClassDate() {
    return classDate;
  }

  public void setClassDate(String classDate) {
    this.classDate = classDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}// end class Cla
