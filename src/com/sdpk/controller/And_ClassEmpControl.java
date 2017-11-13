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
import com.sdpk.model.And_ClassEmp;
import com.sdpk.model.BackResult;
import com.sdpk.model.Cla;
import com.sdpk.service.And_ClassEmpService;
import com.sdpk.service.impl.And_ClassEmpServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午6:02:25
 * 类说明
 */

public class And_ClassEmpControl extends HttpServlet {
  
  And_ClassEmpService and_ClassEmpService = new And_ClassEmpServiceImpl();
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
    String classUuid = request.getParameter("classUuid");

    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
        || qqiu.equals("getOne") || qqiu.equals("deleteBycla")|| qqiu.equals("getListByEmp")) {
      // 2 将前台json数据字符串转成实体对象
      T_DataControl t_data = new T_DataControl();
      String str = t_data.getRequestPayload(request); //固定，基本不改
      And_ClassEmp and_ClassEmp = new And_ClassEmp(); //(根据实体类改)
      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
        Map<String, Object> map = t_data.JsonStrToMap(str); //固定，基本不改
        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
        and_ClassEmp = t_map2bean.MapToAnd_ClassEmp(map); //(根据实体类改)
      } else {
        System.out.println("前台传入post请求体数据为空，请联系管理员！");
      }

      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, and_ClassEmp);
    } else if (qqiu.equals("getListBycla")) {
      // TODO 待完成
      ArrayList<And_ClassEmp> resultList = and_ClassEmpService.getListBycla(classUuid);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getListBycla查询记录");
      backResult.setData(resultList);

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
  
  private void qqiuChoice(String qqiu, And_ClassEmp and_ClassEmp) {
    // TODO Auto-generated method stub
    boolean test = false;
    boolean add = false;
    boolean delete = false;
    boolean edit = false;
    boolean getOne = false;
    boolean deleteBycla = false;
    boolean getListBycla = false;
    boolean getListByEmp = false;

    test = qqiu.equals("test");
    add = qqiu.equals("add");
    delete = qqiu.equals("delete");
    edit = qqiu.equals("edit");
    getOne = qqiu.equals("getOne");
    deleteBycla = qqiu.equals("deleteBycla");
    getListBycla = qqiu.equals("getListBycla");
    getListByEmp = qqiu.equals("getListByEmp");
    

    if (test) {
      backResult.setMessage("信息值,测试成功");
      backResult.setQingqiu("test新增");
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("And_ClassEmp内容值,测试成功1");
      resultList.add("And_ClassEmp内容值,测试成功2");
      resultList.add("And_ClassEmp内容值,测试成功3");
      backResult.setData(resultList);
    }
    if (add) {
      String result = and_ClassEmpService.insert(and_ClassEmp);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      m_msg = and_ClassEmpService.getMsg();
      backResult.setMessage("信息值  "+m_msg.getAddMsg());
      backResult.setQingqiu("add新增");
      backResult.setData(resultList);
      m_msg.cleanMsg();
    }
    if (delete) {
      String result = and_ClassEmpService.delete(and_ClassEmp.getUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + and_ClassEmp.getUuid());
      backResult.setData(resultList);
    }
    if (deleteBycla) {
      String result = and_ClassEmpService.deleteBycla(and_ClassEmp.getClassUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + and_ClassEmp.getUuid());
      backResult.setData(resultList);
    }
    if(getListBycla){
      ArrayList<And_ClassEmp> resultList = and_ClassEmpService.getListBycla(and_ClassEmp.getClassUuid());
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
      backResult.setData(resultList);
    }
    if(getListByEmp){
      ArrayList<And_ClassEmp> resultList = and_ClassEmpService.getListByEmp(and_ClassEmp.getEmpUuid());
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
      backResult.setData(resultList);
    }
    
  }// end method qqiuChoice

}//end class And_ClassEmpControl
