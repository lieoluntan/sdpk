package com.sdpk.model;

/**
 * 树袋老师
 * 
 * @author 作者 xpp
 * @version 创建时间：2017-10-24 上午9:52:31 类说明
 */

public class PaikeRecord {

  private String uuid;
  private String createDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  // 班级uuid
  private String claUuid;
  // 课程uuid
  private String courseUuid;
  // 员工uuid
  private String empUuid;
  // 教室uuid
  private String classroomUuid;
  // 上课日期(年月日)
  private String keDateTime;
  // 上课开始时间(时分秒)
  private String keStartTime;
  // 上课结束时长(分钟)
  private String keLongTime;
  // 排课状态
  private String status;
  
  private String weekSome;

  public String getWeekSome() {
    return weekSome;
  }

  public void setWeekSome(String weekSome) {
    this.weekSome = weekSome;
  }

  /**
   * 中文名字：员工uuid冲突 作用：表示员工在排课时间内已被占用 false表示没冲突，正常 true表示有冲突,不正常
   */
  private boolean empConflict;

  /**
   * 中文名字：教室uuid冲突 作用：表示教室在排课时间内已被占用 false表示没冲突，正常 true表示有冲突,不正常
   */
  private boolean croomConflict;

  public PaikeRecord() {
  }

  public PaikeRecord(String uuid, String claUuid, String courseUuid, String empUuid,
      String classroomUuid, String keDateTime, String keStartTime, String keLongTime, String status) {
    super();
    this.uuid = uuid;
    this.claUuid = claUuid;
    this.courseUuid = courseUuid;
    this.empUuid = empUuid;
    this.classroomUuid = classroomUuid;
    this.keDateTime = keDateTime;
    this.keStartTime = keStartTime;
    this.keLongTime = keLongTime;
    this.status = status;
  }// end method PaikeRecord

  @Override
  public String toString() {
    return "排课记录 [uuid=" + uuid + ", claUuid=" + claUuid + ", courseUuid=" + courseUuid
        + ", empUuid=" + empUuid + ", empConflict=" + empConflict + ", classroomUuid="
        + classroomUuid + ", croomConflict=" + croomConflict + ", keDateTime=" + keDateTime
        + ", keStartTime=" + keStartTime + ", keLongTime=" + keLongTime + ", status=" + status
        + "]结束";
  }// end method toString

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }

  public String getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(String modifyDate) {
    this.modifyDate = modifyDate;
  }

  public String getCreatePeople() {
    return createPeople;
  }

  public void setCreatePeople(String createPeople) {
    this.createPeople = createPeople;
  }

  public String getModifyPeople() {
    return modifyPeople;
  }

  public void setModifyPeople(String modifyPeople) {
    this.modifyPeople = modifyPeople;
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

}// end class PaikeRecord
