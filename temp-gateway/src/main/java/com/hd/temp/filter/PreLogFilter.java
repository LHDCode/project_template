//package com.hd.temp.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * ZuulApi网关过滤器
// * 前置过滤器，用于在请求路由到目标服务前打印请求日志
// */
////@Component
//@Slf4j
//public class PreLogFilter extends ZuulFilter {
//
//    /**
//     * 过滤器类型，有pre、routing、post、error四种。
//     * @return
//     */
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    /**
//     *  过滤器执行顺序，数值越小优先级越高。
//     * @return
//     */
//    @Override
//    public int filterOrder() {
//        return 1;
//    }
//
//    /**
//     * 是否进行过滤，返回true会执行过滤。
//     * @return
//     */
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    /**
//     * 自定义的过滤器逻辑，当shouldFilter()返回true时会执行。
//     * @return
//     * @throws ZuulException
//     */
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//        String host = request.getRemoteHost();
//        String method = request.getMethod();
//        String uri = request.getRequestURI();
//        log.info("Remote host:{},method:{},uri:{}", host, method, uri);
//        return null;
//    }
//}
