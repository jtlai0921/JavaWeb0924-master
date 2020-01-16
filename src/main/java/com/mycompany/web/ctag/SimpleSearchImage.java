package com.mycompany.web.ctag;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SimpleSearchImage extends SimpleTagSupport {
    private String keyword;

    public void setKeyword(String keyword) {
        try {
            this.keyword = URLEncoder.encode(keyword, "UTF-8");
        } catch (Exception e) {
            this.keyword = keyword;
        }
        
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String google_url = "https://www.google.com/search?q=%s&tbm=isch";
        Document doc = Jsoup.connect(String.format(google_url, keyword))
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .get();
        String image_url = doc.select("td[style=\"width:25%;word-wrap:break-word\"]").get(0).select("img").attr("src");
        out.print(String.format("<img src='%s'>", image_url));
    }
    
}
