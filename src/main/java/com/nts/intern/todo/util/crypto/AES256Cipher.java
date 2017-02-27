package com.nts.intern.todo.util.crypto;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AES256Cipher {

	final static Logger logger = LoggerFactory.getLogger(AES256Cipher.class);

	private static String iv;
	private static Key keySpec;
	final static String key = "todoSecretSecret!!!";

	public static String getKey() {
		return key;
	}

	public AES256Cipher(String key) throws UnsupportedEncodingException {
		iv = key.substring(0, 16);

		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		AES256Cipher.keySpec = keySpec;
	}

	public AES256Cipher() throws UnsupportedEncodingException {
		iv = key.substring(0, 16);

		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length) {
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

		AES256Cipher.keySpec = keySpec;
	}

	public static String aesEncode(String str) {
		String enStr = "";
		str += " todoSecretSecret!!!";
		try {
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
			byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			enStr = new String(Base64.encodeBase64(encrypted));
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("aesEncode Exception!!");
		}

		return enStr;
	}

	public static String aesDecode(String str) {
		Cipher c;
		String desStr = "";
		try {
			c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
			byte[] byteStr = Base64.decodeBase64(str.getBytes());
			desStr = new String(c.doFinal(byteStr), "UTF-8");
		} catch (Exception e) {
			logger.info("aesDecode Exception!!");
		}

		return desStr;
	}

	public static String getLoginId(String encData) {
		String decData = aesDecode(encData);
		String loginId[] = decData.split(" ");
		return loginId[0];
	}
}
