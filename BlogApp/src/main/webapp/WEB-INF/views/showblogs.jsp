<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/myfile.css"
    rel="stylesheet">
</head>
<body >
<c:forEach var ="blog" items="${blogs}">

</c:forEach>
</body>
</html>