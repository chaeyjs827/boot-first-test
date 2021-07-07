package com.legacy.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class UtilJWT {
	final String JWT_KEY = "testJWT";

	// 다시 개발하기
	/*
	public String createToken() {
		// header
		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		
		//payload
		Map<String, Object> payload = new HashMap<>();
		payload.put("data", "I love money");
		
		Long expiredTime = 1000 * 60L * 60L * 2L;
		
		Date expiredDate = new Date();
		expiredDate.setTime(expiredDate.getTime() + expiredTime);

		// Token builder
		String jwt = Jwts.builder()
				.setHeader(header)	// Header
				.setClaims(payload)	// Claims
				.setSubject("test")	// subject
				.setExpiration(expiredDate)
				.signWith(getSigningKey(JWT_KEY)
				.compact();
		
		return jwt;
	}
	
	private Key getSigningKey(String secretKey) {
		byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public Map<String, Object> verifyToken(String token) throws UnsupportedEncodingException {
		return null;
	}
	*/
}

