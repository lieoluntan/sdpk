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
import com.sdpk.model.And_ClassCourse;
import com.sdpk.model.BackResult;
import com.sdpk.model.Course_Emp;
import com.sdpk.service.Course_EmpService;
import com.sdpk.service.impl.Course_EmpServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-10 下午5:51:01
 * 类说明
 */

public class Course_EmpControl extends HttpServlet {
  
  Course_EmpService course_EmpService = new Course_EmpServiceImpl();
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
    String courseUuid = request.getParameter("courseUuid");

    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
        || qqiu.equals("getOne") || qqiu.equals("deleteByCour")|| qqiu.equals("getListByEmp")) {
      // 2 将前台json数据字符串转成实体对象
      T_DataControl t_data = new T_DataControl();
      String str = t_data.getRequestPayload(request); //固定，基本不改
      Course_Emp course_Emp = new Course_Emp();//(根据实体类改)
      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
        Map<String, Object> map = t_data.JsonStrToMap(str); //固定，基本不改
        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
        course_Emp = t_map2bean.MapToCourse_Emp(map); //(根据实体类改)
      } else {
        System.out.println("前台传入post请求体数据为空，请联系管理员！");
      }

      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, course_Emp);
    } else if (qqiu.equals("getListByCour")) {
      // TODO 待完成
      ArrayList<Course_Emp> resultList = course_EmpService.getListByCour(courseUuid);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getListByCour课程员工查询单条记录");
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
  
  private void qqiuChoice(String qqiu, Course_Emp course_Emp) {
    // TODO Auto-generated method stub
    boolean test = false;
    boolean add = false;
    boolean delete = false;
    boolean edit = false;
    boolean getOne = false;
    boolean deleteByCour = false;
    boolean getListByEmp = false;
    boolean getListByCour = false;

    test = qqiu.equals("test");
    add = qqiu.equals("add");
    delete = qqiu.equals("delete");
    edit = qqiu.equals("edit");
    getOne = qqiu.equals("getOne");
    deleteByCour = qqiu.equals("deleteByCour");
    getListByCour = qqiu.equals("getListByCour");
    getListByEmp = qqiu.equals("getListByEmp");
    

    if (test) {
      backResult.setMessage("信息值,测试成功");
      backResult.setQingqiu("test新增");
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("Course_Emp内容值,测试成功1");
      resultList.add("Course_Emp内容值,测试成功2");
      resultList.add("Course_Emp内容值,测试成功3");
      backResult.setData(resultList);
    }
    if (add) {
      String result = course_EmpService.insert(course_Emp);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      m_msg = course_EmpService.getMsg();
      backResult.setMessage("信息值  "+m_msg.getAddMsg());
      backResult.setQingqiu("add新增");
      backResult.setData(resultList);
      m_msg.cleanMsg();
    }
    if (delete) {
      String result = course_EmpService.delete(course_Emp.getUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + course_Emp.getUuid());
      backResult.setData(resultList);
    }
    if (deleteByCour) {
      String result = course_EmpService.deleteByCour(course_Emp.getCourseUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + course_Emp.getUuid());
      backResult.setData(resultList);
    }
    if(getListByCour){
      
    }
    if(getListByEmp){
      ArrayList<Course_Emp> resultList = course_EmpService.getListByEmp(course_Emp.getEmpUuid());
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
      backResult.setData(resultList);
    }
  }// end method qqiuChoice

}//end class
