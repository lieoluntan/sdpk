package com.sdpk.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.sdpk.dao.ClassRoomDao;
import com.sdpk.dao.Class_ContractDao;
import com.sdpk.dao.ContractDao;
import com.sdpk.dao.CourseDao;
import com.sdpk.dao.EmployeeDao;
import com.sdpk.dao.PaikeRecordDao;
import com.sdpk.dao.impl.ClassRoomDaoImpl;
import com.sdpk.dao.impl.Class_ContractDaoImpl;
import com.sdpk.dao.impl.ContractDaoImpl;
import com.sdpk.dao.impl.CourseDaoImpl;
import com.sdpk.dao.impl.EmployeeDaoImpl;
import com.sdpk.dao.impl.PaikeRecordDaoImpl;
import com.sdpk.model.ClassRoom;
import com.sdpk.model.Class_Contract;
import com.sdpk.model.Contract;
import com.sdpk.model.Course;
import com.sdpk.model.Course_Emp;
import com.sdpk.model.Employee;
import com.sdpk.model.PaikeRecord;
import com.sdpk.model.PaikeRecordPre;
import com.sdpk.service.PaikeRecordService;
import com.sdpk.utility.M_msg;
import com.sdpk.utility.MinSecond;
import com.sdpk.utility.T_YearAllDay;
import com.sdpk.utility.T_covert;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午10:58:38 类说明
 */

public class PaikeRecordServiceImpl implements PaikeRecordService {

  private PaikeRecordDao paikeRecordDao = new PaikeRecordDaoImpl();
  private ClassRoomDao classRoomDao= new ClassRoomDaoImpl();
  private CourseDao courseDao = new CourseDaoImpl();
  private EmployeeDao employeeDao = new EmployeeDaoImpl();
  
  private ContractDao contractDao= new ContractDaoImpl();
  private Class_ContractDao class_ContractDao = new Class_ContractDaoImpl();
  public M_msg m_msg = new M_msg();
  
  
  @Override
  public M_msg getMsg() {
    // TODO Auto-generated method stub
    return m_msg;
  }

  @Override
  public String insert(PaikeRecord paikeRecord) {

    paikeRecord.setUuid(null);

    paikeRecord.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在PaikeRecordServiceImpl收到数据 ：" + paikeRecord.toString() + "收到结束!");
    boolean daoFlag = paikeRecordDao.insert(paikeRecord);
    if (daoFlag) {
      return paikeRecord.getUuid();
    } else {
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }
  }// end method insert

