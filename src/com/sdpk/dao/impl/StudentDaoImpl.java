package com.sdpk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sdpk.dao.StudentDao;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.utility.DBUtility;

public class StudentDaoImpl implements StudentDao {

  private Connection connection;
  boolean daoFlag = false;

  public StudentDaoImpl() {
    connection = DBUtility.getConnection();
    System.out.println("connection对象在StudentDaoImpl连接!");
  }

  @Override
  public boolean insert(Student stu) {

    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("insert into t_student(uuid,name,studentID,school,grade,phone,date,parentName,parentPhone,address,remark,sex,org,parentRela) values (?,?, ?,?,?,?,?,?,?,?,?,?,?,?)");
      // Parameters start with 1
      preparedStatement.setString(1, stu.getUuid());
      preparedStatement.setString(2, stu.getName());
      preparedStatement.setString(3, stu.getStudentID());
      preparedStatement.setString(4, stu.getSchool());
      preparedStatement.setString(5, stu.getGrade());
      preparedStatement.setString(6, stu.getPhone());
      preparedStatement.setString(7, stu.getDate());
      preparedStatement.setString(8, stu.getParentName());
      preparedStatement.setString(9, stu.getParentPhone());
      preparedStatement.setString(10, stu.getAddress());
      preparedStatement.setString(11, stu.getRemark());
      
      preparedStatement.setString(12, stu.getSex());
      preparedStatement.setString(13, stu.getOrg());
      preparedStatement.setString(14, stu.getParentRela());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行StudentDao中的insert添加");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {

      System.out.println("^^在执行StudentDao中insert,出现sql语法执行错误，请联系管理员!");
      e.printStackTrace();
      daoFlag = false;
      return daoFlag;
    }
  }// end method insert

  @Override
  public boolean delete(String uuid) {
    // TODO Auto-generated method stub
    try {

      // Parameters start with 1
      PreparedStatement PSdelete = connection
          .prepareStatement("DELETE FROM t_student WHERE uuid = ? ");
      PSdelete.setString(1, uuid);
      PSdelete.executeUpdate();

      System.out.println("^^在执行CourseDaoImpl中的删除delete");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行StudentDao中delete,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method delete

  @Override
  public boolean update(Student student) {
    // TODO Auto-generated method stub
    try {

      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE t_student SET name = ?, studentID = ?,school = ?, grade = ?, phone = ?, date = ?, parentName = ?, parentPhone = ?, address = ?, remark = ?,sex = ?,org = ?,parentRela = ? WHERE uuid = ? ");
      // Parameters start with 1
      preparedStatement.setString(1, student.getName());
      preparedStatement.setString(2, student.getStudentID());
      preparedStatement.setString(3, student.getSchool());
      preparedStatement.setString(4, student.getGrade());
      preparedStatement.setString(5, student.getPhone());
      preparedStatement.setString(6, student.getDate());
      preparedStatement.setString(7, student.getParentName());
      preparedStatement.setString(8, student.getParentPhone());
      preparedStatement.setString(9, student.getAddress());
      preparedStatement.setString(10, student.getRemark());
      
      preparedStatement.setString(11, student.getSex());
      preparedStatement.setString(12, student.getOrg());
      preparedStatement.setString(13, student.getParentRela());
      
      preparedStatement.setString(14, student.getUuid());
      preparedStatement.executeUpdate();

      System.out.println("^^在执行CourseDaoImpl中的修改update");
      daoFlag = true;
      return daoFlag;
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("^^在执行StudentDao中update,出现sql语法执行错误，请联系管理员!");
      daoFlag = false;
      return daoFlag;
    }// end try catch
  }// end method update

  @Override
  public ArrayList<Student> getList() {
    // TODO Auto-generated method stub
    ArrayList<Student> studentList = new ArrayList<Student>();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_student");
        while (rs.next()) {
          Student student = new Student();
          student.setUuid(rs.getString("uuid"));
          student.setName(rs.getString("name"));
          student.setStudentID(rs.getString("studentID"));             
          student.setSchool(rs.getString("school"));
          student.setGrade(rs.getString("grade"));
          student.setPhone(rs.getString("phone"));
          student.setDate(rs.getString("date"));
          student.setParentName(rs.getString("parentName"));
          student.setParentPhone(rs.getString("parentPhone"));
          student.setAddress(rs.getString("address"));
          student.setRemark(rs.getString("remark"));
          
          student.setSex(rs.getString("sex"));
          student.setOrg(rs.getString("org"));
          student.setParentRela(rs.getString("parentRela"));
          
          studentList.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("StudentDaoImpl的getByUuid查询失败");
        Student studentX = new Student();
        studentX.setUuid("StudentDaoImpl的getList失败返回的uuid");
        ArrayList<Student> studentListX = new ArrayList<Student>();
        studentListX.add(studentX);
        return studentListX;
    }

    return studentList;
  }//end method getListCourse

  @Override
  public Student getByUuid(String uuid) {
    // TODO Auto-generated method stub
   Student studentResult = new Student();
    try {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from t_student WHERE uuid ="+"'"+uuid+"'");
        while (rs.next()) {
          Student student = new Student();
          student.setUuid(rs.getString("uuid"));
          student.setName(rs.getString("name"));
          student.setStudentID(rs.getString("studentID"));             
          student.setSchool(rs.getString("school"));
          student.setGrade(rs.getString("grade"));
          student.setPhone(rs.getString("phone"));
          student.setDate(rs.getString("date"));
          student.setParentName(rs.getString("parentName"));
          student.setParentPhone(rs.getString("parentPhone"));
          student.setAddress(rs.getString("address"));
          student.setRemark(rs.getString("remark"));
          
          studentResult=student;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("StudentDaoImpl的getByUuid查询失败");
        Student studentX = new Student();
        studentX.setUuid("StudentDaoImpl失败返回的uuid");
        return studentX;
    }

    return studentResult;
  }// end method getByUuid

}// end class StudentDaoImpl
