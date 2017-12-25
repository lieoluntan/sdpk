package com.sdpk.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtility {
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }//end method
    
    
    /** 
     *  依次关闭ResultSet、Statement、Connection 
     *  若对象不存在则创建一个空对象 
     * @param rs 
     * @param st 
     * @param pst 
     * @param conn 
     */  
    public static void close(ResultSet rs,Statement st,Connection conn){  
        if(rs != null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
                System.out.println("~~sdpk关闭ResultSet错误");
            } finally{  
                if(st != null){  
                    try {  
                        st.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                        System.out.println("~~sdpk关闭Statement st错误");
                    } finally{  
                        if(conn != null){  
                            try {  
                                conn.close();  
                            } catch (SQLException e) {  
                                e.printStackTrace();  
                                System.out.println("~~sdpk关闭Connection conn错误");
                            }  
                        }  
                    }  
                }  
            }  
        }  
    }//end method close  
    
    public static Connection open() {
          try {
              Properties prop = new Properties();
              InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
              prop.load(inputStream);
              String driver = prop.getProperty("driver");
              String url = prop.getProperty("url");
              String user = prop.getProperty("user");
              String password = prop.getProperty("password");
              Class.forName(driver);
              connection = DriverManager.getConnection(url, user, password);
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          } catch (SQLException e) {
              e.printStackTrace();
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
          return connection;
  }//end method

}//end class
