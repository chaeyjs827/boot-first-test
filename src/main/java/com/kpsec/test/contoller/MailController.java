package com.kpsec.test.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpsec.test.dto.MailDto;
import com.kpsec.test.service.MailService;

@RestController
public class MailController {

	@Autowired
	private MailService mailService;
	
	@GetMapping("/api/mail")
	public void sendMail(MailDto mailDto) {
		mailService.sendMail(mailDto);
	}
	
}
