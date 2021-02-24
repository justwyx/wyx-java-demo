package com.wyx.C非对称加密.rsa.util;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * @author : Just wyx
 * @Date : 2021/2/24
 */
public class RSADemo {

	public static void main(String[] args) throws BadPaddingException, IllegalBlockSizeException {
		String message = "我要测试一下RSA加密";
		// 加密
		String encryptMessage = RSAEncryptUtil.encrypt(message);
		System.out.println("加密后的值：" + encryptMessage);

		String decryptMessage = RSADecryptUtil.decrypt(encryptMessage);
		System.out.println("解密后的值：" + decryptMessage);
	}
}