  @Override
  public String insert_batch(ArrayList<PaikeRecord> PR_List) {
    // TODO Auto-generated method stub
    //11月15日
    //步骤一，检查排课条数在合同条数内
    //分步1，遍历传进来的预览排课列表,计算1200类型个数，1500类型个数
    int count1200yu = 0;
    int count1500yu = 0;
    for (PaikeRecord one : PR_List) {
      String courUuid = one.getCourseUuid();
      Course cour = courseDao.getByUuid(courUuid);
      String priceType = cour.getCategory();
      if(priceType.equals("1200A")){count1200yu++;}
      else if(priceType.equals("1500B")){count1500yu++;}
      else{System.out.println("课程价格类别有错误,不是1200A，1500B");
      String msg = "课程价格类别有错误,不是1200A，1500B";
      m_msg.setAddMsg(msg);
      return msg;
      }
    }//end外圈 for
    //分步2，遍历数据库已存排课列表，计算1200类型个数，1500类型个数
    PaikeRecord pr = new PaikeRecord();
    for (PaikeRecord one : PR_List) { 
      pr = one;
      break;
    }
    String claUuid = pr.getClaUuid();
    ArrayList<PaikeRecord> db_List = paikeRecordDao.getListByclaUuid(claUuid);
    int count1200db = 0;
    int count1500db = 0;
    for (PaikeRecord one : db_List) {
      String courUuid = one.getCourseUuid();
      Course cour = courseDao.getByUuid(courUuid);
      String priceType = cour.getCategory();
      if(priceType.equals("1200A")){count1200db++;}
      else if(priceType.equals("1500B")){count1500db++;}
      else{System.out.println("已排课数据里课程价格类别有错误,不是1200A，1500B");}
    }
    //分步3，计算计划要排的课次数总和
    int has1200all = count1200yu +  count1200db;
    int has1500all = count1500yu + count1500db;
    //分步4，遍历班级合同关联表里的合同，计算可以排的课数总和sumcountA总，sumcountB总
    int sumcountAZong = 0;
    int sumcountBZong = 0;
    ArrayList<Class_Contract> cc_List = class_ContractDao.getListBycla(claUuid);
    for(Class_Contract one : cc_List){
      String contrUuid = one.getContrUuid();
      Contract contr = contractDao.getByUuid(contrUuid);
      int sumcountA = Integer.valueOf(contr.getSumCountA()).intValue();
      int sumcountB = Integer.valueOf(contr.getSumCountB()).intValue();
      sumcountAZong = sumcountAZong + sumcountA;
      sumcountBZong = sumcountBZong + sumcountB;
    }
    System.out.println("1200合同排"+sumcountAZong+"1500合同排"+sumcountBZong);
    //分步5，合同总数和要排的总和比较，超过次数不执行后面语句return，不超过就继续执行
    if(has1200all>sumcountAZong){
      String msg = "没有保存，1200课程超次数,预览排:"+count1200yu+"已排:"+count1200db+"~总排:"+has1200all+"~总可排:"+sumcountAZong;
      m_msg.setAddMsg(msg);
      return msg;
      }
    if(has1500all>sumcountBZong){
      String msg = "没有保存，1500课程超次数,预览排:"+count1500yu+"已排:"+count1500db+"~总排:"+has1500all+"~总可排:"+sumcountBZong;
      m_msg.setAddMsg(msg);
      return msg;
      }
    
    
    
    //步骤二，执行无冲突插入操作
    int count = 0;
    for (PaikeRecord one : PR_List) {
      // TODO 此处加if判断，包围后面的插入操作，要没有冲突才能做新增语句
      try {
        PaikeRecord tutupr = selectConflict(one);
        
        if (!tutupr.isEmpConflict() && !tutupr.isCroomConflict()) {
          // 单个插入操作
          one.setUuid(null);
          one.setUuid(UUID.randomUUID().toString());
          boolean daoFlag = paikeRecordDao.insert(one);
          if (daoFlag) {
            count++;
          } else {
            System.out.println("排课insert_batch批量插入有个不成功!!!");
          }
          // 单个插入操作
        }//end if判断，没有冲突才插入

      } catch (ParseException e) {
        System.out.println("insert_batch查询冲突有错误");
      }
    }// end for 结束for循环
    String recount = String.valueOf(count);
    return recount;
  }// end method insert_batch

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if (uuid != null && uuid != "") {
      boolean daoFlag = paikeRecordDao.delete(uuid);

      if (daoFlag) {
        return uuid;
      } else {
        return "删除不成功,dao层执行有出错地方,请联系管理员";
      }
    } else {
      String msg = "PaikeRecordServiceImpl delete方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println("PaikeRecordServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
      return msg;
    }

  }// end method delete

  @Override
  public String update(PaikeRecord paikeRecord) {
    // TODO Auto-generated method stub
    String uuid = paikeRecord.getUuid();
    if (uuid != null && uuid != "") {

      boolean daoFlag = paikeRecordDao.update(paikeRecord);

      if (daoFlag) {
        return uuid;
      } else {
        return "修改不成功,dao层执行有出错地方,请联系管理员";
      }
    } else {
      String msg = "PaikeRecordServiceImpl update方法中的uuid为空，或格式不正确，请重新选择";
      System.out.println("PaikeRecordServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
      return msg;
    }
  }// end method update

  @Override
  public ArrayList<PaikeRecord> getList() {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = paikeRecordDao.getList();

    return paikeRecordList;
  }// end method getList()

  @Override
  public ArrayList<PaikeRecord> getListByclaUuid(String claUuid) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> paikeRecordList = paikeRecordDao.getListByclaUuid(claUuid);
    
  //步骤:记录课程名、员工名、教室名
    ArrayList<PaikeRecord> reAddNameList =new ArrayList<PaikeRecord>();
    for(PaikeRecord one : paikeRecordList){
      //1、从基础表中找到课程名、员工名、教室名,保证基础表修改了名称，关联表也能知道
      String courUuid = one.getCourseUuid();
      String empUuid = one.getEmpUuid();
      String crUuid  = one.getClassroomUuid();
      Course cour = courseDao.getByUuid(courUuid);
      Employee emp = employeeDao.getByUuid(empUuid);
      ClassRoom croom = classRoomDao.getByUuid(crUuid);
      
      String courName = cour.getName();
      String cageName = cour.getCategory();
      String empName = emp.getName();
      String croomName = croom.getName();
      
      one.setCourseName(courName);
      one.setEmpName(empName);
      one.setCroomName(croomName);
      one.setCategoryName(cageName);
      
      reAddNameList.add(one);
    }//end 步骤

    return reAddNameList;
  }// end method getListByclaUuid

  @Override
  public PaikeRecord getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if (uuid != null && uuid != "") {
      PaikeRecord paikeRecord = paikeRecordDao.getByUuid(uuid);
      return paikeRecord;
    } else {
      System.out.println("PaikeRecordServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
      PaikeRecord paikeRecordX = new PaikeRecord();
      return paikeRecordX;
    }
  }// end method getByUuid

  @Override
  public PaikeRecord selectConflict(PaikeRecord paikeRecord) throws ParseException {
    // TODO Auto-generated method stub
    // 初始化0.0
    paikeRecord.setEmpConflict(false);
    paikeRecord.setCroomConflict(false);
    paikeRecord.setCourConflict(false);

    String pai_date = paikeRecord.getKeDateTime();
    String pai_empUuid = paikeRecord.getEmpUuid();

    // 将开始时间变成秒 start
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    try {
      System.out.println(df.parse(paikeRecord.getKeStartTime()) + "前台传的时分秒格式正确");
    } catch (Exception e) {
      System.out.println("前台传的时分秒格式不正确!!!");
    }
    Date dt1 = df.parse(paikeRecord.getKeStartTime());
    MinSecond minsecond = new MinSecond();
    long pai_startTime = minsecond.getMinSecond(dt1);// KeStartTime
                                                     // getMinSecond返回秒
    // 将开始时间变成秒 结束 例子 Date dt111 = df.parse("15:00:00")

    // 将上课时长变成秒 start
    long pai_longTime_fen = Long.parseLong(paikeRecord.getKeLongTime());
    long pai_longTime = pai_longTime_fen * 60;// KeLongTime 分钟转秒
    // 将上课时长变成秒 end

    /** part One:员工冲突：查询在排课时间上课员工是否有冲突 **/
    // 查询指定(员工日期)下的所有排课记录
    ArrayList<PaikeRecord> PRList_emp = new ArrayList<PaikeRecord>();
    PRList_emp = paikeRecordDao.getDateEmpList(pai_date, pai_empUuid);
    boolean flag_emp = flagConflict(pai_startTime, pai_longTime, PRList_emp);
    paikeRecord.setEmpConflict(flag_emp);
    /** end part One:员工冲突 **/

    /** part Two:教室冲突:查询在排课时间上课教室是否有冲突 **/
    // 查询指定(教室日期)下的所有排课记录
    String pai_crUuid = paikeRecord.getClassroomUuid();
    ArrayList<PaikeRecord> PRList_cr = new ArrayList<PaikeRecord>();
    PRList_cr = paikeRecordDao.getDateCrList(pai_date, pai_crUuid);
    boolean flag_cr = flagConflict(pai_startTime, pai_longTime, PRList_cr);
    paikeRecord.setCroomConflict(flag_cr);
    /** end part Two:教室冲突 **/
    
    /** part Three:班级课程 冲突:查询在排课时间班级课程是否有冲突 **/
    // 查询指定(班级日期)下的所有排课记录
  //班级课程冲突  作用：一个班级同一时间不能有两次课，发生课程冲突要修改时间，修改课程没用
    String pai_claUuid = paikeRecord.getClaUuid();
    ArrayList<PaikeRecord> PRList_cla = new ArrayList<PaikeRecord>();
    PRList_cla = paikeRecordDao.getDateClaList(pai_date, pai_claUuid);
    boolean flag_cla = flagConflict(pai_startTime, pai_longTime, PRList_cla);
    paikeRecord.setCourConflict(flag_cla);
    /** part Three:班级课程 冲突 **/
    
  //步骤:记录课程名、员工名、教室名
      //1、从基础表中找到课程名、员工名、教室名,保证基础表修改了名称，关联表也能知道
      String courUuid = paikeRecord.getCourseUuid();
      String empUuid = paikeRecord.getEmpUuid();
      String crUuid  = paikeRecord.getClassroomUuid();
      Course cour = courseDao.getByUuid(courUuid);
      Employee emp = employeeDao.getByUuid(empUuid);
      ClassRoom croom = classRoomDao.getByUuid(crUuid);
      String courName = cour.getName();
      String cageName = cour.getCategory();
      String empName = emp.getName();
      String croomName = croom.getName();
      
      paikeRecord.setCourseName(courName);
      paikeRecord.setEmpName(empName);
      paikeRecord.setCroomName(croomName);
      paikeRecord.setCategoryName(cageName);
      
      //步骤记录星期
      SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
      SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
      Date aDay = sdf_date.parse(paikeRecord.getKeDateTime());
      String week = sdf.format(aDay);
      paikeRecord.setWeekSome(week);
      
    return paikeRecord;
  }// end selectConflict

  public boolean flagConflict(long pai_startTime, long pai_longTime, ArrayList<PaikeRecord> PRList)
      throws ParseException {
    boolean conflict = false;
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    /** part One:冲突 start **/
    for (PaikeRecord oneRecord : PRList) {
      // 将开始时间变成秒 start
      Date dt2 = df.parse(oneRecord.getKeStartTime());
      MinSecond minsecond = new MinSecond();
      long old_startTime = minsecond.getMinSecond(dt2);// old_startTime
                                                       // getMinSecond返回秒
      // 将上课时长变成秒 start
      long old_longTime_fen = Long.parseLong(oneRecord.getKeLongTime());
      long old_longTime = old_longTime_fen * 60;// KeLongTime 分钟转秒
      // 将相加得出结束时间
      long old_endTime = old_startTime + old_longTime;
      if (pai_startTime >= old_endTime) {
        conflict = false;
      }// end 第一种情况 old_endTime<排课开始时间 永不冲突
       // xxxxxx222
      else if (pai_startTime < old_endTime) {

        if (pai_startTime >= old_startTime) {
          conflict = true;
          return conflict;
        } // end 外圈第二种情况 old_startTime<排课开始时间<old_endTime 一定冲突
        else if (pai_startTime < old_startTime) {
          if (pai_startTime + pai_longTime > old_startTime) {
            conflict = true;
            return conflict;
          }// 外圈第三种情况 排课开始时间 < old_startTime <排课开始时间+时长

        }// end 外圈第三种情况
      }// xxxxxx222

    }// end for最外层遍历

    /** part One:冲突 end **/
    return conflict;
  }// end method decideConflict

  @Override
  public ArrayList<PaikeRecord> selectConflict_batch(ArrayList<PaikeRecord> PR_List) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> relist = new ArrayList<PaikeRecord>();
    for (PaikeRecord one : PR_List) {
      PaikeRecord pr = new PaikeRecord();
      try {
        pr = selectConflict(one);
        relist.add(pr);
      } catch (ParseException e) {
        e.printStackTrace();
        System.out.println("^^selectConflict_batch方法解析出错");
      }
    }// end for 外圈循环

    return relist;
  }// end method selectConflict_batch 批量冲突调用了单个冲突查询方法,就没有调用dao层

  @Override
  public ArrayList<PaikeRecord> getPaikePre(PaikeRecordPre paikeRecordPre) throws ParseException {
    // TODO Auto-generated method stub
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf_Week = new SimpleDateFormat("EEEE");
    Date dBegin = df.parse(paikeRecordPre.getKeDateTime());
    Calendar calBegin = Calendar.getInstance();  
    // 使用给定的 Date 设置此 Calendar 的时间  
    calBegin.setTime(dBegin);
    T_YearAllDay ye = new T_YearAllDay();
    //步骤一：获得一年从1月1号到第二年年底所有日子大约730天
//    ArrayList<Calendar> yearAllDayList =  ye.getyearAllDay(calBegin);
    ArrayList<Date> yearAllDayList = ye.getyearAllDay(calBegin);
    
    //步骤二 :获得排课次数的日子 列表（年月日）
    ArrayList<Date> paiDayList =  getPaikePre_DateList(paikeRecordPre,yearAllDayList);

    //步骤三:根据 步二日子列表获得排课记录表（年月日）
    ArrayList<PaikeRecordPre> reList = new ArrayList<PaikeRecordPre>();
    for(Date aDay : paiDayList){
      PaikeRecordPre copyOne = new PaikeRecordPre("预览id",paikeRecordPre.getClaUuid(), paikeRecordPre.getCourseUuid(), paikeRecordPre.getEmpUuid(), paikeRecordPre.getClassroomUuid(), paikeRecordPre.getKeDateTime(), paikeRecordPre.getKeStartTime(), paikeRecordPre.getKeLongTime(), paikeRecordPre.getKeCount(), paikeRecordPre.getStatus(), paikeRecordPre.getWeekDay(), paikeRecordPre.isEmpConflict(), paikeRecordPre.isCroomConflict());
      String newKeDate = df.format(aDay);
      String week = sdf_Week.format(aDay);
      copyOne.setKeDateTime(newKeDate);
      copyOne.setWeekSome(week);
      System.out.println("copyOne是"+copyOne.toString());
      reList.add(copyOne);
    }//end 外圈for循环
    
    //步骤四：根据步三转换成PaikeRecord列表再记录冲突
    ArrayList<PaikeRecord> reList_pr = new ArrayList<PaikeRecord>();
    for(PaikeRecordPre one : reList){
      T_covert vert = new T_covert();
      PaikeRecord pr= vert.Prp2Pr(one);
      System.out.println(pr);
      reList_pr.add(pr);
    }
    
    //步骤五：记录冲突字段
    ArrayList<PaikeRecord> resultList = selectConflict_batch(reList_pr);
    //步骤六:记录课程名、员工名、教室名
    ArrayList<PaikeRecord> reAddNameList =new ArrayList<PaikeRecord>();
    for(PaikeRecord one : resultList){
      //1、从基础表中找到课程名、员工名、教室名,保证基础表修改了名称，关联表也能知道
      String courUuid = one.getCourseUuid();
      String empUuid = one.getEmpUuid();
      String crUuid  = one.getClassroomUuid();
      Course cour = courseDao.getByUuid(courUuid);
      Employee emp = employeeDao.getByUuid(empUuid);
      ClassRoom croom = classRoomDao.getByUuid(crUuid);
      String courName = cour.getName();
      String cageName = cour.getCategory();
      String empName = emp.getName();
      String croomName = croom.getName();
      
      one.setCourseName(courName);
      one.setEmpName(empName);
      one.setCroomName(croomName);
      one.setCategoryName(cageName);
      
      reAddNameList.add(one);
    }
    
    
    /**
    **/
    return reAddNameList;
  }// end method getPaikePre
  
  /**
   * getPaikePre_DateList
   * @param paikeRecordPre
   * @param yearAllDayList
   * @return
   * 用来获取对应次数的日期列表数据
   */
  public ArrayList<Date> getPaikePre_DateList(PaikeRecordPre paikeRecordPre,ArrayList<Date> yearAllDayList){
    ArrayList<Date> paiDayList =  new ArrayList<Date>();
    int count = paikeRecordPre.getKeCount();
    boolean one = paikeRecordPre.getWeekDay().isOne();
    boolean two = paikeRecordPre.getWeekDay().isTwo();
    boolean three = paikeRecordPre.getWeekDay().isThree();
    boolean four = paikeRecordPre.getWeekDay().isFour();
    boolean five = paikeRecordPre.getWeekDay().isFive();
    boolean six = paikeRecordPre.getWeekDay().isSix();
    boolean seven = paikeRecordPre.getWeekDay().isSeven();
    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    SimpleDateFormat sdf_date = new SimpleDateFormat("yyyy-MM-dd");
    Date startDay;
    try {
      startDay = sdf_date.parse(paikeRecordPre.getKeDateTime());
      
      for(Date aDay : yearAllDayList){
        int nowSize= paiDayList.size();
        if(aDay.after(startDay))
        //start if count 
        if(nowSize<count){
          String week = sdf.format(aDay);
          System.out.println("次数："+nowSize+"查看星期："+week);
          if(one){if(week.equals("星期一")){paiDayList.add(aDay);}}
          if(two){if(week.equals("星期二")){paiDayList.add(aDay);}}
          if(three){if(week.equals("星期三")){paiDayList.add(aDay);}}
          if(four){if(week.equals("星期四")){paiDayList.add(aDay);}}
          if(five){if(week.equals("星期五")){paiDayList.add(aDay);}}
          if(six){if(week.equals("星期六")){paiDayList.add(aDay);System.out.println("添加的次数："+nowSize+"查看星期："+aDay);}}
          if(seven){if(week.equals("星期日")){paiDayList.add(aDay);}}
        }else if(nowSize>=count){
          return paiDayList;
        }
        //end if count 小于排课次数才添加排课日子
      }//end 外圈for循环
    } catch (ParseException e) {
      System.out.println("^^方法getPaikePre_DateList 解析日期有问题!");
    }

    //上面部分要独立重构成方法
    return paiDayList;
  }//end method getPaikePre_DateList
  
  

}// end class PaikeRecordServiceImpl
