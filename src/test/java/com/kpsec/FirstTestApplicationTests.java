package com.kpsec;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.kpsec.test.contoller.SampleController;

@SpringBootTest
@AutoConfigureMockMvc
class FirstTestApplicationTests {

	@Autowired
	private SampleController sampleController;
	
	@Autowired
	private MockMvc mockMvc;
	
	// 문제 1번
	@Test
	void firstTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/first"))
		.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	// 문제 2번
	@Test
	void secondTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/second"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

}
