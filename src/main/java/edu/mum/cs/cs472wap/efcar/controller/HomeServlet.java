package edu.mum.cs.cs472wap.efcar.controller;

import com.google.gson.Gson;
import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> brands = DataService.getBrands();
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String model = req.getParameter("model");
        String type = req.getParameter("type");
        String brand = req.getParameter("brand");
        String date = req.getParameter("date");
        LocalDate localDate = LocalDate.parse(date);

        List<Car>  listCar = DataService.getCarListSearch(type, brand, model, localDate);

        try{
            String json = new Gson().toJson(listCar);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
