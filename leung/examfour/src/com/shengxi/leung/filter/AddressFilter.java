package com.shengxi.leung.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Author: matthew
 * @ClassName ${NAME}
 * @Date: 2019-09-18 23:12
 * @Version: 1.0.0
 * @description:
 */
@WebFilter(filterName = "AddressFilter", initParams = {
        @WebInitParam(name = "addressProhibited", value = "192.168.1.44")
})
public class AddressFilter implements Filter {

    private FilterConfig filterConfig = null;

    private String addressProhibited = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        this.addressProhibited = config.getInitParameter("addressProhibited");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req.getAttribute("addressProhibited").equals(this.addressProhibited)){
            resp.setContentType("text/html;charest=UTF-8");

            return;
        }


        chain.doFilter(req, resp);
    }



    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
