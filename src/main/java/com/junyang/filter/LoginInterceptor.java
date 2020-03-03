package com.junyang.filter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.junyang.dao.AdminUserDao;
import com.junyang.entity.AdminUserEntity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private AdminUserDao adminUserDao;
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String token = request.getHeader("token");
    	System.out.println("**************");
    	if (token != null) {
    		AdminUserEntity entity = adminUserDao.findByToken(token);
    		if (entity!=null) {
    			return true;
			}else{
				returnJson(response,"没有获取到token");
			}
    	}else {
    		if("OPTIONS".equals(request.getMethod())){
    			return true;
    		}else{
    			System.out.println("******");
    			returnJson(response,"没有获取到token");
    		}
		}
    	return false;
 
    }

    private void returnJson(ServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            log.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
 
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
 
    }
}