<%@ page import="javax.servlet.http.HttpSession,java.util.*,java.io.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h1 style="color:red;">Home page</h1>


<a href="service/admin/addStudent">Add Student</a>


<a href="service/admin/removeStudent">Remove Student</a>


<a href="service/searchBook">Search Book</a>



<%

	HttpSession ses=request.getSession();
	//System.out.println(ses);
	Object obj=ses.getAttribute("user_status");
	//System.out.println(obj);
	Boolean st=(Boolean)obj;
	//System.out.println(st);
	if(st!=null){
		boolean status=st.booleanValue();
		if(status){
	
	
%>
			
			<a href="logout">logout</a>

<%	
	}
		else{
		%><a href="login">Login</a><%
		}
	}
	else{
%>
		<a href="login">Login</a>
		
		<%} %>
		
	
</body>
</html>