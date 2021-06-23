package com.kpsec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpsec.test.contoller.SampleController;

@SpringBootTest
class FirstTestApplicationTests {

	@Autowired
	private SampleController sampleController;
	
	@Test
	void contextLoads() {
		System.out.println("시작 해쓰용");
		System.out.println(sampleController.getAccountInfo(null).get(1).toString());
	}

}
