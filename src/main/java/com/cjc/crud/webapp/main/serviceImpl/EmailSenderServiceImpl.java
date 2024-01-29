package com.cjc.crud.webapp.main.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.crud.webapp.main.model.EmailSender;
import com.cjc.crud.webapp.main.service.EmailSenderService;

@Component
public class EmailSenderServiceImpl implements EmailSenderService{

	@Autowired
	JavaMailSender sender;
	
	
	@Override
	public void sendEmail(EmailSender e) {
		
		SimpleMailMessage msg=new SimpleMailMessage();
		
		msg.setTo(e.getToEmail());
		msg.setFrom(e.getFromEmail());
		msg.setSubject(e.getSubject());
		msg.setText(e.getTextMesaage());
		
		sender.send(msg);
		
	}


	@Override
	public void sendEmailwithAttchament(EmailSender e, MultipartFile file) 
	{
		
		MimeMessage m=sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(m,true);
			
			helper.setTo(e.getToEmail());
			helper.setFrom(e.getFromEmail());
			helper.setSubject(e.getSubject());
			helper.setText(e.getTextMesaage());
			
			helper.addAttachment(file.getOriginalFilename(), file);
			
			sender.send(m);
			
		} catch (MessagingException e1) {
			
			e1.printStackTrace();
		}
		
	}

}






















