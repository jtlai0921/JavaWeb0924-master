package com.mycompany.web.ctag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class BMI implements Tag {
    private PageContext pageContext;
    private Tag parenTag;
    private double h, w, bmi;
    
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parenTag = tag;
    }

    @Override
    public Tag getParent() {
        return parenTag;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setW(double w) {
        this.w = w;
    }
    
    @Override
    public int doStartTag() throws JspException {
        bmi = w / Math.pow(h/100, 2);
        return Tag.EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            out.println(String.format("身高: %.2f  體重: %.2f  BMI: %.2f", h, w, bmi));
        } catch (Exception e) {
        }
        
        return (bmi >= 18 && bmi <= 23)?Tag.EVAL_PAGE:Tag.SKIP_PAGE;
        
    }

    @Override
    public void release() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
