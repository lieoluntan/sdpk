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
import com.sdpk.model.And_ClassStu;
import com.sdpk.model.BackResult;
import com.sdpk.service.And_ClassStuService;
import com.sdpk.service.impl.And_ClassStuServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午1:24:53
 * 类说明
 */

public class And_ClassStuControl extends HttpServlet {
  
  And_ClassStuService and_ClassStuService = new And_ClassStuServiceImpl();
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
        || qqiu.equals("getOne") || qqiu.equals("deleteBycla")|| qqiu.equals("getListByStu")) {
      // 2 将前台json数据字符串转成实体对象
      T_DataControl t_data = new T_DataControl();
      String str = t_data.getRequestPayload(request); //固定，基本不改
      And_ClassStu and_ClassStu = new And_ClassStu();//(根据实体类改)
      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
        Map<String, Object> map = t_data.JsonStrToMap(str); //固定，基本不改
        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
        and_ClassStu = t_map2bean.MapToAnd_ClassStu(map); //(根据实体类改)
      } else {
        System.out.println("前台传入post请求体数据为空，请联系管理员！");
      }

      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, and_ClassStu);
    } else if (qqiu.equals("getListBycla")) {
      // TODO 待完成
      ArrayList<And_ClassStu> resultList = and_ClassStuService.getListBycla(classUuid);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
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
  
  private void qqiuChoice(String qqiu, And_ClassStu and_ClassStu) {
    // TODO Auto-generated method stub
    boolean test = false;
    boolean add = false;
    boolean delete = false;
    boolean edit = false;
    boolean getOne = false;
    boolean deleteBycla = false;
    boolean getListByEmp = false;
    boolean getListByStu = false;

    test = qqiu.equals("test");
    add = qqiu.equals("add");
    delete = qqiu.equals("delete");
    edit = qqiu.equals("edit");
    getOne = qqiu.equals("getOne");
    deleteBycla = qqiu.equals("deleteBycla");
    getListByEmp = qqiu.equals("getListByEmp");
    getListByStu = qqiu.equals("getListByStu");
    

    if (test) {
      backResult.setMessage("信息值,测试成功");
      backResult.setQingqiu("test新增");
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("And_ClassStu内容值,测试成功1");
      resultList.add("And_ClassStu内容值,测试成功2");
      resultList.add("And_ClassStu内容值,测试成功3");
      backResult.setData(resultList);
    }
    if (add) {
      String result = and_ClassStuService.insert(and_ClassStu);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      m_msg = and_ClassStuService.getMsg();
      backResult.setMessage("信息值  "+m_msg.getAddMsg());
      backResult.setQingqiu("add新增");
      backResult.setData(resultList);
      m_msg.cleanMsg();
    }
    if (delete) {
      String result = and_ClassStuService.delete(and_ClassStu.getUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + and_ClassStu.getUuid());
      backResult.setData(resultList);
    }
    if (deleteBycla) {
      String result = and_ClassStuService.deleteBycla(and_ClassStu.getClassUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + and_ClassStu.getUuid());
      backResult.setData(resultList);
    }
    
    if(getListByStu){
      ArrayList<And_ClassStu> resultList = and_ClassStuService.getListByStu(and_ClassStu.getStuUuid());
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
      backResult.setData(resultList);
    }
    
    
  }// end method qqiuChoice

}// end class And_ClassStuControl
