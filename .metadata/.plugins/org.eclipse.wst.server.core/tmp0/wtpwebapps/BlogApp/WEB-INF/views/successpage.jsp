<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link href="resources/css/myfile.css?v=3"
    rel="stylesheet">
</head>
<body>

<body>
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
<h2>We hope you find something that delight you</h2>
</header>
<div class="successpage">
<h2>Hurrayyyyy!! You have successfully created your first Blog</h2> 
<a href="viewblog"><button>click here to view the blog</button> </a>
</div>
<footer class="index-footer">
   <p>CopyRight 2023</p>
   </footer>
</body>
</html>