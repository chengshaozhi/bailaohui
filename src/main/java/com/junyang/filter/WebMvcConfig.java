package com.junyang.filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@SpringBootConfiguration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
 
    @Autowired
    private LoginInterceptor loginInterceptor;
 
    /**
     * 重写添加拦截器方法并添加配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")//拦截哪些路径("/**":代表拦截所有路径);
        		.excludePathPatterns("/admin/login","/wechat/access"); //不拦截哪些路径;	
    }
}