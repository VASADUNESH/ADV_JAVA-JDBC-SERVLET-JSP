<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	String code= request.getParameter("code");
	String name= request.getParameter("name");
	String aut = request.getParameter("aut");
	Float price = Float.parseFloat(request.getParameter("price"));
	int qty = Integer.parseInt(request.getParameter("qty"));
	
	out.println("******Book Details*****<br>");
	out.println("BookCode:"+code+"<br>");
	out.println("BookName:"+name+"<br>");
	out.println("BookAuthor:"+aut+"<br>");
	out.println("BookPrice:"+price+"<br>");
	out.println("BookQty:"+qty+"<br>");

	
	

%>
</body>
</html>