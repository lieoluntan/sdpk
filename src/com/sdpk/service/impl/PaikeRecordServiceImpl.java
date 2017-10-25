package com.sdpk.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.sdpk.dao.PaikeRecordDao;
import com.sdpk.dao.impl.PaikeRecordDaoImpl;
import com.sdpk.model.PaikeRecord;
import com.sdpk.service.PaikeRecordService;
import com.sdpk.utility.MinSecond;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午10:58:38 类说明
 */

public class PaikeRecordServiceImpl implements PaikeRecordService {

  private PaikeRecordDao paikeRecordDao = new PaikeRecordDaoImpl();

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

    String pai_date = paikeRecord.getKeDateTime();
    String pai_empUuid = paikeRecord.getEmpUuid();

    // 将开始时间变成秒 start
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    try {
      System.out.println(df.parse(paikeRecord.getKeStartTime())+"前台传的时分秒格式正确");
    } catch (Exception e) {
      System.out.println("前台传的时分秒格式不正确!!!");
    }
    Date dt1 = df.parse(paikeRecord.getKeStartTime());
    MinSecond minsecond = new MinSecond();
    long pai_startTime = minsecond.getMinSecond(dt1);// KeStartTime getMinSecond返回秒
    // 将开始时间变成秒 结束 例子 Date dt111 = df.parse("15:00:00")

    // 将上课时长变成秒 start
    long pai_longTime_fen = Long.parseLong(paikeRecord.getKeLongTime());
    long pai_longTime = pai_longTime_fen * 60;// KeLongTime 分钟转秒
    // 将上课时长变成秒 end

    /** part One:员工冲突：查询在排课时间上课员工是否有冲突 **/
    // 查询指定(员工日期)下的所有排课记录
    ArrayList<PaikeRecord> PRList_emp = new ArrayList<PaikeRecord>();
    PRList_emp = paikeRecordDao.getDateEmpList(pai_date, pai_empUuid);
    boolean flag_emp = flagConflict(pai_startTime,pai_longTime,PRList_emp);
    paikeRecord.setEmpConflict(flag_emp);
    /** end part One:员工冲突 **/

    /** part Two:教室冲突:查询在排课时间上课教室是否有冲突 **/
      // 查询指定(教室日期)下的所有排课记录
    String pai_crUuid = paikeRecord.getClassroomUuid();
    ArrayList<PaikeRecord> PRList_cr = new ArrayList<PaikeRecord>();
    PRList_cr = paikeRecordDao.getDateCrList(pai_date, pai_crUuid);
    boolean flag_cr = flagConflict(pai_startTime,pai_longTime,PRList_cr);
    paikeRecord.setCroomConflict(flag_cr);
    /** end part Two:教室冲突 **/

    return paikeRecord;
  }// end selectConflict
  

  public boolean flagConflict(long pai_startTime,long pai_longTime,ArrayList<PaikeRecord> PRList) throws ParseException{
    boolean conflict = false;
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    /** part One:冲突 start **/
    for (PaikeRecord oneRecord : PRList) {
      // 将开始时间变成秒 start
      Date dt2 = df.parse(oneRecord.getKeStartTime());
      MinSecond minsecond = new MinSecond();
      long old_startTime = minsecond.getMinSecond(dt2);// old_startTime getMinSecond返回秒
      // 将上课时长变成秒 start
      long old_longTime_fen = Long.parseLong(oneRecord.getKeLongTime());
      long old_longTime = old_longTime_fen * 60;// KeLongTime 分钟转秒
      // 将相加得出结束时间
      long old_endTime = old_startTime + old_longTime;
      if (pai_startTime >= old_endTime) {
        conflict = false;
      }// end 第一种情况  old_endTime<排课开始时间  永不冲突
      //xxxxxx222
      else if (pai_startTime < old_endTime) {
       
        if (pai_startTime >= old_startTime) {
          conflict = true;
          return conflict;
        } // end 外圈第二种情况  old_startTime<排课开始时间<old_endTime 一定冲突
        else if (pai_startTime < old_startTime) {
          if (pai_startTime + pai_longTime > old_startTime) {
            conflict = true;
            return conflict;
          }// 外圈第三种情况      排课开始时间 < old_startTime <排课开始时间+时长
          
        }// end 外圈第三种情况
      }//xxxxxx222

    }// end for最外层遍历

    /** part One:冲突 end **/
    return conflict;
  }//end method decideConflict

  @Override
  public ArrayList<PaikeRecord> getListByclaUuid(String claUuid) {
    // TODO Auto-generated method stub
    return null;
  }//end method getListByclaUuid

  @Override
  public ArrayList<PaikeRecord> selectConflict_batch(ArrayList<PaikeRecord> PR_List) {
    // TODO Auto-generated method stub
    ArrayList<PaikeRecord> relist = new ArrayList<PaikeRecord> ();
    for(PaikeRecord one: PR_List){
      PaikeRecord pr = new PaikeRecord();
      try {
        pr = selectConflict(one);
        relist.add(pr);
      } catch (ParseException e) {
        e.printStackTrace();System.out.println("^^selectConflict_batch方法解析出错");
      }
    }//end for 外圈循环
    
    return relist;
  }//end method selectConflict_batch  批量冲突调用了单个冲突查询方法,就没有调用dao层

}// end class PaikeRecordServiceImpl
