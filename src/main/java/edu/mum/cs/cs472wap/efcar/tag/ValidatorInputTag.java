package edu.mum.cs.cs472wap.efcar.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ValidatorInputTag extends SimpleTagSupport {

    private String name;
    private String placeholder;
    private String value;
    private String type;
    private boolean required;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        out.println("<div class='formInput'>");
        out.println("<input type='" + type + "' id='" + name + "' name='" + name + "' placeholder='" + placeholder + "' value='" + value + "'");
        if (required)
            out.println(" required");
        out.println(">");
        out.println("</div>");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
