package com.cjc.crud.webapp.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.crud.webapp.main.model.EmailSender;

public interface EmailSenderService {

	public	void sendEmail(EmailSender e);

	public void sendEmailwithAttchament(EmailSender e, MultipartFile file);

}
