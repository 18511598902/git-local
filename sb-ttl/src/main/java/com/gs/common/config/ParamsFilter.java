/**
 * 版权所有 2019 山东新北洋信息技术股份有限公司
 * 保留所有权利。
 */
package com.gs.common.config;

import org.springframework.stereotype.Component;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : gs
 * @ClassName : ParamsFilter
 * @Description : 类描述
 * @Date: 2021-01-05 20:29
 */
@Component
@WebFilter(urlPatterns = "/**", filterName = "ParamsFilter",dispatcherTypes= DispatcherType.REQUEST)
public class ParamsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        ParameterRequestWrapper parmsRequest = new ParameterRequestWrapper((HttpServletRequest) arg0);
        arg2.doFilter(parmsRequest, arg1);

    }

    @Override
    public void destroy() {

    }
}
