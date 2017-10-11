package com.sdpk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.sdpk.model.User;

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
    
    out.write(back);
    out.flush();
    out.close();

  }//end doPost

}// end aaControl
