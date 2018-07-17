package edu.mum.cs.cs472wap.efcar.listener;

import edu.mum.cs.cs472wap.efcar.data.DataService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
            DataService.loadDataBase();
            DataService.getCardInfoMap().entrySet().stream()
                    .forEach(x -> x.getValue().setIconUrl(servletContextEvent.getServletContext().getContextPath()+x.getValue().getIconUrl()));
        }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
