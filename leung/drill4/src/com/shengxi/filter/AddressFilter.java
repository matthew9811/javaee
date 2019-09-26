package com.shengxi.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chuling
 * 禁止某个地址访问hello.jsp
 */
@WebFilter(filterName = "AddressFilter", initParams = {
        @WebInitParam(name = "addressProhibited", value = "192.168.1.44")
})
public class AddressFilter implements Filter {
    private FilterConfig filterConfig = null;
    private String addressProhibited = null;

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String address = (req).getRemoteAddr();
        if (address.equals(addressProhibited)) {
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>这个地址禁止访问</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>这个地址禁止访问</h1>");
            out.println("</body>");
            out.println("</html>");
            out.flush();

            return;
        }

        chain.doFilter(req, resp);

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        addressProhibited = filterConfig.getInitParameter("addressProhibited");

    }

}
