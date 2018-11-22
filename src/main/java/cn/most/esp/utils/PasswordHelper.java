package cn.most.esp.utils;

import org.springframework.util.DigestUtils;

public class PasswordHelper {

	/**
	 * md5加密
	 * @param passWord
	 * @return
	 */
	public static String encryptPassword(String passWord) {
	    return DigestUtils.md5DigestAsHex(passWord.getBytes());
	}
	
	public static void main(String[] args) {
		System.out.println(encryptPassword("12345678"));
	}
}
