<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Blog Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link href="resources/css/myfile.css?v=4"
    rel="stylesheet">
</head>
<body class="createblog">
<nav class="navbar navbar-expand-lg bg-custom">
  <div class="container-fluid">
    <a class="navbar-brand" href="/BlogApp">TOMSBLOG</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <a class="navbar-nav ms-auto"></a>
   
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="/BlogApp">Home</a>
        <a class="nav-link" href="showallblog">Read a blog</a>
        <a class="nav-link" href="createblog">Write your First Blog</a>
        <a class="nav-link" href="userlogin">Login</a>
        <a class="nav-link" href="users">SignUp</a>
      </div>
    </div>
  </div>
</nav>

<header>
<h2>We hope you find something that delights you</h2>
</header>
<h1>Write something cool to share with others</h1>
<h2 class="success">You have successfully created a blog</h2>
<div class="blogdiv">
<div class="blogdetails">
<h2>Enter Blog Details</h2>
<form:form class ="create" action="getblog" method="post" modelAttribute="blog">
 	<form:label path="blogTitle" class="titlelabel">Blog Title:</form:label>
           <form:input path="blogTitle" name="blogTitle" autofocus="true" class="creatinput1"/><br/>
             
 	<form:label path="blogArthur" class="arthurlabel">Blog Arthur:</form:label>
           <form:input path="blogArthur" name="blogArthur" value= "${firstname}" class="creatinput2"/><br/>
           <form:textarea path="blogContent" name="blogContent" placeholder="Share your thoughts....." class="text-area"/><br/>
           
<input type="submit" value="Share your thoughts" class ="createblogbutton">
</form:form>
</div>
</div>
<a href="${pageContext.request.contextPath }/logout">Logout</a>

<script type="text/javascript" src="resources/Js/app.js"></script>
</body>
</html>


