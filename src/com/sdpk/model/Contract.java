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

  private String cNum; // 合同编号
  private String stuUuid; // 学生uuid
  private String cDate; // 交易时间
  private String org; // 校区组织
  private String totalCount; // 总上课次数
  private String totalPrice; // 总支付金额

  private String onePriceA; // 课程单价A
  private String countA; // 课程数量A
  private String delPriceA; // 优惠金额A
  private String countGiveA; // 送课次数A
  private String sumCountA; // 价格A上课次数
  private String sumPriceA; // 价格A支付金额

  private String onePriceB; // 课程单价B
  private String countB; // 课程数量B
  private String delPriceB; // 优惠金额B
  private String countGiveB; // 送课次数B
  private String sumCountB; // 价格B上课次数
  private String sumPriceB; // 价格B支付金额

  public Contract() {
  }

  public Contract(String uuid, String cNum, String stuUuid, String cDate, String org,
      String totalCount, String totalPrice, String onePriceA, String countA, String delPriceA,
      String countGiveA, String sumCountA, String sumPriceA, String onePriceB, String countB,
      String delPriceB, String countGiveB, String sumCountB, String sumPriceB) {
    super();
    this.uuid = uuid;
    this.cNum = cNum;
    this.stuUuid = stuUuid;
    this.cDate = cDate;
    this.org = org;
    this.totalCount = totalCount;
    this.totalPrice = totalPrice;
    this.onePriceA = onePriceA;
    this.countA = countA;
    this.delPriceA = delPriceA;
    this.countGiveA = countGiveA;
    this.sumCountA = sumCountA;
    this.sumPriceA = sumPriceA;
    this.onePriceB = onePriceB;
    this.countB = countB;
    this.delPriceB = delPriceB;
    this.countGiveB = countGiveB;
    this.sumCountB = sumCountB;
    this.sumPriceB = sumPriceB;
  }

  @Override
  public String toString() {
    return "合同toString方法Contract [uuid=" + uuid + ", createDate=" + createDate + ", modifyDate=" + modifyDate
        + ", createPeople=" + createPeople + ", modifyPeople=" + modifyPeople + ", cNum=" + cNum
        + ", stuUuid=" + stuUuid + ", cDate=" + cDate + ", org=" + org + ", totalCount="
        + totalCount + ", totalPrice=" + totalPrice + ", onePriceA=" + onePriceA + ", countA="
        + countA + ", delPriceA=" + delPriceA + ", countGiveA=" + countGiveA + ", sumCountA="
        + sumCountA + ", sumPriceA=" + sumPriceA + ", onePriceB=" + onePriceB + ", countB="
        + countB + ", delPriceB=" + delPriceB + ", countGiveB=" + countGiveB + ", sumCountB="
        + sumCountB + ", sumPriceB=" + sumPriceB + "]结束!";
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

  public String getcNum() {
    return cNum;
  }

  public void setcNum(String cNum) {
    this.cNum = cNum;
  }

  public String getStuUuid() {
    return stuUuid;
  }

  public void setStuUuid(String stuUuid) {
    this.stuUuid = stuUuid;
  }

  public String getcDate() {
    return cDate;
  }

  public void setcDate(String cDate) {
    this.cDate = cDate;
  }

  public String getOrg() {
    return org;
  }

  public void setOrg(String org) {
    this.org = org;
  }

  public String getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(String totalCount) {
    this.totalCount = totalCount;
  }

  public String getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(String totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getOnePriceA() {
    return onePriceA;
  }

  public void setOnePriceA(String onePriceA) {
    this.onePriceA = onePriceA;
  }

  public String getCountA() {
    return countA;
  }

  public void setCountA(String countA) {
    this.countA = countA;
  }

  public String getDelPriceA() {
    return delPriceA;
  }

  public void setDelPriceA(String delPriceA) {
    this.delPriceA = delPriceA;
  }

  public String getCountGiveA() {
    return countGiveA;
  }

  public void setCountGiveA(String countGiveA) {
    this.countGiveA = countGiveA;
  }

  public String getSumCountA() {
    return sumCountA;
  }

  public void setSumCountA(String sumCountA) {
    this.sumCountA = sumCountA;
  }

  public String getSumPriceA() {
    return sumPriceA;
  }

  public void setSumPriceA(String sumPriceA) {
    this.sumPriceA = sumPriceA;
  }

  public String getOnePriceB() {
    return onePriceB;
  }

  public void setOnePriceB(String onePriceB) {
    this.onePriceB = onePriceB;
  }

  public String getCountB() {
    return countB;
  }

  public void setCountB(String countB) {
    this.countB = countB;
  }

  public String getDelPriceB() {
    return delPriceB;
  }

  public void setDelPriceB(String delPriceB) {
    this.delPriceB = delPriceB;
  }

  public String getCountGiveB() {
    return countGiveB;
  }

  public void setCountGiveB(String countGiveB) {
    this.countGiveB = countGiveB;
  }

  public String getSumCountB() {
    return sumCountB;
  }

  public void setSumCountB(String sumCountB) {
    this.sumCountB = sumCountB;
  }

  public String getSumPriceB() {
    return sumPriceB;
  }

  public void setSumPriceB(String sumPriceB) {
    this.sumPriceB = sumPriceB;
  }
  
  
  
  

}// end class Contract
