package com.junyang.aop;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @category 日志统一管理
 * @author csz
 *
 */
@Aspect
@Component
public class WebLogAspect {

	private static Logger logger = Logger.getLogger(WebLogAspect.class);

	@Pointcut("execution(public * com.junyang.service..*.*(..))")
	public void webLog() {
		
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("#####################请求开始####################");
		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		List<String> list = new ArrayList<>();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			logger.info("name:{" + name + "},value:{" + request.getParameter(name) + "}");
			list.add("name:{" + name + "},value:{" + request.getParameter(name) + "}");
		}
		String url = request.getRequestURL().toString();
		int temp = url.lastIndexOf("/", url.length());
		String size = url.substring(temp+1, url.length());
		if("login".equals(size) && "POST".equals(request.getMethod())){
			logger.info("登陆请求");
		}
	}
	
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
		logger.info("#####################请求结束####################");
	}
}
