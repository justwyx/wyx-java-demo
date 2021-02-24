package com.wyx.C非对称加密.rsa.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author : Just wyx
 * @Date : 2021/2/24
 */
public class RSADecryptUtil {
	// 私钥key
	private static final String SK_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIu2O0Rn8DS5bhRWBCd+w8nqqPbBcHw3SiSOfEYZ9nx2P8ISogCTGThlRw4noxdO6CoskqaQMgHM0wrd5x825AWIBQ1UZvwVEOHKQfpwyzEo1iQEltBmqcfpRT8mtPzgWcyV/UdaD1bWlb2fX5rmupPtSB6wiaK9ZoOLmwnjPKG7AgMBAAECgYBY9lHo7hI7UHPyyQ7eI08CjMTIU0aQIhi5DG2/qZqViCpzJrA3k3M0wPCs57pnBhy5diZvn1PoZ4de3QvliWtJzL+c4nGvh5RlGN+ILL2+OvSQS812mG/Ksel8Tyd6OhMaXhTfAUa/NpAr0oKTSzyql1zuWGrPMdOxt7TV4NtduQJBAPePu1uZ3W1NKejRvZoKj6L42uBwpbwevbXoZGoNcisv3REiiJqWzd1hGT80Ram4QhjnA3vaqq8zoGQXMOq29rcCQQCQeWItz/XPXQWqL9+3DkzmIPEe6WOzEumnE8QtJQVxpSnO4NxXCcRakgzZQAnHVKVk20VkDBZcvWU/MN/cm8kdAkBcks/yChCGPfOtDzmCb+6Ud9CJWzZuqWQxsOxTyCFoSua08J/6hugGn7esLeTa+X8mBsUDvJpVF84jf5SYQMDzAkAL/7jSuzncHgqxZsZ6yppCZqv/+DxKjCCRuseJRFDebmw5fV1vcSU4rHaauIHXZ0VRShDKTWKyExzMkb+V7+5VAkBVo6+GF9zmez/ZW0y2c5tlmQVnTyvniN0NmhipxMussN0SZm7gMc26ps7tzrKbyZ3EbPy4SwJsnISYT2j2+1Kb";

	private static Cipher cipher;

	static {
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PKCS8EncodedKeySpec pkSpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(SK_KEY));
			PrivateKey privateKey = kf.generatePrivate(pkSpec);

			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

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
	 * RSA:私钥解密
	 * @param message
	 * @return
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static String decrypt(String message) throws BadPaddingException, IllegalBlockSizeException {
		return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
	}
}
