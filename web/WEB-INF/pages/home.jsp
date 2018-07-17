<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/13/2018
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "ct" uri = "http://cs.mum.edu/cs472wap/efcar/custom/tags"%>


<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        Home page!!!
    </layout:put>
    <layout:put block="styleLinks" type="REPLACE">
        <script src="<c:url value="/resources/js/search.js"/>"></script>
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div class="searchBoxContainer">
            <div class="searchBox">
                <form>
                    <div id="searchFormDiv">
                        <h2>Search a car:</h2>
                        <div class="fieldset"><label>Model name: <input type="text" id="txtModel"></label></div>
                        <div class="fieldset"><label>Type:
                            <select name="type" id="ddlType">
                                <option value="all">all</option>
                                <option value="CONVERTIBLE">Convertible</option>
                                <option value="STANDARD">Standard</option>
                                <option value="PREMIUM">Premium</option>
                                <option value="COMPACT">Compact</option>
                            </select>
                        </label></div>
                        <div class="fieldset"><label>Brand:
                            <select name="brand" id="ddlBrand">
                                <option value="all" >all</option>
                                <c:forEach items="${brands}" var="brand">
                                    <option value="${brand}" >${brand}</option>
                                </c:forEach>
                            </select>
                        </label></div>

                        <div class="fieldset">
                        <label>Start: <ct:currentDateTime/>
                        </label></div>

                        <div class="fieldset">
                            <label>End: <input type="date" id="txtEndDate">
                            </label></div>
                        <input type="button" id="btnSearch" value="search">

                    </div>

                </form>
            </div>
        </div>

        <div class="homeContainer">
            <div class="productsContainer" id="productsContainer">

            </div>
        </div>

    </layout:put>
</layout:extends>
