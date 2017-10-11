package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdpk.model.Student;
import com.sdpk.service.impl.StudentServiceImpl;

public class StudentControl extends HttpServlet {

  StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    this.doPost(request, response);
  }// end doGet

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    
    String back = "{\"id\":11bb,\"name\":\"zhagnsanBB\"}";
    Student stu = convert(request);
    System.out.println("^^在control收到数据 ："+stu.toString()+"收到结束!");
    String result = studentServiceImpl.insert(stu);
    System.out.println("插入的uuid是："+result);
    out.write(back);
    out.flush();
    out.close();

  }//end doPost
  
  public Student convert(HttpServletRequest request){
    String name = request.getParameter("name");
    String studentID = request.getParameter("studentID");
    String school = request.getParameter("school");
    String grade = request.getParameter("grade");
    String phone = request.getParameter("phone");
    String date = request.getParameter("date");
    String parentName = request.getParameter("parentName");
    String parentPhone = request.getParameter("parentPhone");
    String address = request.getParameter("address");
    String remark = request.getParameter("remark");
    
    Student stu = new Student(name, studentID, school, grade, phone, date, parentName, parentPhone, address, remark);
    return stu;
  }

}// end aaControl
