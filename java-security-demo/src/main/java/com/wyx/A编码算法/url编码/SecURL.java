package com.wyx.A编码算法.url编码;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * ### URL编码
 * URL编码是编码算法，不是加密算法
 * URL编码的目的是把任意文本数据编码为%前缀表示的文本
 * 编码后的文本仅包含 A~Z,a~z,0~9,-_.*,% 便于浏览器和服务器处理
 *
 * @author : Just wyx
 * @Date : 2020/12/14
 */
public class SecURL {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String original = "s?ws=我爱中国520";
		// 编码
		String encoded = URLEncoder.encode(original, "UTF-8");
		System.out.println(encoded);
		// 解码
		String ori = URLDecoder.decode(encoded, "UTF-8");
		System.out.println(ori);
	}
}
