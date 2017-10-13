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
import com.sdpk.model.Employee;
import com.sdpk.service.EmployeeService;
import com.sdpk.service.impl.EmployeeServiceImpl;

public class EmployeeControl extends HttpServlet {
  
  EmployeeService employeeService=new EmployeeServiceImpl();
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }// end doGet

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    Employee employee = json2emp(request);
    
    String qqiu=request.getParameter("qqiu");
    String back = qqiuTest(qqiu);
    qqiuChoice(qqiu,employee);
    
    out.write(back);
    out.flush();
    out.close();

  }// end doPost

  

  private Employee json2emp(HttpServletRequest request) {
    
    String str =  getRequestPayload(request);
    Map<String,Object> map = JsonStrToMap(str);
    Employee employee = MapToEmp(map);
    
    printMap(map);
    
    return employee;
  }

  private void qqiuChoice(String qqiu,Employee employee) {
    // TODO Auto-generated method stub
    
    boolean add = qqiu.equals("add");
    boolean delete = qqiu.equals("delete");
    boolean edit = qqiu.equals("edit");
    boolean list = qqiu.equals("list");
    if(add){
      String result = employeeService.insert(employee);
      System.out.println("插入的uuid是："+result);       
        System.out.println("完成添加方法 ");
    }
    
  }//end method qqiuChoice

  private String qqiuTest(String qqiu) {
      String back1 = "{\"id\":11,\"name\":\"zhagnsan\"}";
      System.out.println(back1);
      return back1;
  }



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
    
    System.out.println("传进control的json数据："+ sb.toString());
    return sb.toString();

  }// end method getRequestPayload 自己写的方法
  
  
  public Map<String,Object> JsonStrToMap (String jsonStr){
    
    Map<String,Object> map = new Gson().fromJson(jsonStr, new TypeToken<HashMap<String,Object>>(){}.getType());

    return map;
    
  }//end method JsonStrToMap
  
  public void printMap ( Map<String,Object> map){
    
    Map<String,Object> mapPri = map;
    System.out.println("打印!Emp表单map name的值是:"+mapPri.get("name"));
    System.out.println("打印!Emp表单map remark的值是:"+mapPri.get("remark"));
  }
  
  public Employee MapToEmp(Map<String,Object> map){
    
    String name = (String) map.get("name");
    String empNum = (String) map.get("empNum");
    String phone = (String) map.get("phone");
    String depart = (String) map.get("depart");
    String job = (String) map.get("job");
    String permissionTempl = (String) map.get("permissionTempl");
    String course = (String) map.get("course");
    String remark = (String) map.get("remark");
    
    Employee emp = new Employee(name, empNum, phone, depart, job, permissionTempl, course, remark);
    return emp;
  }//end method convert


}// end class EmployeeControl
