package com.mycompany.web.async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/jobs/asyncLongjob", asyncSupported = true)
public class AsyncLongJobServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        // 1.進入 Servlet 
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("1.進入Servlet的時間：" + new Date() + ".<p>");
        out.flush();
        // 2.在子執行緒中執行任務調用，並由其負責輸出響應，主執行緒退出
        AsyncContext ctx = req.startAsync();
        new Thread(new LongJob(ctx)).start();

        out.println("3.結束Servlet的時間：" + new Date() + ".<p>");
        out.flush();
        // 3.離開 Servlet 給其他請求連線使用
    }

    class LongJob implements Runnable {
        private AsyncContext ctx = null;
        public LongJob(AsyncContext ctx) {
            this.ctx = ctx;
        }
        public void run() {
            try {
                // 等待10秒鐘，用來模擬任務所需要的時間
                Thread.sleep(10000);
                PrintWriter out = ctx.getResponse().getWriter();
                out.println("2.任務處理完畢的時間：" + new Date() + ".<p>");
                out.flush();
                ctx.complete(); // 任務完成
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
