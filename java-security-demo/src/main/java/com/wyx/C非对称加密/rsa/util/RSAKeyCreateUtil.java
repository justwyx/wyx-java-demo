package com.wyx.C非对称加密.rsa.util;

import java.security.*;
import java.util.Base64;

/**
 * RSA:生成公钥和私钥
 * @author : Just wyx
 * @Date : 2021/2/24
 */
public class RSAKeyCreateUtil {

	/**
	 * 生成公钥／私钥对:
	 */
	public static void createKey() throws GeneralSecurityException {
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		kpGen.initialize(1024);
		KeyPair kp = kpGen.generateKeyPair();
		// 公钥:
		PublicKey pk = kp.getPublic();
		// 私钥:
		PrivateKey sk = kp.getPrivate();
		System.out.println("公钥: " + Base64.getEncoder().encodeToString(pk.getEncoded()));
		System.out.println("私钥: " + Base64.getEncoder().encodeToString(sk.getEncoded()));
	}

	public static void main(String[] args) throws GeneralSecurityException {
		createKey();
	}
}
