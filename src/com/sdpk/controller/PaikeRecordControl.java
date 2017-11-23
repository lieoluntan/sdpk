package com.sdpk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sdpk.model.BackResult;
import com.sdpk.model.Contract;
import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordPre;
import com.sdpk.model.WeekDay;
import com.sdpk.service.PaikeRecordService;
import com.sdpk.service.impl.PaikeRecordServiceImpl;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.T_DataControl;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午9:48:03 类说明
 */

public class PaikeRecordControl extends HttpServlet {

  PaikeRecordService paikeRecordService = new PaikeRecordServiceImpl();
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

    if (qqiu.equals("test") || qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
        || qqiu.equals("getOne") || qqiu.equals("queryConflict") || qqiu.equals("listcla")) {
      // 2 将前台json数据转成实体对象
      PaikeRecord paikeRecord = json2PaikeRecord(request);
      // 3 执行qqiu里面的增或删或改或查 的操作
      qqiuChoice(qqiu, paikeRecord);
    } else if (qqiu.equals("list")) {
      ArrayList<PaikeRecord> resultList = paikeRecordService.getList();
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("list查询列表");
      backResult.setData(resultList);
    } else if (qqiu.equals("conflictList")) {
      // TODO
      // start前台数据转换
      // 拿到本地JSON 并转成String
      String str = getRequestPayload(request);
      // Json的解析类对象
      JsonParser parser = new JsonParser();
      // 将JSON的String 转成一个JsonArray对象
      JsonArray jsonArray = parser.parse(str).getAsJsonArray();

      Gson gson = new Gson();
      ArrayList<PaikeRecord> pr_List = new ArrayList<PaikeRecord>();

      // 加强for循环遍历JsonArray
      for (JsonElement user : jsonArray) {
        // 使用GSON，直接转成Bean对象
        PaikeRecord userBean = gson.fromJson(user, PaikeRecord.class);
        pr_List.add(userBean);
      }
      System.out.println(pr_List + "数组转换出来的列表数据!!!!!");
      // mainLView.setAdapter(new UserAdapter(this, userBeanList));
      // end前台数据转换
      ArrayList<PaikeRecord> resultList = paikeRecordService.selectConflict_batch(pr_List);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("list查询列表");
      backResult.setData(resultList);
    }// end if conflict list
    else if (qqiu.equals("add_batch")) {
      // TODO
      // start前台数据转换
      // 拿到本地JSON 并转成String
      String str = getRequestPayload(request);
      // Json的解析类对象
      JsonParser parser = new JsonParser();
      // 将JSON的String 转成一个JsonArray对象
      JsonArray jsonArray = parser.parse(str).getAsJsonArray();

      Gson gson = new Gson();
      ArrayList<PaikeRecord> pr_List = new ArrayList<PaikeRecord>();

      // 加强for循环遍历JsonArray
      for (JsonElement one : jsonArray) {
        // 使用GSON，直接转成Bean对象
        PaikeRecord pr = gson.fromJson(one, PaikeRecord.class);
        pr_List.add(pr);
      }
      System.out.println("数组转换出来的列表数据!!!!!" + pr_List);
      // end前台数据转换
      String count = paikeRecordService.insert_batch(pr_List);
      backResult.setMessage("信息值：成功" + "插入数量" + count);
      backResult.setQingqiu("add_batch查询列表");
      ArrayList<PaikeRecord> resultList = new ArrayList<PaikeRecord>();
      backResult.setData(resultList);
    }// end if conflict list
    else if (qqiu.equals("listPreview")) {
      // 2 将前台json数据转成实体对象
      T_DataControl t_data = new T_DataControl();
      String str = t_data.getRequestPayload(request);

      PaikeRecordPre prp = new PaikeRecordPre();
      if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
        Map<String, Object> map = t_data.JsonStrToMap(str);
        prp = MapToPaikeRecordPre(map);
      } else {
        System.out.println("前台传入post总参数数据为空，请联系管理员！");
      }
      // 3 执行qqiu里面的增或删或改或查 的操作
      ArrayList<PaikeRecord> resultList;
      try {
        resultList = paikeRecordService.getPaikePre(prp);
        backResult.setMessage("信息值：成功");
        backResult.setQingqiu("list查询列表");
        backResult.setData(resultList);
      } catch (ParseException e) {
        e.printStackTrace();
        System.out.println("日期格式解析异常");
      }

    }// end if 请求listPreview
    else {
      System.out.println("请求参数  " + qqiu + "  不规范");
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

  private PaikeRecord json2PaikeRecord(HttpServletRequest request) {

    String str = getRequestPayload(request);

    if (str != null && str != "" && str.length() != 0) { // 非空判断，防止前台传空报500服务器错误中的空指针
      Map<String, Object> map = JsonStrToMap(str);
      PaikeRecord paikeRecord = MapToPaikeRecord(map);
      return paikeRecord;
    } else {
      System.out.println("前台传入post总参数数据为空，请联系管理员！");
      return new PaikeRecord();
    }

  }// end method json2PaikeRecord

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

  public PaikeRecord MapToPaikeRecord(Map<String, Object> map) {

    String uuid = (String) map.get("uuid");// 删除和修改的时候会有值，新增和查询的时候没有值
    String claUuid = (String) map.get("claUuid");
    String courseUuid = (String) map.get("courseUuid");
    String empUuid = (String) map.get("empUuid");
    String classroomUuid = (String) map.get("classroomUuid");
    String keDateTime = (String) map.get("keDateTime");
    String keStartTime = (String) map.get("keStartTime");
    String keLongTime = (String) map.get("keLongTime");
    String status = (String) map.get("status");

    PaikeRecord paikeRecord = new PaikeRecord(uuid, claUuid, courseUuid, empUuid, classroomUuid,
        keDateTime, keStartTime, keLongTime, status);
    return paikeRecord;
  }// end method MapToPaikeRecord

  private PaikeRecordPre MapToPaikeRecordPre(Map<String, Object> map) {
    // TODO Auto-generated method stub
    String id = (String) map.get("id");// 删除和修改的时候会有值，新增和查询的时候没有值
    String claUuid = (String) map.get("claUuid");
    String courseUuid = (String) map.get("courseUuid");
    String empUuid = (String) map.get("empUuid");
    String classroomUuid = (String) map.get("classroomUuid");
    String keDateTime = (String) map.get("keDateTime");
    String keStartTime = (String) map.get("keStartTime");
    String keLongTime = (String) map.get("keLongTime");
    String status = (String) map.get("status");
    String keCountStr = (String) map.get("keCount");
    
    
    boolean empConflict = false;
    boolean croomConflict = false;

    boolean one = (Boolean) map.get("one");
    boolean two = (Boolean) map.get("two");
    boolean three = (Boolean) map.get("three");
    boolean four = (Boolean) map.get("four");
    boolean five = (Boolean) map.get("five");
    boolean six = (Boolean) map.get("six");
    boolean seven = (Boolean) map.get("seven");

    WeekDay weekDay = new WeekDay(one, two, three, four, five, six, seven);
    
    int keCount =Integer.parseInt(keCountStr);

    PaikeRecordPre prp = new PaikeRecordPre(id, claUuid, courseUuid, empUuid, classroomUuid,
        keDateTime, keStartTime, keLongTime, keCount, status, weekDay, empConflict, croomConflict);
    return prp;
  }// end method MapToPaikeRecordPre

  private void qqiuChoice(String qqiu, PaikeRecord paikeRecord) {
    // TODO Auto-generated method stub
    boolean test = false;
    boolean add = false;
    boolean delete = false;
    boolean edit = false;
    boolean getOne = false;
    boolean queryConflict = false;
    boolean listcla = false;

    test = qqiu.equals("test");
    add = qqiu.equals("add");
    delete = qqiu.equals("delete");
    edit = qqiu.equals("edit");
    getOne = qqiu.equals("getOne");
    queryConflict = qqiu.equals("queryConflict");
    listcla = qqiu.equals("listcla");

    if (test) {
      backResult.setMessage("信息值,测试成功");
      backResult.setQingqiu("test新增");
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add("内容值,测试成功1");
      resultList.add("内容值,测试成功2");
      resultList.add("内容值,测试成功3 PaikeRecord");
      backResult.setData(resultList);
    }
    if (add) {
      String result = paikeRecordService.insert(paikeRecord);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("add新增");
      backResult.setData(resultList);
    }
    if (delete) {
      String result = paikeRecordService.delete(paikeRecord.getUuid());
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("delete删除" + paikeRecord.getUuid());
      backResult.setData(resultList);
    }
    if (edit) {
      String result = paikeRecordService.update(paikeRecord);
      ArrayList<String> resultList = new ArrayList<String>();
      resultList.add(result);
      m_msg = paikeRecordService.getMsg();
      backResult.setMessage("信息："+m_msg.getEditMsg());
      backResult.setQingqiu("edit修改");
      backResult.setData(resultList);
    }
    if (getOne) {
      PaikeRecord result = paikeRecordService.getByUuid(paikeRecord.getUuid());
      ArrayList<PaikeRecord> resultList = new ArrayList<PaikeRecord>();
      resultList.add(result);
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("getOne查询单条记录");
      backResult.setData(resultList);
    }
    if (queryConflict) {
      PaikeRecord result;
      try {
        result = paikeRecordService.selectConflict(paikeRecord);
        ArrayList<PaikeRecord> resultList = new ArrayList<PaikeRecord>();
        resultList.add(result);
        backResult.setMessage("信息值：成功");
        backResult.setQingqiu("queryConflict单条查询冲突");
        backResult.setData(resultList);
      } catch (ParseException e) {
        e.printStackTrace();
        System.out.println("controller selectConflict方法不正确");
      }

    }// end if queryConflict
    if (listcla) {
      ArrayList<PaikeRecord> resultList = paikeRecordService.getListByclaUuid(paikeRecord
          .getClaUuid());
      backResult.setMessage("信息值：成功");
      backResult.setQingqiu("listcla查询列表班级排课记录");
      backResult.setData(resultList);
    }// end if listcla

  }// end method qqiuChoice

}// end class aaPaiKeControl
