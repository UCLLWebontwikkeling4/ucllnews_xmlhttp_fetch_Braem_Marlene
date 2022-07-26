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
    <h2 id="titleSearch"></h2>

    <form action="Controller">
        <div class="form-group">
            <label for="authorSearch">Title</label>
            <input type="text" class="form-control" id="authorSearch" placeholder="Author">
        </div>

        <button type="button" id="searchButton" type="submit" class="btn  mb-2">Search</button>

    </form>

    <h3 id="errorSearch"></h3>

    <table id="searchOverviewDiv" class="table table-striped" >

    </table>

</main>
<script type="text/javascript" src="js/searchReplies.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

</body>
</html>