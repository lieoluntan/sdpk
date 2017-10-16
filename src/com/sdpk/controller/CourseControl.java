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
import com.sdpk.model.Course;
import com.sdpk.service.CourseService;
import com.sdpk.service.impl.CourseServiceImpl;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-15 下午3:08:15 类说明
 */

public class CourseControl extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 5511435384872150125L;

  CourseService courseService = new CourseServiceImpl();
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
      Course course = json2course(request);
      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, course);
    } else if (qqiu.equals("list")) {
      ArrayList<Course> resultList = courseService.getListCourse();
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("list查询列表");
      backResult.setContent(resultList);
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

  private Course json2course(HttpServletRequest request) {

    String str = getRequestPayload(request);
    Map<String, Object> map = JsonStrToMap(str);
    Course course = MapToCourse(map);

    printMap(map);

    return course;
  }// end method json2course

  private void qqiuChoice(String qqiu, Course course) {
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
      String result = courseService.insert(course);
      System.out.println("插入的uuid是：" + result);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("add新增");
      backResult.setContent(resultList);
    }
    if (delete) {
      String result = courseService.delete(course.getUuid());
      System.out.println("删除的uuid是：" + result);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + course.getUuid());
      backResult.setContent(resultList);
    }
    if (edit) {
      String result = courseService.update(course);
      System.out.println("修改的uuid是：" + result);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("edit修改");
      backResult.setContent(resultList);
    }

  }// end method qqiuChoice

  // 自己写的方法，用于获取HttpServletRequest req参数主体
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

  public void printMap(Map<String, Object> map) {

    Map<String, Object> mapPri = map;
    System.out.println("打印!Emp表单map name的值是:" + mapPri.get("name"));
    System.out.println("打印!Emp表单map remark的值是:" + mapPri.get("remark"));
  }

  public Course MapToCourse(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String name = (String) map.get("name");
    String category = (String) map.get("category");
    String describe = (String) map.get("describe");

    Course course = new Course(uuid, name, category, describe);
    return course;
  }// end method MapToEmp

}// end class CourseControl
