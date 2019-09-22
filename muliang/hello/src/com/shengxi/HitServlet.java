package com.shengxi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HitServlet extends HttpServlet {

    private int initcount;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initcount = Integer.parseInt(config.getInitParameter("init"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //计数加一
        initcount++;
        out.println("<HTML>");
        out.println(" <HEAD><TITLE>BasicServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("You are user number " + String.valueOf(initcount) + " visiting" +
                "our web site" + "\n");
        out.println(" </BODY>");
        out.println("</HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
