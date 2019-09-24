package com.qf;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter( "*.jsp")
public class BFilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("BFilterDemo2");
        chain.doFilter(req, resp);
        System.out.println("BFilterDemo2");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
