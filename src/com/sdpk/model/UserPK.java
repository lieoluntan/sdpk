package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 上午11:42:20
 * 类说明
 */

public class UserPK {
  
  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  
  private String uLogUser;
  private String uPassWord;
  private String uName;
  
  public UserPK() {
    super();
  }

  public UserPK(String uuid, String uLogUser, String uPassWord, String uName) {
    super();
    this.uuid = uuid;
    this.uLogUser = uLogUser;
    this.uPassWord = uPassWord;
    this.uName = uName;
  }

  @Override
  public String toString() {
    return "userPK 开始[uuid=" + uuid + ", uLogUser=" + uLogUser + ", uPassWord=" + uPassWord
        + ", uName=" + uName + "]结束";
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

  public String getuLogUser() {
    return uLogUser;
  }

  public void setuLogUser(String uLogUser) {
    this.uLogUser = uLogUser;
  }

  public String getuPassWord() {
    return uPassWord;
  }

  public void setuPassWord(String uPassWord) {
    this.uPassWord = uPassWord;
  }

  public String getuName() {
    return uName;
  }

  public void setuName(String uName) {
    this.uName = uName;
  }
  


}//end class 
