package com.sdpk.model;

public class Student {

  private String uuid;
  private String addDate;
  private String modifyDate;
  private String createPeople;
  private String modifyPeople;

  private String name;
  private String studentID;
  private String school;
  private String grade;
  private String phone;
  private String date;
  private String parentName;
  private String parentPhone;
  private String address;
  private String remark;

  @Override
  public String toString() {
    return "学生 [name=" + name + ", studentID=" + studentID + ", school=" + school + ", grade="
        + grade + ", phone=" + phone + ", date=" + date + ", parentName=" + parentName
        + ", parentPhone=" + parentPhone + ", address=" + address + ", remark=" + remark +

        "]";
  }
  
  public Student(){}

  public Student( String name, String studentID, String school, String grade,
      String phone, String date, String parentName, String parentPhone, String address,
      String remark) {
    super();
    this.name = name;
    this.studentID = studentID;
    this.school = school;
    this.grade = grade;
    this.phone = phone;
    this.date = date;
    this.parentName = parentName;
    this.parentPhone = parentPhone;
    this.address = address;
    this.remark = remark;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getAddDate() {
    return addDate;
  }

  public void setAddDate(String addDate) {
    this.addDate = addDate;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStudentID() {
    return studentID;
  }

  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getParentPhone() {
    return parentPhone;
  }

  public void setParentPhone(String parentPhone) {
    this.parentPhone = parentPhone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}// end class student