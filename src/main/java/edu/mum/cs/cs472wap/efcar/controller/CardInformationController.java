package edu.mum.cs.cs472wap.efcar.controller;

import com.google.gson.Gson;
import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.CardInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cardInformationController", urlPatterns = "/cardInformationController")
public class CardInformationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        CardInfo cardInfo = DataService.getCardInfoMap().get(Long.valueOf(req.getParameter("code")));
        out.print(new Gson().toJson(cardInfo));
    }
}
