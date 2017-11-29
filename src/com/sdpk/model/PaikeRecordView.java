package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-29 下午4:04:58
 * 类说明
 */

public class PaikeRecordView {
  
  private String uuid;
  
//班级uuid
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
 
 private String courseName;
 private String empName;
 private String croomName;
 private String categoryName;//课程价格类别名
 
 //全校今日课程特有的字段
 private String claTeaUuid;//班主任uuid
 private String claTeaName;//班主任名
 private String stuUuid;//学生uuid
 private String stuName;//学生名
 private String keEndTime;//上课截止时间
 
 
 public PaikeRecordView() {
   this.claTeaUuid = "原始值";
   this.claTeaName = "原始值";
   this.stuUuid = "原始值";
   this.stuName = "原始值";
   this.keEndTime = "原始值";
 }//end method


public PaikeRecordView(String uuid, String claUuid, String courseUuid, String empUuid,
    String classroomUuid, String keDateTime, String keStartTime, String keLongTime, String status,
    String weekSome, String categoryName) {
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
  this.weekSome = weekSome;
  this.categoryName = categoryName;
}


@Override
public String toString() {
  return "PaikeRecordView 开始[uuid=" + uuid + ", claUuid=" + claUuid + ", courseUuid=" + courseUuid
      + ", empUuid=" + empUuid + ", classroomUuid=" + classroomUuid + ", keDateTime=" + keDateTime
      + ", keStartTime=" + keStartTime + ", keLongTime=" + keLongTime + ", status=" + status
      + ", weekSome=" + weekSome + ", courseName=" + courseName + ", empName=" + empName
      + ", croomName=" + croomName + ", categoryName=" + categoryName + ", claTeaUuid="
      + claTeaUuid + ", claTeaName=" + claTeaName + ", stuUuid=" + stuUuid + ", stuName=" + stuName
      + ", keEndTime=" + keEndTime + "]结束";
}


public String getUuid() {
  return uuid;
}


public void setUuid(String uuid) {
  this.uuid = uuid;
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


public String getWeekSome() {
  return weekSome;
}


public void setWeekSome(String weekSome) {
  this.weekSome = weekSome;
}


public String getCourseName() {
  return courseName;
}


public void setCourseName(String courseName) {
  this.courseName = courseName;
}


public String getEmpName() {
  return empName;
}


public void setEmpName(String empName) {
  this.empName = empName;
}


public String getCroomName() {
  return croomName;
}


public void setCroomName(String croomName) {
  this.croomName = croomName;
}


public String getCategoryName() {
  return categoryName;
}


public void setCategoryName(String categoryName) {
  this.categoryName = categoryName;
}


public String getClaTeaUuid() {
  return claTeaUuid;
}


public void setClaTeaUuid(String claTeaUuid) {
  this.claTeaUuid = claTeaUuid;
}


public String getClaTeaName() {
  return claTeaName;
}


public void setClaTeaName(String claTeaName) {
  this.claTeaName = claTeaName;
}


public String getStuUuid() {
  return stuUuid;
}


public void setStuUuid(String stuUuid) {
  this.stuUuid = stuUuid;
}


public String getStuName() {
  return stuName;
}


public void setStuName(String stuName) {
  this.stuName = stuName;
}


public String getKeEndTime() {
  return keEndTime;
}


public void setKeEndTime(String keEndTime) {
  this.keEndTime = keEndTime;
}


 
 
 
 

}//end class
