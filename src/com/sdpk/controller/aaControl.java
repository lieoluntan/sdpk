package com.sdpk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class aaControl extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }// end doGet

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    String back = "{\"id\":11,\"name\":\"zhagnsan\"}";
    System.out.println(back);
    String str =  getRequestPayload(request);
    Map<String,Object> map = JsonStrToMap(str);
    printMap(map);

    out.write(back);
    out.flush();
    out.close();

  }// end doPost

  public String getRequestPayload(HttpServletRequest req) {

    StringBuilder sb = new StringBuilder();

    try {

      BufferedReader reader = req.getReader();

      char[] buff = new char[1024];

      int len;

      while ((len = reader.read(buff)) != -1) {

        sb.append(buff, 0, len);

      }

    } catch (IOException e) {

      e.printStackTrace();

    }
    
    System.out.println("传进control的json数据："+ sb.toString());
    return sb.toString();

  }// end getRequestPayload 自己写的方法
  
  
  public Map<String,Object> JsonStrToMap (String jsonStr){
    
    Map<String,Object> map = new Gson().fromJson(jsonStr, new TypeToken<HashMap<String,Object>>(){}.getType());

    return map;
    
  }
  
  public void printMap ( Map<String,Object> map){
    
    Map<String,Object> mapPri = map;
    System.out.println("打印!Emp表单map name的值是:"+mapPri.get("name"));
    System.out.println("打印!Emp表单map remark的值是:"+mapPri.get("remark"));
  }

}// end aaControl
