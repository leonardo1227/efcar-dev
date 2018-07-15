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
                                    <option value="Sedan">Sedan</option>
                                    <option value="Sport">Sport</option>
                                    <option value="SUV">SUV</option>
                                    <option value="pick-up">pick-up</option>
                                </select>
                            </label><br/><br/>
                            <label>Brand:
                                <select name="brand" id="ddlBrand">
                                    <option value="all">all</option>
                                    <option value="volvo">Volvo</option>
                                    <option value="saab">Saab</option>
                                    <option value="fiat">Fiat</option>
                                    <option value="audi">Audi</option>
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
            <div class="productsContainer">
                <div class="row">
                    <div class="column" style="background-color:#aaa;">
                        <image class="productImage" src="https://car-images.bauersecure.com/pagefiles/74108/toyota_hybrids_01.jpg"></image>
                        <p>Some text..</p>
                    </div>
                    <div class="column" style="background-color:#bbb;">
                        <image class="productImage" src="https://car-images.bauersecure.com/pagefiles/74108/toyota_hybrids_01.jpg"></image>
                        <p>Some text..</p>
                    </div>
                </div>

                <div class="row">
                    <div class="column" style="background-color:#ccc;">
                        <h2>Column 3</h2>
                        <p>Some text..</p>
                    </div>
                    <div class="column" style="background-color:#ddd;">
                        <h2>Column 4</h2>
                        <p>Some text..</p>
                    </div>
                </div>
            </div>
        </div>

    </layout:put>
</layout:extends>
