package com.sehngxi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: matthew
 * @ClassName ${NAME}
 * @Date: 2019-09-18 10:49
 * @Version: 1.0.0
 * @description:
 */
//@WebServlet(name = "HitServlet")
public class HitServlet extends HttpServlet {

    private Integer initcount;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        initcount= Integer.parseInt(config.getInitParameter("init"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        initcount++;
        writer.println("<html>");
        writer.println("<HEAD><TITLE>BASICSERVLET</TITLE></HEAD>");
        writer.println("<BODY>");
        writer.println("You are user number " + initcount
         + "visiting our web site \n");
        writer.println("</BODY>");
        writer.println("</HTML>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
