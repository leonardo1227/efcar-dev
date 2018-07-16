package edu.mum.cs.cs472wap.efcar.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookingInfoConfirmation", urlPatterns = "/bookingInfoConfirmation")
public class BookingInfoConfirmation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/bookingInfoConfirmation.jsp").forward(req,resp);
    }
}
