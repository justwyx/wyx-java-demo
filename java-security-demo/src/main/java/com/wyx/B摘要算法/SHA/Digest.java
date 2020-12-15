package com.wyx.B摘要算法.SHA;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * ### SHA1
 * SHA-1摘要算法：输出160bits，20bytes
 * 其它摘要算法：
 * * SHA-256
 * * SHA-512
 * * RipeMD160
 * 查询JDK摘要算法名称：
 * http://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest
 *
 * @Author : Just wyx
 * @Date : 13:22 2020/12/14
 */
public class Digest {

	public static byte[] digest(String hashAlgorithm, byte[] input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(hashAlgorithm);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return md.digest(input);
	}

	public static void main(String[] args) throws Exception {
		String s = "Java摘要算法测试";
		byte[] input = s.getBytes("UTF-8");
		// 标准算法名称：
		// http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html#MessageDigest
		byte[] r1 = digest("MD5", input);
		System.out.println(r1.length + ": " + String.format("%0" + (r1.length * 2) + "x", new BigInteger(1, r1)));
		byte[] r2 = digest("SHA-1", input);
		System.out.println(r2.length + ": " + String.format("%0" + (r2.length * 2) + "x", new BigInteger(1, r2)));
		byte[] r3 = digest("SHA-256", input);
		System.out.println(r3.length + ": " + String.format("%0" + (r3.length * 2) + "x", new BigInteger(1, r3)));
//		byte[] r4 = digest("RipeMD160", input);
//		System.out.println(r4.length + ": " + String.format("%0" + (r4.length * 2) + "x", new BigInteger(1, r4)));
	}

}
