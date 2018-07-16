package edu.mum.cs.cs472wap.efcar.Tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class TextFieldTag extends SimpleTagSupport {
    String label;
    String name;
    Boolean required;
    String id;
    String value;
    String inputSize;
    String inputSizeTyping;
    String pattern;
    Boolean secretText;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        StringBuilder htmlStringBuilder = new StringBuilder();

        htmlStringBuilder.append("<div class='fieldInformation'>");
        htmlStringBuilder.append("<label>" + label + "</label>");
        //htmlStringBuilder.append("<label> <c:out value='"+label+"'/> </label>");
        htmlStringBuilder.append("<input name='" + name + "' ");
        if (required != null) {
            if (required) {
                htmlStringBuilder.append("required ");
            }
        }
        if (secretText != null && secretText) {
            htmlStringBuilder.append("type='password' ");
        } else {
            htmlStringBuilder.append("type='text' ");
        }
        if (id != null) {
            htmlStringBuilder.append("id='" + id + "' ");
        }
        if (value != null) {
            htmlStringBuilder.append("value='" + value + "' ");
        }
        if (inputSize != null) {
            htmlStringBuilder.append("size='" + inputSize + "' ");
        }
        if (inputSizeTyping != null) {
            htmlStringBuilder.append("maxlength='" + inputSizeTyping + "' ");
        }
        if (pattern != null) {
            htmlStringBuilder.append("pattern='" + pattern + "' ");
        }

        htmlStringBuilder.append("/></div>");
        out.write(htmlStringBuilder.toString());

    }


    public void setId(String id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setRequired(Boolean required) {
        this.required = required;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    public void setInputSize(String inputSize) {
        this.inputSize = inputSize;
    }


    public void setInputSizeTyping(String inputSizeTyping) {
        this.inputSizeTyping = inputSizeTyping;
    }


    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setSecretText(Boolean secretText) {
        this.secretText = secretText;
    }
}
