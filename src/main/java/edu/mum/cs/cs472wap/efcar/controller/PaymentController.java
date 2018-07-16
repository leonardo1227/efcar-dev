package edu.mum.cs.cs472wap.efcar.controller;

import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.BookingCar;
import edu.mum.cs.cs472wap.efcar.model.CardType;
import edu.mum.cs.cs472wap.efcar.model.Payment;
import edu.mum.cs.cs472wap.efcar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "paymentController", urlPatterns = "/payment")
public class PaymentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Payment payment = new Payment();
        Random random = new Random();
        payment.setId(random.nextLong());
        payment.setCardNameHolder(req.getParameter("cardNameHolder"));
        payment.setCardNumber(req.getParameter("cardNumber"));
        payment.setCardCVNumber(req.getParameter("cardCVC"));
        payment.setCardDueDate(req.getParameter("cardDueDate"));
        payment.setCardType(CardType.valueOf(req.getParameter("cardType")));

        BookingCar bookingCar = (BookingCar) session.getAttribute("bookingCar");///<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

        bookingCar.setPayment(payment);
        User user = (User) session.getAttribute("userLogged");
        bookingCar.setUser(user);
        bookingCar.setStarMilleage(bookingCar.getCar().getMileage());
        bookingCar.setTotalPrice(bookingCar.getCar().getModel().getPricePerDay() * bookingCar.getDaysOfRent());

        session.setAttribute("bookingCar", bookingCar);
        DataService.getUsers().get(user.getId()).getBookings().add(bookingCar);

        resp.sendRedirect(req.getContextPath()+"/bookingInfoConfirmation");


    }
}
