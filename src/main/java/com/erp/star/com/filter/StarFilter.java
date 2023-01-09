package com.erp.star.com.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@WebFilter("/*")
public class StarFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("==============filter instance init==============");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 전 처리
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String requestURI = req.getRequestURI();
        log.info("----Request({}) filter-------", requestURI);
        chain.doFilter(req, res);
        // 후 처리
        log.info("----Request({}) filter-------", requestURI);
    }

    @Override
    public void destroy() {
        log.info("===========filter instance destroy============");
    }
}
