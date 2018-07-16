<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/13/2018
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>
        <layout:block name="titlePage">
            Page Title
        </layout:block>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/search.css'/>"/>
    <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/main.css'/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
    <layout:block name="styleLinks">

    </layout:block>
</head>
<body>
<header>
    <layout:block name="header">
        <img src="<c:url value='/resources/images/icon.png'/>" alt="icon-EFcar"/>
        <h1>EF Cart - Rentar car service</h1>
        <div class="headerMenu">
            <c:choose>
                <c:when test="${userLogged!=null}">
                    <form id="logoutForm" method="post" action="logout">
                        <button type="submit"><c:out value="Logout"/></button>
                    </form>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/login"/>"><button><c:out value="Login"/></button></a>
                </c:otherwise>
            </c:choose>
        </div>
    </layout:block>
</header>

<div id="container">
    <layout:block name="content">

    </layout:block>
</div>

<footer>
    <layout:block name="footer">
        Contact Info
    </layout:block>
</footer>
</body>
</html>
