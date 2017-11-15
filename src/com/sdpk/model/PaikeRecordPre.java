package com.sdpk.model;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-26 下午12:20:41 类说明 排课预览对应的字段
 */

public class PaikeRecordPre {

  private String id;

  // 班级uuid
  private String claUuid;
  // 课程uuid
  private String courseUuid;
  private String empUuid;
  private String classroomUuid;
  // 上课日期(年月日)
  private String keDateTime;
  // 上课开始时间(时分秒)
  private String keStartTime;
  // 上课结束时长(分钟)
  private String keLongTime;
  // 排课次数
  private int keCount;
  // 排课状态
  private String status;
  private WeekDay weekDay;
  private String weekSome;

  /**
   * 中文名字：员工uuid冲突 作用：表示员工在排课时间内已被占用 false表示没冲突，正常 true表示有冲突,不正常
   */
  private boolean empConflict;

  /**
   * 中文名字：教室uuid冲突 作用：表示教室在排课时间内已被占用 false表示没冲突，正常 true表示有冲突,不正常
   */
  private boolean croomConflict;
  
  
  public PaikeRecordPre(){}
  
  public PaikeRecordPre(String id, String claUuid, String courseUuid, String empUuid,
      String classroomUuid, String keDateTime, String keStartTime, String keLongTime, int keCount,
      String status, WeekDay weekDay, boolean empConflict, boolean croomConflict) {
    super();
    this.id = id;
    this.claUuid = claUuid;
    this.courseUuid = courseUuid;
    this.empUuid = empUuid;
    this.classroomUuid = classroomUuid;
    this.keDateTime = keDateTime;
    this.keStartTime = keStartTime;
    this.keLongTime = keLongTime;
    this.keCount = keCount;
    this.status = status;
    this.weekDay = weekDay;
    this.empConflict = empConflict;
    this.croomConflict = croomConflict;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getClaUuid() {
    return claUuid;
  }

  public void setClaUuid(String claUuid) {
    this.claUuid = claUuid;
  }

  public String getCourseUuid() {
    return courseUuid;
  }

  public void setCourseUuid(String courseUuid) {
    this.courseUuid = courseUuid;
  }

  public String getEmpUuid() {
    return empUuid;
  }

  public void setEmpUuid(String empUuid) {
    this.empUuid = empUuid;
  }

  public String getClassroomUuid() {
    return classroomUuid;
  }

  public void setClassroomUuid(String classroomUuid) {
    this.classroomUuid = classroomUuid;
  }

  public String getKeDateTime() {
    return keDateTime;
  }

  public void setKeDateTime(String keDateTime) {
    this.keDateTime = keDateTime;
  }

  public String getKeStartTime() {
    return keStartTime;
  }

  public void setKeStartTime(String keStartTime) {
    this.keStartTime = keStartTime;
  }

  public String getKeLongTime() {
    return keLongTime;
  }

  public void setKeLongTime(String keLongTime) {
    this.keLongTime = keLongTime;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public WeekDay getWeekDay() {
    return weekDay;
  }

  public void setWeekDay(WeekDay weekDay) {
    this.weekDay = weekDay;
  }

  public boolean isEmpConflict() {
    return empConflict;
  }

  public void setEmpConflict(boolean empConflict) {
    this.empConflict = empConflict;
  }

  public boolean isCroomConflict() {
    return croomConflict;
  }

  public void setCroomConflict(boolean croomConflict) {
    this.croomConflict = croomConflict;
  }

  public int getKeCount() {
    return keCount;
  }

  public void setKeCount(int keCount) {
    this.keCount = keCount;
  }

  public String getWeekSome() {
    return weekSome;
  }

  public void setWeekSome(String weekSome) {
    this.weekSome = weekSome;
  }

}// end class PaikeRecordPre
