package com.cjc.crud.webapp.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSender {
	
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textMesaage;

}
