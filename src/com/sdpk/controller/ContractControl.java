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
import com.sdpk.model.Student;
import com.sdpk.service.ContractService;
import com.sdpk.service.impl.ContractServiceImpl;
import com.sdpk.utility.T_DataControl;
import com.sdpk.utility.T_DataMap2Bean;

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
    // TODO doPost
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();

    // 1 获取url问号后面的Query 参数
    String qqiu = request.getParameter("qqiu");

    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
        || qqiu.equals("getOne")) {
      // 2 将前台json数据字符串转成实体对象
      T_DataControl t_data = new T_DataControl();
      String str = t_data.getRequestPayload(request);//固定，不用改
      Contract contract = new Contract();
      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
        Map<String, Object> map = t_data.JsonStrToMap(str);//固定，不用改
        T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
        contract = t_map2bean.MapToContract(map);
      } else {
        System.out.println("前台传入post请求体数据为空，请联系管理员！");
      }

      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, contract);
    } else if (qqiu.equals("list")) {
      // TODO 待完成
      ArrayList<Contract> resultList = contractService.getList();
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("list查询列表");
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
  
  
  private void qqiuChoice(String qqiu, Contract contract) {
    // TODO Auto-generated method stub
    boolean test = false;
    boolean add = false;
    boolean delete = false;
    boolean edit = false;
    boolean getOne = false;

    test = qqiu.equals("test");
    add = qqiu.equals("add");
    delete = qqiu.equals("delete");
    edit = qqiu.equals("edit");
    getOne = qqiu.equals("getOne");

    if (test) {
      backResult.setMessage("信息值,测试成功");
      backResult.setQingqiu("test新增");
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("(合同)内容值,测试成功1");
      resultList.add("(合同)内容值,测试成功2");
      resultList.add("(合同)内容值,测试成功3");
      backResult.setData(resultList);
    }
    if (add) {
      String result = contractService.insert(contract);
      System.out.println("插入的uuid是：" + result);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：插入的uuid是"+result);
      backResult.setQingqiu("add新增");
      backResult.setData(resultList);
    }
    if (delete) {
      String result = contractService.delete(contract.getUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + contract.getUuid());
      backResult.setData(resultList);
    }
    if (edit) {
      String result = contractService.update(contract);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("edit修改"+result);
      backResult.setData(resultList);
    }
    if(getOne){
      Contract result = contractService.getByUuid(contract.getUuid());
      ArrayList<Contract> resultList = new ArrayList<Contract>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
      backResult.setData(resultList);
    }
    
        
  }// end method qqiuChoice

}//end class ContractControl
