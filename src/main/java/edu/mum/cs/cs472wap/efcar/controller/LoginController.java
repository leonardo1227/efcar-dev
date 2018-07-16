package edu.mum.cs.cs472wap.efcar.controller;

import edu.mum.cs.cs472wap.efcar.Util.Property;
import edu.mum.cs.cs472wap.efcar.data.DataService;
import edu.mum.cs.cs472wap.efcar.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirectUrl = (String) req.getAttribute(Property.ORIGIN_REQUEST_URL);

        Optional<User> user = DataService.getUsers().entrySet().stream()
                .filter(x -> x.getValue().getUsername().equals(req.getParameter("username")))
                .map(Map.Entry::getValue)
                .findFirst();
        if(user.isPresent() && user.get().getPassword().equals(req.getParameter("password"))){
            HttpSession session = req.getSession();
            session.setAttribute(Property.SESSION_USER_ATTRIBUTE_NAME,user.get());
            if(redirectUrl!=null){
                resp.sendRedirect(redirectUrl);
            }else{
                resp.sendRedirect(req.getContextPath()+"/home");
            }
        }else{
            if(redirectUrl!=null){
                req.setAttribute(Property.ORIGIN_REQUEST_URL,redirectUrl);
            }
            req.setAttribute("message","Invalid user, Try it again!");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);//

        }

    }
}
