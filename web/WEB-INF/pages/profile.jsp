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
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        Create Account
    </layout:put>
    <layout:put block="styleLinks">
        <script src="resources/js/registration.js"></script>
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div class="profile">
            <h2>Profile</h2>
            <div class="profileContent">
                <form method="post">
                    <div class="profilePhoto">
                        <img src="<c:url value='${userLogged.photoURL}'/>" alt="no-photo" width="250"/>
                        <div class="editArea">
                            <a href="">Edit</a>
                        </div>
                    </div>

                    <input type="text" name="userName" placeholder="User name" value="${userLogged.username}" required>

                    <input type="text" name="firstName" placeholder="First Name" value="${userLogged.firstName}" required>

                    <input type="text" name="lastName" placeholder="Last Name" value="${userLogged.lastName}" required>

                    <input type="date" name="dateOfBirth" placeholder="Date of birth" value="${userLogged.dateOfBirth}" required>

                    <select class="input-select" name="gender" required>
                        <option value="" disabled <c:if test='${userLogged.gender == ""}'>selected</c:if>>Gender
                        </option>
                        <option value="Male"
                                <c:if test='${userLogged.gender == "Male"}'>selected</c:if> >Male
                        </option>
                        <option value="Female" <c:if test='${userLogged.gender == "Female"}'>selected</c:if>>Female
                        </option>
                    </select>

                    <input type="tel" name="phone" placeholder="Phone" value="${userLogged.contact.phoneNumber}" required/>

                    <input type="email" name="email" placeholder="Email" value="${userLogged.contact.email}" required/>

                    <fieldset>
                        <legend>Address</legend>
                        <input type="text" name="line1" placeholder="Line 1" value="${userLogged.address.line1}" required/>
                        <input type="text" name="line2" placeholder="Line 2 (optional)" value="${userLogged.address.line2}"/>
                        <input type="text" name="city" placeholder="City" required value="${userLogged.address.city}"/>
                        <input type="text" name="state" placeholder="State" required value="${userLogged.address.state}"/>
                        <input type="text" name="zipCode" placeholder="Zip code" required value="${userLogged.address.zipCode}"/>
                    </fieldset>
                    <input type="hidden" name="changeType" value="info">
                    <input type="submit" value="Update"/>
                </form>
                <fieldset>
                    <legend>Change password</legend>
                    <form method="post">
                        <input type="password" id="passwordId" name="password" placeholder="Old Password" required/>
                        <input type="password" id="passwordConfirmId" name="passwordConfirm" placeholder="New password" required/>
                        <input type="hidden" name="changeType" value="password">
                        <input type="submit" value="Change password"/>
                    </form>
                </fieldset>
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

