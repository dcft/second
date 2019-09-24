package com.qf;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter( "*.jsp")
public class cFilterDemo1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("cFilterDemo1");

        chain.doFilter(req, resp);
        System.out.println("cFilterDemo1");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
