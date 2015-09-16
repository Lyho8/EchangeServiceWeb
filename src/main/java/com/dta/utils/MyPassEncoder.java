package com.dta.utils;

public class MyPassEncoder extends org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder {
	public MyPassEncoder() {
		super("MD5");
	}

	public String encodePassword(String rawPass, Object salt) {
		String encPass = super.encodePassword(rawPass, salt);
		return encPass;
	}
}