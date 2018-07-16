package edu.mum.cs.cs472wap.efcar.controller;

import com.google.gson.Gson;
import edu.mum.cs.cs472wap.efcar.Util.Property;
import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.BookingCar;
import edu.mum.cs.cs472wap.efcar.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("carId");
        String date = req.getParameter("date");
        LocalDate localDate = LocalDate.parse(date);
        Car car = DataService.getCarById(Long.parseLong(carId));
        BookingCar bk = new BookingCar();
        bk.setCar(car);
        bk.setPickUpDate(localDate);

        req.getSession().setAttribute(Property.SESSION_BOOKING_ATTRIBUTE_NAME, bk);
        req.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(req, resp);
    }
}
