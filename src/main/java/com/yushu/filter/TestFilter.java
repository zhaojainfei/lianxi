package com.yushu.filter;


import com.yushu.model.HsCardkind;
import com.yushu.service.CardKindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/*",filterName = "test")
public class TestFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CardKindService cardKindService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("tomcat加载时候调用");
    }

    /**
     * 请求被拦截的时候调用
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        if(request.getParameter("name").equals("yushu")){
//            HsCardkind cardkind = new HsCardkind();
//            cardkind.setName("test1");
//            cardKindService.addOne(cardkind);
            logger.info("yushu");
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            //response.sendRedirect("/index.html");
            return;
        }
    }

    @Override
    public void destroy() {
        logger.info("tomcat销毁的时候调用");
    }
}
