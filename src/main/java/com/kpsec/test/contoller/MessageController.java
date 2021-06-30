package com.kpsec.test.contoller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	
	@GetMapping("/api/return-string")
	@ResponseBody
	public String returnString() {
		return "hello";
	}

	@GetMapping("/api/return-list")
	@ResponseBody
	public List<String> returnList() {
		List<String> list = Arrays.asList("ac","vv","dd","ss","ee");
		return list;
	}
	
	@GetMapping("/api/return-map")
	@ResponseBody
	public Map<String, String> returnMap() {
		Map<String, String> map = new HashMap<String, String>() {{
			put("asd", "asd");
			put("fff", "fff");
			put("rrr", "rrr");
			put("eee", "eee");
		}};
		return map;
	}
	
}
