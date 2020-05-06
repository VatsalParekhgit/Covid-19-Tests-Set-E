package com.covid19record;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class updatetest extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String uid = request.getParameter("uid");
        String res = request.getParameter("result");
  
        
        
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/coviddata", "root", "1009");
            
            
            PreparedStatement ps = con
                    .prepareStatement("select from TESTDATA where uid=?");
            ps.setString(1, uid);
            
 
            int i = ps.executeUpdate();
            if (i > 0)
            {
            PreparedStatement ps2=con.prepareStatement("update TESTDATA set TestResult=? where uid= ?");
            ps2.setString(1,res);
            ps2.setString(2, uid);
            int j=ps2.executeUpdate();
            if(j>0)
            	out.print("UPDATED SUCCESSFULLY");
            }
            else {
            	out.print("Record not Found !!!");
            }
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}
