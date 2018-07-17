<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/15/2018
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://cs.mum.edu/cs472wap/efcar/custom/tags" %>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        <c:out value="Login"/>
    </layout:put>
    <layout:put block="styleLinks" type="REPLACE">
        <link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>"/>
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div id="loginBox">
            <form method="post">
                <h2>Sign In</h2>
                <ct:textField name="username" label="Username" required="true"/>
                <ct:textField name="password" label="Password" required="true" secretText="true"/>
                <div id="loginControls">
                    <button type="submit"><c:out value="Log In"/></button>
                </div>
            </form>
            <a class="loginLink" href="<c:url value='/registration'/>">Create account</a>
        </div>
        <div id="messages">
            <c:if test="${message!=null}">
                <h4><c:out value="${message}"/></h4>
            </c:if>
        </div>
    </layout:put>
</layout:extends>