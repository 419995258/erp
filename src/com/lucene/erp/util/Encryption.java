package com.lucene.erp.util;

import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * md5加密处理，对str字符串处理的结果返回值便是加密的结果
 * 
 * @author Administrator
 *
 */
public class Encryption {
	public static String md5(String str) {
		String s = str;
		if (s == null) {
			return "";
		} else {
			String value = null;
			MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(Encryption.class.getName()).log(Level.SEVERE, null, ex);
			}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
				value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
			} catch (Exception ex) {
			}
			return value;
		}
	}

	public static void main(String[] args) {
		System.out.println(md5("admin"));
	}
}