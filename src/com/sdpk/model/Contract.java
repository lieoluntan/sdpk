package com.sdpk.model;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午5:05:46 类说明
 */

public class Contract {

  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  private String oddNum;
  private String stuUuid;
  private String campus;
  private String account;
  private String operator;
  private String fee;
  private String feeType;
  private String feeMode;
  private String itemName;
  private String amount;

  public Contract() {
  }

  public Contract(String uuid, String oddNum, String stuUuid, String campus, String account,
      String operator, String fee, String feeType, String feeMode, String itemName, String amount) {
    this.uuid = uuid;
    this.oddNum = oddNum;
    this.stuUuid = stuUuid;
    this.campus = campus;
    this.account = account;
    this.operator = operator;
    this.fee = fee;
    this.feeType = feeType;
    this.feeMode = feeMode;
    this.itemName = itemName;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "合同 [uuid=" + uuid + ", oddNum=" + oddNum + ", stuUuid=" + stuUuid + ", campus="
        + campus + ", account=" + account + ", operator=" + operator + ", fee=" + fee
        + ", feeType=" + feeType + ", feeMode=" + feeMode + ", itemName=" + itemName + ", amount="
        + amount + "]";
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

  public String getOddNum() {
    return oddNum;
  }

  public void setOddNum(String oddNum) {
    this.oddNum = oddNum;
  }

  public String getStuUuid() {
    return stuUuid;
  }

  public void setStuUuid(String stuUuid) {
    this.stuUuid = stuUuid;
  }

  public String getCampus() {
    return campus;
  }

  public void setCampus(String campus) {
    this.campus = campus;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public String getFee() {
    return fee;
  }

  public void setFee(String fee) {
    this.fee = fee;
  }

  public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public String getFeeMode() {
    return feeMode;
  }

  public void setFeeMode(String feeMode) {
    this.feeMode = feeMode;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

}// end class Contract
