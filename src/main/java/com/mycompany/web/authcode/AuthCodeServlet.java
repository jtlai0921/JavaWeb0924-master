package com.mycompany.web.authcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/AuthCodeServlet")
public class AuthCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 取得驗證碼
        String authCode = String.format("%04d", new Random().nextInt(1000));
        System.out.println("authCode = " + authCode);
        
        //將驗證碼保留在session中，便於以後驗證
        req.getSession().setAttribute("authCode", authCode);  
        try {
            //發送/寫入圖片資料  
            ImageIO.write(getAuthCodeImage(authCode), "JPEG", resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 產生暫存圖
    public BufferedImage getAuthCodeImage(String authCode) {
        // 建立圖像暫存區
        BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_BGR);
        // 建立畫布
        Graphics g = img.getGraphics();
        // 設定顏色
        g.setColor(Color.YELLOW);
        // 塗滿背景
        g.fillRect(0, 0, 80, 30);
        // 設定顏色
        g.setColor(Color.BLACK);
        // 設定自型
        //g.setFont(new Font("新細明體", Font.PLAIN, 30));
        // 繪字串
        //g.drawString(authCode, 3, 25); // code, x, y
        
        g.setFont(new Font("新細明體", Font.PLAIN, 12));
        g.drawString(authCode.charAt(0)+"", 3, 17); // code, x, y
        g.setFont(new Font("新細明體", Font.PLAIN, 30));
        g.drawString(authCode.charAt(1)+"", 10, 25); // code, x, y
        g.setFont(new Font("新細明體", Font.PLAIN, 18));
        g.drawString(authCode.charAt(2)+"", 40, 25); // code, x, y
        g.setFont(new Font("新細明體", Font.PLAIN, 10));
        if(authCode.charAt(3) % 2 == 0)
            g.drawString(authCode.charAt(3)+"", 65, 10); // code, x, y
        else
            g.drawString(authCode.charAt(3)+"", 65, 27); // code, x, y    
        
        // 干擾線條
        g.setColor(Color.BLUE);
        for (int i = 1; i <= 20; i++) {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            int x = random.nextInt(80);
            int y = random.nextInt(30);
            int x2 = random.nextInt(80);
            int y2 = random.nextInt(30);
            g.drawLine(x, y, x2, y2);
        }
        return img;
    }
    
}

