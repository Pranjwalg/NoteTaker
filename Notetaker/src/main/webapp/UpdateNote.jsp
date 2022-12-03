<%@page import="com.myapp.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit note</title>
 <%@include file="Links.jsp" %>
</head>
<body>
<div class="container-fluid m-0 p-0">
<%@include file="navbar.jsp"%>

<%

int id= Integer.parseInt(request.getParameter("id").trim());
Session session2=FactoryProvider.getFactory().openSession();
Note note=  session2.get(Note.class, id);

%>
<form action="Editservlet" method="post">
  <div class="form-group">
   <input value="<%=note.getId() %>" name="id" type="hidden"/>
    <label for="title">Title</label>
    <input type="text" name="title" required class="form-control" id="title" 
    aria-describedby="emailHelp" 
    
    value="<%=note.getTitle() %>"
    placeholder="Enter the Title">
    
  </div>
  <div class="form-group">
   <label for="content">Add Content</label>
   <textarea required id="content" name="content" 
   style="height:300px" class="form-control" 
   placeholder="Enter the contents">
   <%=note.getContent() %>
   </textarea>
  </div>
  
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Edit Note</button>
   </div>
</form>







</div>
</body>
</html>