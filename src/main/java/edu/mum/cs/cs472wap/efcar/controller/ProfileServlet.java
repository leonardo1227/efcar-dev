package edu.mum.cs.cs472wap.efcar.controller;

import com.google.gson.Gson;
import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import static edu.mum.cs.cs472wap.efcar.Util.Property.SESSION_USER_ATTRIBUTE_NAME;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String changeType = request.getParameter("changeType");

        if (changeType.equals("info")) {
            String userName = request.getParameter("userName");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String line1 = request.getParameter("line1");
            String line2 = request.getParameter("line2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");

            User user = (User) request.getSession().getAttribute(SESSION_USER_ATTRIBUTE_NAME);
            user.setUsername(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDateOfBirth(LocalDate.parse(dateOfBirth));
            user.setGender(gender);
            user.getContact().setPhoneNumber(phone);
            user.getContact().setEmail(email);
            user.getAddress().setLine1(line1);
            user.getAddress().setLine2(line2);
            user.getAddress().setCity(city);
            user.getAddress().setState(state);
            user.getAddress().setZipCode(zipCode);


        } else if (changeType.equals("password")) {
            String newPassword = request.getParameter("newPassword");
            User user = (User) request.getSession().getAttribute(SESSION_USER_ATTRIBUTE_NAME);
            user.setPassword(newPassword);
        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        out.print(new Gson().toJson("{changeType: " + changeType + "}"));
    }
}
