<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/15/2018
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="cus" uri="http://cs.mum.edu/cs472wap/efcar/custom/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="styleLinks">
        <script src='<c:url value="/resources/js/registration.js"/>'></script>
    </layout:put>
    <layout:put block="titlePage" type="REPLACE">
        Create Account
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div class="registrationForm">
            <h2>Create Account</h2>
            <form method="POST" action="" novalidate="novalidate">

                <cus:validatorInput name="firstName" placeholder="First Name" type="text" value="" required="true"/>

                <cus:validatorInput name="lastName" placeholder="Last Name" type="text" value="" required="true"/>

                <cus:validatorInput name="dateOfBirth" placeholder="Date of Birth" type="date" value="" required="true"/>

                <div class="formInput">
                    <select class="input-select" name="gender" id="gender" required>
                        <option value="" disabled selected>Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                </div>

                <cus:validatorInput name="phone" placeholder="Phone" type="text" value="" required="true"/>

                <cus:validatorInput name="email" placeholder="Email" type="text" value="" required="true"/>

                <fieldset>
                    <legend>Address</legend>
                    <cus:validatorInput name="line1" placeholder="Line 1" type="text" value="" required="true"/>

                    <cus:validatorInput name="line2" placeholder="Line 2 (optional)" type="text" value="" required="false"/>

                    <cus:validatorInput name="city" placeholder="City" type="text" value="" required="true"/>

                    <cus:validatorInput name="state" placeholder="State" type="text" value="" required="true"/>

                    <cus:validatorInput name="zipCode" placeholder="Zip code" type="text" value="" required="true"/>
                </fieldset>

                <cus:validatorInput name="password1" placeholder="Password" type="password" value="" required="true"/>

                <cus:validatorInput name="password2" placeholder="Confirm password" type="password" value="" required="true"/>

                <cus:validatorInput name="userName" placeholder="User Name" type="text" value="" required="true"/>
                <br/>
                <input type="submit" value="Register"/>
            </form>
        </div>
    </layout:put>
</layout:extends>
