package com.sdpk.model;

public class Course {
  
  
  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;
  
  private String name;
  private String category;
  private String describe;
  
  public Course(){}
  
  public Course(String uuid,String name, String category, String describe) {
    // TODO Auto-generated constructor stub
    this.uuid = uuid;
    this.name = name;
    this.category = category;
    this.describe = describe;
  }
  
  @Override
  public String toString() {
    return "课程 [uuid=" + uuid + ", name=" + name + ", category=" + category + ", describe=" + describe + 

        "]";
  }

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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }
  
  
  

}//end class Course
