package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-26 下午12:28:39
 * 类说明
 */

public class WeekDay {
  
  private boolean one;          //星期一
  private boolean two;          //星期二
  private boolean three;        //星期三
  private boolean four;         //星期四
  private boolean five;         //星期五
  private boolean six;          //星期六
  private boolean seven;        //星期日
  
  public WeekDay(){}
  
  public WeekDay(boolean one, boolean two, boolean three, boolean four, boolean five, boolean six,
      boolean seven) {
    super();
    this.one = one;
    this.two = two;
    this.three = three;
    this.four = four;
    this.five = five;
    this.six = six;
    this.seven = seven;
  }
  public boolean isOne() {
    return one;
  }
  public void setOne(boolean one) {
    this.one = one;
  }
  public boolean isTwo() {
    return two;
  }
  public void setTwo(boolean two) {
    this.two = two;
  }
  public boolean isThree() {
    return three;
  }
  public void setThree(boolean three) {
    this.three = three;
  }
  public boolean isFour() {
    return four;
  }
  public void setFour(boolean four) {
    this.four = four;
  }
  public boolean isFive() {
    return five;
  }
  public void setFive(boolean five) {
    this.five = five;
  }
  public boolean isSix() {
    return six;
  }
  public void setSix(boolean six) {
    this.six = six;
  }
  public boolean isSeven() {
    return seven;
  }
  public void setSeven(boolean seven) {
    this.seven = seven;
  }
  
  

}//end class WeekDay
