<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>NewsItem Example - Ajax - XMLHttpRequest and Polling</title>
	<link rel="stylesheet" href="css/opmaak.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
<jsp:include page="header.jsp">
	<jsp:param name="activeItem" value="index"/>
</jsp:include>

<main>
	<h1>UCLL NEWS</h1>
	<div id="newsItemDiv">
		<div id="newsItemRepliesDiv">

		</div>
	</div>


	<div class="add_form">
		<h2>ADD NEWS</h2>
		<form action="Controller">
			<div class="form-group">
				<label for="title_input">Title</label>
				<input type="text" class="form-control" id="title_input" placeholder="Title">
			</div>
			<div class="form-group textarea">
				<label for="text_input">Text</label>
				<textarea name="text_input" id="text_input" cols="30" rows="10" placeholder="Text"></textarea>
			</div>
			<div class="form-group">
				<label for="author_input">Author</label>
				<input type="text" class="form-control" id="author_input" placeholder="Author">
			</div>
			<button type="button" id="addNewsItemButton" type="submit" class="btn  mb-2">Add</button>

		</form>
	</div>
</main>
<script type="text/javascript" src="js/newsItem.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</body>
</html>