<%--
  Created by IntelliJ IDEA.
  User: Edwin-Cobos
  Date: 7/16/2018
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance" prefix="layout"%>
<layout:extends name="base">
    <layout:put block="titlePage" type="REPLACE">
        Create Account
    </layout:put>
    <layout:put block="content" type="REPLACE">
        <div class="profile">
            <h2>Profile</h2>
            <form class="profileContent" method="post">
                <div class="profilePhoto">
                    <img src="resources/images/no-photo.jpg" alt="no-photo" width="250" />
                    <div class="editArea">
                        <a href="">Edit</a>
                    </div>
                </div>

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

                <fieldset>
                    <legend>Change password</legend>
                    <input type="password" placeholder="Old Password" required/>
                    <input type="password" placeholder="New password" required/>
                </fieldset>

                <input type="submit" value="Update" />
            </form>

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
                        <th>Payment</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Chevrolet</td>
                        <td>Spark</td>
                        <td>2016</td>
                        <td>RGX785</td>
                        <td>Red</td>
                        <td>$30.0</td>
                        <td>12/06/1988</td>
                        <td>12/26/1988</td>
                        <td>$600.0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Chevrolet</td>
                        <td>Spark</td>
                        <td>2016</td>
                        <td>RGX785</td>
                        <td>Red</td>
                        <td>$30.0</td>
                        <td>12/06/1988</td>
                        <td>12/26/1988</td>
                        <td>$600.0</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Chevrolet</td>
                        <td>Spark</td>
                        <td>2016</td>
                        <td>RGX785</td>
                        <td>Red</td>
                        <td>$30.0</td>
                        <td>12/06/1988</td>
                        <td>12/26/1988</td>
                        <td>$600.0</td>
                    </tr>
                </table>
            </div>
        </div>
    </layout:put>
</layout:extends>

