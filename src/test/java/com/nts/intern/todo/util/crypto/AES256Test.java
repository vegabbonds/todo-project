package com.nts.intern.todo.util.crypto;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.nts.intern.todo.util.crypto.AES256Cipher;

public class AES256Test {

	@Test
	public void test() throws UnsupportedEncodingException {
		// given
		String key = "aes256-test"; 
		AES256Cipher aes256 = new AES256Cipher(key);
		System.out.println("test : " + aes256);
		String loginId = "vegabbonds";
		String text = "asdfasdf";

		// when
		String encData = AES256Cipher.aesEncode(loginId);
		String decData[] = AES256Cipher.aesDecode(encData).split(" ");
		String decLoginId = decData[0];		
		
		String encTextData = AES256Cipher.aesEncode(text);
		String decTextData[] = AES256Cipher.aesDecode(encTextData).split(" ");		
		String decText = decTextData[0];
		
		// then		
		assertThat(decLoginId.equals(loginId), is(true));
		assertThat(decText.equals(text), is(true));
	}

}
