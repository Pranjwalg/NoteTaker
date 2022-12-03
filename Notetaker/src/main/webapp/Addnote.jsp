<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="Links.jsp" %>

<title>Add Note</title>

<div class="container-fluid p-0 m-0 ">
<%@include file="navbar.jsp" %>
<div class="container">
<h1>Please Add the notes</h1>
<form action="s" method="post">
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" name="title" required class="form-control" id="title" 
    aria-describedby="emailHelp" placeholder="Enter the Title">
    
  </div>
  <div class="form-group">
   <label for="content">Add Content</label>
   <textarea required id="content"  name="content" style="height:300px" class="form-control" placeholder="Enter the contents"></textarea>
  </div>
  
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Add Note</button>
   </div>
</form>







</div>
</div>

