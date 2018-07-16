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
        <div class="searchBoxContainer">
            <div class="searchBox">
                <form>
                    <div id="searchFormDiv">
                        <fieldset>
                            <legend>Search a car:</legend>
                            <label>Model name: <input type="text" id="txtModel"><br/><br/></label>
                            <label>Type:
                                <select name="type" id="ddlType">
                                    <option value="all">all</option>
                                    <option value="CONVERTIBLE">Convertible</option>
                                    <option value="STANDARD">Standard</option>
                                    <option value="PREMIUM">Premium</option>
                                    <option value="COMPACT">Compact</option>
                                </select>
                            </label><br/><br/>
                            <label>Brand:
                                <select name="brand" id="ddlBrand">
                                    <option value="all">all</option>
                                    <option value="Volvo">Volvo</option>
                                    <option value="Ford">Ford</option>
                                    <option value="Fiat">Fiat</option>
                                    <option value="Audi">Audi</option>
                                </select>
                            </label>
                            <br/><br/>
                            <label>Data: <input type="date" id="txtDate"></label><br/><br/>
                            <input type="button" id="btnSearch" value="search">
                        </fieldset>
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
