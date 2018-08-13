package Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseUtil {
	public static final String TABLE_ACCOUNT = "userInforma";//�û���Ϣ��

    // connect to MySql database  
    public static Connection getConnect() {  
        String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useUnicode=true&characterEncoding=gbk&mysqlEncoding=utf8";
        Connection connecter = null;  
        try {  
            Class.forName("com.mysql.jdbc.Driver"); // java���䣬�̶�д��  
            connecter = (Connection) DriverManager.getConnection(url, "root", "980713"); 
            LogUtil.log("�������ݿ�����"); 
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (SQLException e) {  
            System.out.println("SQLException: " + e.getMessage());  
            System.out.println("SQLState: " + e.getSQLState());  
            System.out.println("VendorError: " + e.getErrorCode());   
        }  
        return connecter;  
    }  
    public static ResultSet query(String querySql) throws SQLException {
		Statement stateMent = (Statement) getConnect().createStatement();
		return stateMent.executeQuery(querySql);
	}
}
