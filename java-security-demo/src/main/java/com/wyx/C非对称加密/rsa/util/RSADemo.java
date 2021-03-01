package com.wyx.C非对称加密.rsa.util;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * @author : Just wyx
 * @Date : 2021/2/24
 */
public class RSADemo {

	public static void main(String[] args) throws BadPaddingException, IllegalBlockSizeException {
		String message = "111111";
		// 加密
		String encryptMessage = RSAEncryptUtil.encrypt(message);
		System.out.println("加密后的值：" + encryptMessage);

		String decryptMessage = RSADecryptUtil.decrypt("eZvxbnytQ6JxvZv5wg99F6MLPWOlIjFwDBB+sEAC4i5+hXIYSks/peQWgAL+nmX+68Zqq+xclhp/EUoNFzKRxm/RinUXe7rPpaTBvD9QKWsryOIFE8ZC5zSY9dGk/ofO3ydKEVKJ7A/X45AhPpMEJ3rmPZm6u1Rn1JGflMANA9Y=");
		System.out.println("解密后的值：" + decryptMessage);
	}
}
