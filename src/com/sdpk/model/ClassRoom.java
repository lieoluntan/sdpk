package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-23 下午5:22:17
 * 类说明
 */

public class ClassRoom {
  
  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  //教室名字
  private String name;
  //校区
  private String campus;
  //备注
  private String remark;
  
  public ClassRoom() {
  }
  
  public ClassRoom(String uuid,String name,String campus,String remark) {
    this.uuid = uuid;
    this.name = name;
    this.campus = campus;
    this.remark = remark; 
  }//end method ClassRoom
  
  @Override
  public String toString() {
    return "教室 [uuid=" + uuid + ", name=" + name + ", campus=" + campus +  ", remark="
        + remark + "]";
  }//end method toString

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
  
}//end class ClassRoom
