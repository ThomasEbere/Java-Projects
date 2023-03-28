<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/BlogApp/resources/css/myfile.css"
    rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link href="/resources/css/myfile.css"
    rel="stylesheet">
<title>Insert title here</title>
</head>
<body class="blogpage">
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
<h2>Changing Lives By Sharing Stories</h2>
</header>


<c:forEach var="blog" items="${blogs}">
<div class="blogitem">

   <h5> BlogName: ${blog.blogTitle }</h5>
    <h5>Written By: ${blog.blogArthur }</h5>
   <div class="blogone"><p>${blog.blogContent }</p></div>
    <p class="datepub"> Date published: ${blog.blogDate }</p>
    <%-- ${blog.blogid } --%>
	<!--  <button class='btn btn-primary disabled'>
	    <i class="fa fa-thumbs-up added " style="font-size:24px"></i>
	</button> -->
	
	<span class="mylike">${blog.blogLikeCount}</span>  
	</div>
    <a href="showallblog">Go back to blog page</a>
    <a href="createblog">Write your own blog</a>
	</c:forEach>
		<script type="text/javascript" src="/BlogApp/resources/Js/app.js?203" defer="defer"></script>
	</body>
</html>