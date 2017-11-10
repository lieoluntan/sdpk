package com.sdpk.model;
/**
 *树袋老师
 * @author 作者 xpp
 * @version 创建时间：2017-11-9 下午5:28:03
 * 类说明
 */

public class And_ClassCourse {
  
  private String uuid;
  private String classUuid;
  private String className;
  private String courseUuid;
  private String courseName;
  
  
  public And_ClassCourse() {
    super();
  }
  public And_ClassCourse(String classUuid, String courseUuid) {
    super();
    this.classUuid = classUuid;
    this.courseUuid = courseUuid;
  }
  @Override
  public String toString() {
    return "And_ClassCourse 开始[uuid=" + uuid + ", classUuid=" + classUuid + ", className="
        + className + ", courseUuid=" + courseUuid + ", courseName=" + courseName + "]结束";
  }
  public String getUuid() {
    return uuid;
  }
  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
  public String getClassUuid() {
    return classUuid;
  }
  public void setClassUuid(String classUuid) {
    this.classUuid = classUuid;
  }
  public String getClassName() {
    return className;
  }
  public void setClassName(String className) {
    this.className = className;
  }
  public String getCourseUuid() {
    return courseUuid;
  }
  public void setCourseUuid(String courseUuid) {
    this.courseUuid = courseUuid;
  }
  public String getCourseName() {
    return courseName;
  }
  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
  
  
  
  

}// end class
