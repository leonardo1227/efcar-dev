package edu.mum.cs.cs472wap.efcar.controller;

import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.Person;
import edu.mum.cs.cs472wap.efcar.model.PersonAddress;
import edu.mum.cs.cs472wap.efcar.model.PersonContact;
import edu.mum.cs.cs472wap.efcar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String password = request.getParameter("password1");

        Person person = new Person((long) DataService.getUserList().size(),
                firstName,
                lastName,
                LocalDate.parse(dateOfBirth),
                gender,
                new PersonContact(1L, email, phone),
                new PersonAddress(1L, line1, line2, city, state, zipCode),
                request.getContextPath()+"/resources/images/no-photo.jpg");
        User user = new User(userName, password, person);
        DataService.setNewUser(user);

        response.sendRedirect(request.getContextPath() + "/login");
    }
}
