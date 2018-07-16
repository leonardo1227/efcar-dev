<%--
  Created by IntelliJ IDEA.
  User: Leonardo Samuel T C
  Date: 7/14/2018
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://cs.mum.edu/cs472wap/efcar/custom/tags" %>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        <c:out value="Payment"/>
    </layout:put>
    <layout:put block="styleLinks" type="REPLACE">
        <link rel="stylesheet" href="<c:url value="/resources/css/payment.css"/>"/>
        <script src="<c:url value='/resources/js/payment.js'/>" type="text/javascript"></script>
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div>
            <form method="post">
                <fieldset id="paymentFieldSetInformation">
                    <div id="cardIcon"></div>
                    <legend><c:out value="Payment Information"/></legend>
                    <ct:textField name="cardNameHolder" label="Card Name Holder" inputSize="40" required="true"/>
                    <ct:textField name="cardNumber" label="Card Number" inputSizeTyping="16" pattern="\d{16}"
                                  required="true" id="cardNumber"/>
                    <ct:textField name="cardCVC" label="Card CVC" inputSizeTyping="3" pattern="\d{2,3}"
                                  required="true"/>
                    <ct:textField name="cardDueDate" label="Card Due Date" inputSizeTyping="7" pattern="\d{2}/\d{4}"
                                  required="true"/>
                    <div class="fieldInformation">
                        <label><c:out value="Card Number"/></label>
                        <select name="cardType" required>
                            <option disabled selected>Select one</option>
                            <option value="<c:out value='Credit'/>"><c:out value='Credit'/></option>
                            <option value="<c:out value='Debit'/>"><c:out value='Debit'/></option>
                        </select>
                    </div>
                </fieldset>
                <div id="controlPaymentDiv">
                    <button type="submit"><c:out value="Pay and Book"/></button>
                </div>
            </form>
        </div>
    </layout:put>
</layout:extends>
