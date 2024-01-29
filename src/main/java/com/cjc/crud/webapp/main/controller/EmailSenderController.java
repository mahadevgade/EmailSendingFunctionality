package com.cjc.crud.webapp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.crud.webapp.main.model.EmailSender;
import com.cjc.crud.webapp.main.service.EmailSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class EmailSenderController {
	
	@Autowired
	EmailSenderService es;
	
	@Value("${spring.mail.username}")
	String fromEmail;
	
	
	// 1):- This method is used for only send Simple Text Messages.. 
	
	//POST API

	@PostMapping("/email")
	public String  sendEmail(@RequestBody EmailSender e)
	{
		
		e.setFromEmail(fromEmail);
		
		try {
			es.sendEmail(e);
			
		} catch (Exception e2) {

			System.out.println(e2);
				
			return "Email can not be sent....";
		}
		return "Email successfully sent...";
		
	}
	
	
	
	// 2):- This method is used for  send Simple Text Messages With Attachment files.. 
	
	//POST API
	
	
	@PostMapping(value = "/emailwithattchament",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String  sendEmailwithAttchament(@RequestParam("data") String json,
			@RequestParam("file") MultipartFile file) throws JsonMappingException, JsonProcessingException
	{
		
		ObjectMapper om=new ObjectMapper();
		EmailSender e= om.readValue(json, EmailSender.class);
		
		e.setFromEmail(fromEmail);
		
		try {
			es.sendEmailwithAttchament(e,file);
			
		} catch (Exception e2) {

			System.out.println(e2);
				
			return "Email can not be sent....!!!";
		}
		return "Email successfully sent...!!!";
		
	}
	
	

}






















