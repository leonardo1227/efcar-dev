package edu.mum.cs.cs472wap.efcar.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentDateTag extends SimpleTagSupport {


    @Override
    public void doTag() throws JspException, IOException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String textDate = date.format(fm);
        JspWriter out = getJspContext().getOut();
        out.write("<input type=\"date\" id=\"txtDate\">");
        out.println();
    }

}
