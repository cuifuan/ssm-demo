package org.chinaos.filter;

import org.chinaos.service.CustomAccessDecisionManager;
import org.chinaos.service.CustomInvocationSecurityMetadataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;


public class MySecurityFilter extends AbstractSecurityInterceptor implements Filter{
    @Autowired
    private CustomInvocationSecurityMetadataSourceService mySecurityMetadataSource;

    @Autowired
    private CustomAccessDecisionManager myAccessDecisionManager;

//	@Autowired
//	private AuthenticationManager authenticationManager;

    @PostConstruct
    public void init(){
//		super.setAuthenticationManager(authenticationManager);
        super.setAccessDecisionManager(myAccessDecisionManager);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        System.out.println("filtergergetghrthetyetyetyetyj");
        return this.mySecurityMetadataSource;
    }

    @Override
    public void destroy() {
        System.out.println("filter===========================end");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation( request, response, chain );
        invoke(fi);

    }

    private void invoke(FilterInvocation fi) throws IOException, ServletException {
        System.out.println("filter..........................");
        InterceptorStatusToken  token = super.beforeInvocation(fi);
        try{
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally{
            super.afterInvocation(token, null);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("filter===========================");
    }

}