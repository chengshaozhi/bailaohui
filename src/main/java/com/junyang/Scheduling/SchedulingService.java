package com.junyang.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SchedulingService {
	
	@Autowired
    private  JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private  String Sender; //读取配置文件中的参数
	
	@Scheduled(cron="0 15 10 * * ?")//  每天上午10:15触发
	public void sendMail(){
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(Sender);
	        message.setTo("zmkwudifirst@126.com"); //自己给自己发送邮件
	        message.setSubject("主题：简单邮件");
	        message.setText("测试邮件内容");
	        mailSender.send(message);
	}
}
