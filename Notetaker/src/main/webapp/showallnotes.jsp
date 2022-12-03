<%@page import="java.util.*" %>
<%@page import="com.myapp.Note" %>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%@include file="Links.jsp" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Show all notes</title>


</head>
<body>
<div class="container-fluid m-0 p-0">
<%@include file="navbar.jsp"%>
<br>
<h1 class="text-uppercase">Show All Notes</h1>

<div class="container">
<div class="row">
<%


Session s=FactoryProvider.getFactory().openSession();

Query query=s.createQuery("from Note");
 List<Note>notes=query.list();
for(Note n:notes){
	
	%>
	
	<div class="col-lg-12">
	
	<div class="card" >
  <div class="card-body">
    <h5 class="card-title"><%out.print(n.getTitle());%></h5>
    
    <p class="card-text"><%out.print(n.getContent()); %> <p>
    <h6 class="card-text">Added:- <%out.print(n.getAdddate());%> <p>
    
    
    <div class="container text-center mt-2">
    <a href="DeleteServlet?id=<%=n.getId()%>" class="btn btn-danger">Delete Note</a>
     <a href="UpdateNote.jsp?id=<%=n.getId() %>" class="btn btn-primary">Update Note</a>
     </div>
  </div>
</div>
	
	
	</div>
	
	
	
	<% 
	
}

	%>





</div>
</div>
</div>
</body>
</html>