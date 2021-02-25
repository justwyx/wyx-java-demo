package com.wyx.C非对称加密.rsa.util;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

/**
 * @author : Just wyx
 * @Date : 2021/2/24
 */
public class RSADemo {

	public static void main(String[] args) throws BadPaddingException, IllegalBlockSizeException {
		String message = "我要测试一下RSA加密我要测试一下RSA加密我要测试";
		// 加密
		String encryptMessage = RSAEncryptUtil.encrypt(message);
		System.out.println("加密后的值：" + encryptMessage);

		String decryptMessage = RSADecryptUtil.decrypt("dfPXxQ77NK2HrX4FTWTrNJD3xNh9n4qL4k3R8C1AOye6OGTsMrNs/Eoz5LHN5y66Itu9tjEMWebc8Qu1PxLp8634kocCb+/wXLVZMxr9V/Hm3EdPjnoxr8p0x34aFob0PRv7ydygBltKusJ1AkQt0P7KP+3H9CoCeqayUt4ZUGw=");
		System.out.println("解密后的值：" + decryptMessage);
	}
}
