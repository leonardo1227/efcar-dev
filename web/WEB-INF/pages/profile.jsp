<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/16/2018
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="cus" uri="http://cs.mum.edu/cs472wap/efcar/custom/tags" %>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        Create Account
    </layout:put>
    <layout:put block="styleLinks">
        <script src="resources/js/profile.js"></script>
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div class="profile">
            <h2>Profile</h2>
            <div class="profileContent">
                <form id="informationForm" method="post">
                    <div class="profilePhoto">
                        <img src="<c:url value='${userLogged.photoURL}'/>" alt="no-photo" width="250"/>
                        <div class="editArea">
                            <a href="">Edit</a>
                        </div>
                    </div>

                    <cus:validatorInput name="userName" placeholder="User name" type="text"
                                        value="${userLogged.username}" required="true"/>

                    <cus:validatorInput name="firstName" placeholder="First Name" type="text"
                                        value="${userLogged.firstName}" required="true"/>

                    <cus:validatorInput name="lastName" placeholder="Last Name" type="text"
                                        value="${userLogged.lastName}" required="true"/>

                    <cus:validatorInput name="dateOfBirth" placeholder="Date of birth" type="date"
                                        value="${userLogged.dateOfBirth}" required="true"/>

                    <div class="formInput">
                        <select class="input-select" name="gender" required>
                            <option value="" disabled <c:if test='${userLogged.gender == ""}'>selected</c:if>>Gender
                            </option>
                            <option value="Male"
                                    <c:if test='${userLogged.gender == "Male"}'>selected</c:if> >Male
                            </option>
                            <option value="Female" <c:if test='${userLogged.gender == "Female"}'>selected</c:if>>Female
                            </option>
                        </select>
                    </div>

                    <cus:validatorInput name="phone" placeholder="Phone" type="tel"
                                        value="${userLogged.contact.phoneNumber}"
                                        required="true"/>

                    <cus:validatorInput name="email" placeholder="Email" type="email"
                                        value="${userLogged.contact.email}"
                                        required="true"/>

                    <fieldset>
                        <legend>Address</legend>
                        <cus:validatorInput name="line1" placeholder="Line 1" type="text"
                                            value="${userLogged.address.line1}" required="true"/>
                        <cus:validatorInput name="line2" placeholder="Line 2 (optional)" type="text"
                                            value="${userLogged.address.line2}" required="false"/>
                        <cus:validatorInput name="city" placeholder="City" type="text"
                                            value="${userLogged.address.city}" required="true"/>
                        <cus:validatorInput name="state" placeholder="State" type="text"
                                            value="${userLogged.address.state}" required="true"/>
                        <cus:validatorInput name="zipCode" placeholder="Zip code" type="text"
                                            value="${userLogged.address.zipCode}" required="true"/>
                    </fieldset>
                    <input type="hidden" name="changeType" value="info">
                    <input type="submit" value="Update"/>
                </form>
                <fieldset>
                    <legend>Change password</legend>
                    <form id="resetPasswordForm" method="post">
                        <cus:validatorInput name="newPassword" placeholder="New password" type="password" value=""
                                            required="true"/>

                        <cus:validatorInput name="newPasswordConfirm" placeholder="Confirm password" type="password"
                                            value="" required="true"/>
                        <input type="hidden" name="changeType" value="password">
                        <input type="submit" value="Change password"/>
                    </form>
                </fieldset>

                <div class="messagePost">
                        ${change}
                </div>
            </div>

            <c:if test="${fn:length(userLogged.bookings) > 0}">
                <div class="profileContent profileHistory">
                    <hr>
                    <h3>History</h3>
                    <table>
                        <tr>
                            <th>N°</th>
                            <th>Brand</th>
                            <th>Model</th>
                            <th>Year</th>
                            <th>plate</th>
                            <th>Color</th>
                            <th>Price/Day</th>
                            <th>Pick Up Date</th>
                            <th>Drop Off Date</th>
                            <th>Payment Method</th>
                            <th>Total</th>
                        </tr>

                        <c:forEach items="${userLogged.bookings}" var="item">
                            <tr>
                                <td>${item.id}</td>
                                <td>${item.car.model.brand.name}</td>
                                <td>${item.car.model.name}</td>
                                <td>${item.car.model.year}</td>
                                <td>${item.car.plate}</td>
                                <td>${item.car.color}</td>
                                <td>$${item.car.model.pricePerDay}</td>
                                <td>${item.pickUpDate}</td>
                                <td>${item.dropOffDate}</td>
                                <td>${item.payment.cardType}</td>
                                <td>$${item.finalTotalPrice}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:if>
        </div>
    </layout:put>
</layout:extends>

