package com.mycompany.web.ctag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class Search implements BodyTag {
    private PageContext pageContext;
    private Tag parentTag;
    private String marker;
    private BodyContent bodyContent;
    
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }

    @Override
    public void setParent(Tag tag) {
        parentTag = tag;
    }

    @Override
    public Tag getParent() {
        return parentTag;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
    
    @Override
    public int doStartTag() throws JspException {
        return BodyTag.EVAL_BODY_BUFFERED;
    }

    @Override
    public void setBodyContent(BodyContent bc) {
        bodyContent = bc;
    }

    @Override
    public void doInitBody() throws JspException {
    }
    
    @Override
    public int doAfterBody() throws JspException {
        JspWriter out = bodyContent.getEnclosingWriter();
        String content = bodyContent.getString();
        content = content.replaceAll(marker, "<font color=red>" + marker + "</font>");
        try {
            out.print(content);
        } catch (IOException ex) {
        }
        return Tag.SKIP_BODY;
    }
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
