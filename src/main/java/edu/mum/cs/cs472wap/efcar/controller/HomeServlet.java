package edu.mum.cs.cs472wap.efcar.controller;

import edu.mum.cs.cs472wap.efcar.data.DataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> brands = DataService.getBrands();
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
