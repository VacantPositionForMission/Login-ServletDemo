package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Util.DatabaseUtil;
import Util.LogUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int code=0;  
	   
	        String account = request.getParameter("userAccount");  
	        String password = request.getParameter("userPassword");  
	        String name=request.getParameter("userName");
	        LogUtil.log("userAccount:"+account + ";userPassword:" + password+";userName:"+name);  
	  
	        Connection connect = DatabaseUtil.getConnect();  
	        try {  
	        	Statement statement = (Statement) connect.createStatement();  
	            String sql = "select userAccount from " + DatabaseUtil.TABLE_ACCOUNT + " where userAccount='" + account + "'";  
	            LogUtil.log(sql);  
	            ResultSet result = statement.executeQuery(sql);  
	            if (result.next()) { // �ܲ鵽���˺ţ�˵���Ѿ�ע�����  
	                code = 300;  
	             //"���˺��Ѵ���";  
	            } else {  
	                String sqlInsert = "insert into " + DatabaseUtil.TABLE_ACCOUNT + "(userAccount, userPassword, userName) values('"  
	                        + account + "', '" + password + "', '"+name+"')";  
	                LogUtil.log(sqlInsert);  
	                if (statement.executeUpdate(sqlInsert) > 0) { // �������ע���߼����������˺����뵽���ݿ�  
	                    code = 400;  
	                    //"ע��ɹ�";  
	                } else {  
	                    code =500;  
	                    //"ע��ʧ��";  
	                }  
	            }  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ
	        
	        PrintWriter out = response.getWriter();
	        String json=JSON.toJSONString(code);
			out.println(json);		
			out.flush();
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
