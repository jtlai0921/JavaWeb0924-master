package com.mycompany.web.ctag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class Loop implements IterationTag {
    private PageContext pageContext;
    private Tag parentTag;
    private int count;
    
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

    public void setCount(int count) {
        this.count = count;
    }
    
    @Override
    public int doStartTag() throws JspException {
        return Tag.EVAL_BODY_INCLUDE;
    }
    
    @Override
    public int doAfterBody() throws JspException {
        return (--count == 0)?Tag.SKIP_BODY:IterationTag.EVAL_BODY_AGAIN;
    }
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }

    @Override
    public void release() {
        
    }
    
}
