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
        <div class="confirmation">
            <h2>Confirmation</h2>
            <h3><c:out value="Your rent car booking was successfully done. Thank your for renting a car with us.
                Following there is the complete information about your booking:"/></h3>
            <fieldset>
                <legend><c:out value="Car Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="Brand: ${rentCarBooking.car.model.brand.name}"/></label>
                    <label><c:out value="Model: ${rentCarBooking.car.model.name}"/></label>
                    <label><c:out value="Year: ${rentCarBooking.car.model.year}"/></label>
                    <label><c:out value="Car Type: ${rentCarBooking.car.model.type}"/></label>
                    <label><c:out value="Motor Potency: ${rentCarBooking.car.model.motorPotency}"/></label>
                    <label><c:out value="Capacity Of People: ${rentCarBooking.car.model.capacityOfPeople}"/></label>
                    <label><c:out value="Price Per Day: $${rentCarBooking.car.model.pricePerDay}"/></label>
                    <label><c:out value="Plate: ${rentCarBooking.car.plate}"/></label>
                    <label><c:out value="Color: ${rentCarBooking.car.color}"/></label>
                </div>
            </fieldset>
            <fieldset>
                <legend><c:out value="Client Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="First Name: ${rentCarBooking.user.firstName}"/></label>
                    <label><c:out value="Last Name: ${rentCarBooking.user.lastName}"/></label>
                    <label><c:out value="Date Of Birth: ${rentCarBooking.user.dateOfBirth}"/></label>
                    <label><c:out value="Gender: ${rentCarBooking.user.gender}"/></label>
                </div>
                <fieldset>
                    <legend><c:out value="Contact"/></legend>
                    <div class="twoColumns">
                        <label><c:out value="E-Mail: ${rentCarBooking.user.contact.email}"/></label>
                        <label><c:out value="Phone: ${rentCarBooking.user.contact.phoneNumber}"/></label>
                    </div>
                </fieldset>
                <fieldset>
                    <legend><c:out value="Address"/></legend>
                    <div class="twoColumns">
                        <label><c:out value="Address Line1: ${rentCarBooking.user.address.line1}"/></label>
                        <label><c:out value="Address Line2: ${rentCarBooking.user.address.line2}"/></label>
                        <label><c:out value="City: ${rentCarBooking.user.address.city}"/></label>
                        <label><c:out value="State: ${rentCarBooking.user.address.state}"/></label>
                        <label><c:out value="Zipcode: ${rentCarBooking.user.address.zipCode}"/></label>
                    </div>
                </fieldset>
            </fieldset>
            <fieldset>
                <legend><c:out value="Payment Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="Card Type: ${rentCarBooking.payment.cardType}"/></label>
                    <label><c:out value="Card Name Holder: ${rentCarBooking.payment.cardNameHolder}"/></label>
                    <label><c:out value="Card Number: ${rentCarBooking.payment.cardNumber}"/></label>
                    <label><c:out value="Card Due Date: ${rentCarBooking.payment.cardDueDate}"/></label>
                    <label><c:out value="Card CV Number: ${rentCarBooking.payment.cardCVNumber}"/></label>
                    <label><c:out value="Total Price Of The Booking: ${rentCarBooking.totalPrice}"/></label>
                </div>
            </fieldset>
            <fieldset>
                <legend><c:out value="Booking Information"/></legend>
                <div class="twoColumns">
                    <label><c:out value="Pick Up Date: ${rentCarBooking.pickUpDate}"/></label>
                    <label><c:out value="Drop Off Date: ${rentCarBooking.dropOffDate}"/></label>
                    <label><c:out value="Number of Days: ${rentCarBooking.daysOfRent}"/></label>
                </div>
            </fieldset>

        </div>
    </layout:put>
</layout:extends>
