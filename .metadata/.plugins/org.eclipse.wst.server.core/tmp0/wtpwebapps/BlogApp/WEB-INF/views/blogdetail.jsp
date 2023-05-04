<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="/BlogApp/resources/css/myfile.css"
    rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<!-- <link href="/resources/css/myfile.css"
    rel="stylesheet"> -->
<title>Insert title here</title>
</head>
<body class="blogpage">
        <mytags:navbar/>

<header>
<h2>Changing Lives By Sharing Stories</h2>
</header>


<c:forEach var="blog" items="${blogs}">
<div class="blogitem">

   <h5> BlogName: ${blog.blogTitle }</h5>
    <h4>Written By: ${blog.blogArthur }</h4>
   <div class="blogone"><p>${blog.blogContent }</p></div>
    <p class="datepub"> <b>Date published: ${blog.blogDate }</b></p>
    <%-- ${blog.blogid } --%>
    
    <div class="forlike">
	<a href ="/BlogApp/like${blog.blogid}"><button class='btn btn-primary'>
	    <i class="fa fa-thumbs-up added " min=1 style="font-size:24px"></i>
	</button></a> ${blog.blogLikeCount }
	
	<span class="mylike">${blog.blogLikeCount}</span> 
	</div> 
	</div>
    <div class="blogitemnav">
  <a href="showallblog"><button>Go back to blog page</button> </a>
  <a href="createblog"><button>Write your own blog</button></a>
</div>
	</c:forEach>
		<script type="text/javascript" src="/BlogApp/resources/Js/app.js?203" defer="defer">
		
		</script>
		<footer class="index-footer">
   <p>CopyRight 2023</p>
   </footer>
	</body>
</html>