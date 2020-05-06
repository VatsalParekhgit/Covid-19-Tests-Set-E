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
 
public class insertRecord extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String name = request.getParameter("userName");
        String mob = request.getParameter("mobno");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/coviddata", "root", "1009");
            
            String id=dob+mob;
            String def="Negative";
            PreparedStatement ps = con
                    .prepareStatement("insert into TESTDATA values(?,?,?,?,?,?,now())");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, mob);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6,def);
 
            int i = ps.executeUpdate();
            if (i > 0)
            {
            	out.print("<html><body><center>");
                out.print("Your Record Has been Saved Successfully");
            	out.print("<br/><br/>");
            	out.print("Your Unique ID is :"+id);
            	out.print("</center></body></html>");
            }
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}
