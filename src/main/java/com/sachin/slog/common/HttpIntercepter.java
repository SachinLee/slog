package com.sachin.slog.common;

import com.sachin.slog.utils.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class HttpIntercepter extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        if (!this.isStaticReq(url)) {
            Map parameterMap = request.getParameterMap();
            log.info("request start. url:{}, params:{}", url, JsonMapper.obj2String(parameterMap));
            long start = System.currentTimeMillis();
            request.setAttribute(START_TIME, start); //设置请求开始时间
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
        removeThreadLocalInfo();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
//        super.afterCompletion(request, response, handler, ex);

        String url = request.getRequestURL().toString();
        if (!this.isStaticReq(url)) {
            long start = (Long) request.getAttribute(START_TIME); // 获取请求开始时间
            long end = System.currentTimeMillis();
            log.info("请求完成，url:{}, cost:{} 毫秒", url, end - start); // 打印路径，请求花费时间
        }
        removeThreadLocalInfo();
    }

    /**
     * 移除信息
     */
    private void removeThreadLocalInfo() {
        RequestHolder.remove();
    }


    private boolean isStaticReq(String url) {
        if (url.indexOf(".") != -1) {
            return true;
        }
        return false;
    }
}
