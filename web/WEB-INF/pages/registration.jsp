<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/15/2018
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        Create Account
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div class="registrationForm">
            <h2>Create Account</h2>
            <form method="POST" action="">

                <input type="text" placeholder="First Name" required>

                <input type="text" placeholder="Last Name" required>

                <input type="date" placeholder="Date of birth">

                <select class="input-select" required>
                    <option value="" disabled selected>Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>

                <input type="tel" placeholder="Phone" required/>

                <input type="email" placeholder="Email" required/>

                <fieldset>
                    <legend>Address</legend>
                    <input type="text" placeholder="Line 1" required/>
                    <input type="text" placeholder="Line 2 (optional)" />
                    <input type="text" placeholder="City" required/>
                    <input type="text" placeholder="State" required/>
                    <input type="text" placeholder="Zip code" required/>
                </fieldset>

                <input type="password" placeholder="Password" required/>
                <input type="password" placeholder="Confirm password" required/>

                <input type="submit" value="Register" />
            </form>
        </div>
    </layout:put>
</layout:extends>
