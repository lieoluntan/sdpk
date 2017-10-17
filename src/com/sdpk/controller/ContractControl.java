package com.sdpk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sdpk.model.BackResult;
import com.sdpk.model.Contract;
import com.sdpk.service.ContractService;
import com.sdpk.service.impl.ContractServiceImpl;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-10-16 下午4:59:16
 * 类说明
 */

public class ContractControl extends HttpServlet  {
  
  ContractService contractService = new ContractServiceImpl();
  BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }// end doGet

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //TODO doPost
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    // 1 获取url问号后面的Query 参数
    String qqiu = request.getParameter("qqiu");

    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")) {
      // 2 将前台json数据转成实体对象
      Contract contract = json2contract(request);
      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, contract);
    } else if (qqiu.equals("list")) {
      
    }

    Gson gson = new Gson();
    // 4 执行完qqiuChoice里面操作后的全局返回值backResult对象,转成json格式
    String back = gson.toJson(backResult);
    System.out.println("最后back值是：" + back);
    // 5 将json格式的back传给前台
    out.write(back);
    out.flush();
    out.close();

  }// end method doPost 主入口
  
  private Contract json2contract(HttpServletRequest request) {

    String str = getRequestPayload(request);
    
    if(str!=null&&str!=""&& str.length()!=0){           //非空判断，防止前台传空报500服务器错误中的空指针
    Map<String, Object> map = JsonStrToMap(str);
    Contract contract = MapToContract(map);
    return contract;
    }else {
      System.out.println("前台传入post总参数数据为空，请联系管理员！");
      return new Contract();
    }
    

  }// end method json2course
  
//自己写的方法，用于获取HttpServletRequest req参数主体
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

   System.out.println("传进control的json数据：" + sb.toString());
   return sb.toString();

 }// end method getRequestPayload 自己写的方法
 
 public Map<String, Object> JsonStrToMap(String jsonStr) {

   Map<String, Object> map = new Gson().fromJson(jsonStr,
       new TypeToken<HashMap<String, Object>>() {
       }.getType());

   return map;

 }// end method JsonStrToMap
 
 public Contract MapToContract(Map<String, Object> map) {

   String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
   String oddNum = (String) map.get("oddNum");
   String stuUuid = (String) map.get("stuUuid");
   String campus = (String) map.get("campus");
   String account = (String) map.get("account");
   String operator = (String) map.get("operator");
   String fee = (String) map.get("fee");
   String feeType = (String) map.get("feeType");
   String feeMode = (String) map.get("feeMode");
   String itemName = (String) map.get("itemName");
   String amount = (String) map.get("amount");

   Contract contract = new Contract(uuid, oddNum, stuUuid, campus,account, operator, fee, feeType, feeMode, itemName, amount);
   return contract;
 }// end method MapToEmp
 
 
 private void qqiuChoice(String qqiu, Contract contract) {
   // TODO Auto-generated method stub
   boolean test = false;
   boolean add = false;
   boolean delete = false;
   boolean edit = false;

   test = qqiu.equals("test");
   add = qqiu.equals("add");
   delete = qqiu.equals("delete");
   edit = qqiu.equals("edit");

   if (test) {
     backResult.setMessage("信息值,测试成功");
     backResult.setQingqiu("test新增");
     ArrayList<String> resultList = new ArrayList<String>();
     resultList.add("内容值,测试成功1");
     resultList.add("内容值,测试成功2");
     resultList.add("内容值,测试成功3");
     backResult.setContent(resultList);
   }
   if (add) {
//     String result = courseService.insert(course);
//     System.out.println("插入的uuid是：" + result);
     ArrayList<String> resultList = new ArrayList<String>();
//     resultList.add(result);
     backResult.setMessage("信息值：成功");
     backResult.setQingqiu("add新增");
     backResult.setContent(resultList);
   }
   

 }// end method qqiuChoice

}//end class ContractControl
