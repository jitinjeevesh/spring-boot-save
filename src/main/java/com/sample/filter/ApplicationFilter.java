package com.sample.filter;

import com.oauth.utils.SecurityHeaderMapRequestWrapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class ApplicationFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        SecurityHeaderMapRequestWrapper headerWrapper = new SecurityHeaderMapRequestWrapper((HttpServletRequest) req);
        headerWrapper.addHeader("user_id", headerWrapper.getHeader("userId"));
        chain.doFilter(headerWrapper, res);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
