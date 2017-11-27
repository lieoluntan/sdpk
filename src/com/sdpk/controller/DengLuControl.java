package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sdpk.model.BackResult;
import com.sdpk.model.UserPK;
import com.sdpk.service.UserPKService;
import com.sdpk.service.impl.UserPKServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-24 下午3:35:17
 * 类说明
 */

public class DengLuControl extends HttpServlet {
  
//  DengLuService dengLuService = new DengLuServiceImpl();
  UserPKService userPKService = new UserPKServiceImpl();
  BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
  public M_msg m_msg = new M_msg();
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }// end doGet
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO doPost
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    // 1 获取url问号后面的Query 参数
    String qqiu = request.getParameter("qqiu");

    if (qqiu.equals("test") || qqiu.equals("denglu")  ) {
      // 2 将前台json数据字符串转成实体对象
      T_DataControl t_data = new T_DataControl();
      String str = t_data.getRequestPayload(request);
      UserPK userPK = new UserPK();
      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
        Map<String, Object> map = t_data.JsonStrToMap(str);
        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
        userPK = t_map2bean.MapToUserPK(map);
      } else {
        System.out.println("前台传入post请求体数据为空，请联系管理员！");
      }

      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, userPK,response);
    } else if (qqiu.equals("list")) {
      // TODO 待完成
     
    } else {
      System.out.println("qqiu请求参数  " + qqiu + "  不规范");
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
  
  private void qqiuChoice(String qqiu, UserPK userPK,HttpServletResponse response) {
    // TODO Auto-generated method stub
    boolean test = false;
    boolean denglu = false;

    test = qqiu.equals("test");
    denglu = qqiu.equals("denglu");

    if (test) {
      backResult.setMessage("信息值,测试成功");
      backResult.setQingqiu("test新增");
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("登录,测试成功1");
      resultList.add("登录,测试成功2");
      resultList.add("登录,测试成功3");
      backResult.setData(resultList);
    }
    
    if(denglu){
      boolean flag =  userPKService.judge(userPK);
      m_msg = userPKService.getMsg();
      backResult.setQingqiu("notyes");
      //步骤一：判断
      if(flag){
        
        String msg = "登录成功";
        System.out.println(msg);
        backResult.setQingqiu("yes");
//        try {
//          response.sendRedirect("xppu8.html");
//          
//          System.out.println("跳转成功");
//        } catch (IOException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace(); System.out.println("跳转失败,检查跳转");
//        } 
      }//用户名、密码正确
      else {
        String msg = "登录失败";
        System.out.println(msg);
        backResult.setQingqiu("notyes");
      }//用户名、密码错误
      
      //步骤二：赋值
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("初始值");
      backResult.setMessage("信息值："+m_msg.getGetOneMsg());
      backResult.setData(resultList);
    }//end denglu
    

  }// end method qqiuChoice

}//end class
