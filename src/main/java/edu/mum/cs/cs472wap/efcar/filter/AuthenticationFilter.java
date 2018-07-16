package edu.mum.cs.cs472wap.efcar.filter;

import edu.mum.cs.cs472wap.efcar.Util.Property;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter",
        urlPatterns = {"/payment",
                "/bookingInfoConfirmation",
                "/profile"
})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(session!=null && session.getAttribute(Property.SESSION_USER_ATTRIBUTE_NAME)!=null){
            filterChain.doFilter(request,response);
        }else{
            request.setAttribute(Property.ORIGIN_REQUEST_URL,request.getRequestURL().toString());
            request.getRequestDispatcher("/login").forward(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
