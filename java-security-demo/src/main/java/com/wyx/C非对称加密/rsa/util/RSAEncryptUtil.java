package com.wyx.C非对称加密.rsa.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA:公钥加密
 *
 * @author : Just wyx
 * @Date : 2021/2/24
 */
public class RSAEncryptUtil {
	// 公钥key
	private static final String PK_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLtjtEZ/A0uW4UVgQnfsPJ6qj2wXB8N0okjnxGGfZ8dj/CEqIAkxk4ZUcOJ6MXTugqLJKmkDIBzNMK3ecfNuQFiAUNVGb8FRDhykH6cMsxKNYkBJbQZqnH6UU/JrT84FnMlf1HWg9W1pW9n1+a5rqT7UgesImivWaDi5sJ4zyhuwIDAQAB";

	private static Cipher cipher;

	static {
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(Base64.getDecoder().decode(PK_KEY));
			PublicKey publicKey = kf.generatePublic(pkSpec);

			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}

	/**
	 * RSA公钥加密
	 * @param message
	 * @return
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static String encrypt(String message) throws BadPaddingException, IllegalBlockSizeException {
		return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
	}
}
