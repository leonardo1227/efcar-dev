<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/13/2018
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        Home page!!!
    </layout:put>
    <layout:put block="content" type="REPLACE">
        This is the content!!!
    </layout:put>
</layout:extends>
