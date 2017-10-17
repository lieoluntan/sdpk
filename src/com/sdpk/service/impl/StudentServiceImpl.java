package com.sdpk.service.impl;

import java.util.ArrayList;
import java.util.UUID;

import com.sdpk.dao.StudentDao;
import com.sdpk.dao.impl.StudentDaoImpl;
import com.sdpk.model.Course;
import com.sdpk.model.Student;
import com.sdpk.service.StudentService;

public class StudentServiceImpl implements StudentService{

    
  private StudentDao studentDao= new StudentDaoImpl();
  
  @Override
  public String insert(Student stu) {
//    
   
    stu.setUuid(null);

    stu.setUuid(UUID.randomUUID().toString());
    System.out.println("^^在StudentServiceImpl收到数据 ："+stu.toString()+"收到结束!");
    boolean daoFlag = studentDao.insert(stu);
    if(daoFlag)
    {
    return stu.getUuid();
    }else{
      return "插入不成功,dao层执行有出错地方,请联系管理员";
    }

  }//end method insert

  @Override
  public String delete(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
      boolean daoFlag = studentDao.delete(uuid);
      
        if(daoFlag)
        {
        return uuid;
        }else{
          return "删除不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      System.out.println("StudentServiceImpl delete方法中的uuid为空，或格式不正确，请联系管理员");
      return uuid;
    }
    
  }//end method delete

  @Override
  public String update(Student student) {
    // TODO Auto-generated method stub
    String uuid = student.getUuid();
    if(uuid!=null&&uuid!="")
    {
      
        boolean daoFlag = studentDao.update(student);
        
        if(daoFlag)
        {
        return uuid;
        }else{
          return "修改不成功,dao层执行有出错地方,请联系管理员";
        }
    }else{
      System.out.println("StudentServiceImpl update方法中的uuid为空，或格式不正确，请联系管理员");
      return uuid;
    }
  }//end method update

  @Override
  public ArrayList<Student> getList() {
    // TODO Auto-generated method stub
    ArrayList<Student> studentlist = studentDao.getList();

    return studentlist;
  }// end method getListCourse

  @Override
  public Student getByUuid(String uuid) {
    // TODO Auto-generated method stub
    if(uuid!=null&&uuid!="")
    {
    Student student = studentDao.getByUuid(uuid);
    return student;
    }else{
      System.out.println("StudentServiceImpl getByUuid方法中的uuid为空，或格式不正确，请联系管理员");
     Student studentX= new Student();
    return studentX;
    }
  }



}//end class StudentServiceImpl
