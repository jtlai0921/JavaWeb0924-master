/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.web.filter;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {

    private PrintWriter out;
    private CharArrayWriter bufferedWriter;

    public MyResponse(HttpServletResponse response) {
        super(response);
        bufferedWriter = new CharArrayWriter();
        out = new PrintWriter(bufferedWriter);
    }

    @Override
    public PrintWriter getWriter() {
        return out;
    }

    public String getResult() {
        return bufferedWriter.toString();
    }
}
