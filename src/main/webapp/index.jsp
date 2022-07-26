<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NewsItem Example - Ajax - XMLHttpRequest and Polling</title>
</head>
<body>
	<h1>NewsItem of the moment ...</h1>
	<div id="newsItem"></div>
	<div>
		<p>
			<label>Name</label>
			<input type="text" id="lectorname"/>
		</p>
		<p>
			<label>FirstName</label>
			<input type="text" id="lectorfirstname"/>
		</p>
		<p>
			<input type="button" id="addlectorbutton" value="Add NewsItem" />
		</p>
	</div>
	<script type="text/javascript" src="js/lector.js"></script>
</body>
</html>