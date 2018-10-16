package com.zozospider.overview;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/my/servlet/async", asyncSupported = true)
public class MyServletAsync extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(() -> {
            try {
                resp.getWriter().println("hello servlet async!");
                // 触发完成
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
