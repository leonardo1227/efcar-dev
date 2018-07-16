<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/15/2018
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        <c:out value="Booking Info Confirmation"/>
    </layout:put>
    <layout:put block="styleLinks" type="REPLACE">
        <link rel="stylesheet" href="<c:url value="/resources/css/bookingInfoConfirmation.css"/>"/>
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div>
            <h3><c:out value="Your rent car booking was successfully done. Thank your for renting a car with us.
                Following there is the complete information about your booking:"/></h3>
            <fieldset>
                <legend><c:out value="Car Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="Brand: ${bookingCar.car.model.brand.name}"/></label>
                    <label><c:out value="Model: ${bookingCar.car.model.name}"/></label>
                    <label><c:out value="Year: ${bookingCar.car.model.year}"/></label>
                    <label><c:out value="Car Type: ${bookingCar.car.model.carType}"/></label>
                    <label><c:out value="Motor Potency: ${bookingCar.car.model.motorPotency}"/></label>
                    <label><c:out value="Capacity Of People: ${bookingCar.car.model.capacityOfPeople}"/></label>
                    <label><c:out value="Price Per Day: $${bookingCar.car.model.pricePerDay}"/></label>
                    <label><c:out value="Plate: ${bookingCar.car.plate}"/></label>
                    <label><c:out value="Color: ${bookingCar.car.color}"/></label>
                </div>
            </fieldset>
            <fieldset>
                <legend><c:out value="Client Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="First Name: ${bookingCar.user.firstName}"/></label>
                    <label><c:out value="Last Name: ${bookingCar.user.lastName}"/></label>
                    <label><c:out value="Date Of Birth: ${bookingCar.user.dateOfBirth}"/></label>
                    <label><c:out value="Gender: ${bookingCar.user.gender}"/></label>
                </div>
                <fieldset>
                    <legend><c:out value="Contact"/></legend>
                    <div class="twoColumns">
                        <label><c:out value="E-Mail: ${bookingCar.user.contact.email}"/></label>
                        <label><c:out value="Phone: ${bookingCar.user.contact.phoneNumber}"/></label>
                    </div>
                </fieldset>
                <fieldset>
                    <legend><c:out value="Address"/></legend>
                    <div class="twoColumns">
                        <label><c:out value="Address Line1: ${bookingCar.user.address.line1}"/></label>
                        <label><c:out value="Address Line2: ${bookingCar.user.address.line2}"/></label>
                        <label><c:out value="City: ${bookingCar.user.address.city}"/></label>
                        <label><c:out value="State: ${bookingCar.user.address.state}"/></label>
                        <label><c:out value="Zipcode: ${bookingCar.user.address.zipCode}"/></label>
                    </div>
                </fieldset>
            </fieldset>
            <fieldset>
                <legend><c:out value="Payment Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="Card Type: ${bookingCar.payment.cardType}"/></label>
                    <label><c:out value="Card Name Holder: ${bookingCar.payment.cardNameHolder}"/></label>
                    <label><c:out value="Card Number: ${bookingCar.payment.cardNumber}"/></label>
                    <label><c:out value="Card Due Date: ${bookingCar.payment.cardDueDate}"/></label>
                    <label><c:out value="Card CV Number: ${bookingCar.payment.cardCVNumber}"/></label>
                    <label><c:out value="Total Price Of The Booking: ${bookingCar.totalPrice}"/></label>
                </div>
            </fieldset>
            <fieldset>
                <legend><c:out value="Booking Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="Pick Up Date: ${bookingCar.pickUpDate}"/></label>
                    <label><c:out value="Drop Off Date: ${bookingCar.dropOffDate}"/></label>
                </div>
            </fieldset>

        </div>
    </layout:put>
</layout:extends>
