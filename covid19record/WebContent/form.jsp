<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<center>
    <form action="register" method="post">
    	<center>ENTER TEST SUBJECT DETAILS</center>
    	<br/><br/>
 
        Name:<input type="text" name="userName"/><br/><br/>
        
        Mobile No:<input type="text" name="mobno"/><br/><br/>
        
        Date of Birth:<input type="text" name="dob" /><br/><br/>
        
        Gender: <select name="gender">
            <option>Male</option>
            <option>Female</option>
            <option>Transgender</option>
        </select> <br/><br/>
        
        
        <input type="submit" value="Submit"/><br/><br/><br/><br/>
       </form>
      <form action="updatetest" method="post">
      <center>UPDATE TEST RESULT</center>
      <br/><br/>
      
      	Enter UID:<input type="text" name="uid"/><br/><br/>
        Test Results: <select name="result">
            <option>Negative</option>
            <option>Positive</option>
            </select>
  
        <input type="submit" value="Update Record"/>
       </form><br/>
 </center>
    
</body>
</html>