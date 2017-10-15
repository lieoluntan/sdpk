package com.sdpk.model;

import java.util.ArrayList;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-13 下午7:42:55
 * 类说明
 */

public class BackResult {
  
  String message;
  String qingqiu;
  public String getQingqiu() {
    return qingqiu;
  }

  public void setQingqiu(String qingqiu) {
    this.qingqiu = qingqiu;
  }
  ArrayList<?> content;
  
  public BackResult(){}
  
  public BackResult(String message,String qingqiu,ArrayList<?> content){
    
    this.message = message;
    this.qingqiu = qingqiu;
    this.content = content;
  }
  
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public ArrayList<?> getContent() {
    return content;
  }
  public void setContent(ArrayList<?> content) {
    this.content = content;
  }
  

}
