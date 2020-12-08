package com.wyx.sensitive.word.filter.demo;

import com.wyx.sensitive.word.filter.demo.common.DFASensitiveWordsFilterUtil;
import com.wyx.sensitive.word.filter.demo.common.cache.JvmWordsCache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

/**
 * @author : Just wyx
 * @Date : 2020/12/8
 */
@SpringBootTest
public class SensitiveWordFilterTest {


	@Test
	public void testDfa() {
		DFASensitiveWordsFilterUtil dfaUtil = DFASensitiveWordsFilterUtil.getInstance();

		long start = System.currentTimeMillis();
		System.out.println("敏感词的数量：" + JvmWordsCache.cache.size());
		String string = "2010现役电警棍 性感的bitch 幕中的情节。然后网带我去诞红问问轻度我去南方我的舞蹈你的短期内请问对我的钱王千瓦时的王神奇的单曲"
				+ "难过就躺在某一个人的怀关键字里尽v 人卡马克v等我开门或者网法国可免费情况手机店主V信一个贱人文采我的我的我打开毛孔哦那句就能玩多久呢三角今晚带你飞"
				+ "AV女,AV女AV女。八九学潮,八九见证paper 最后 一波";

		System.out.println("待检测语句字数：" + string.length());

		//ResourceUtils.CLASSPATH_URL_PREFIX
		System.out.println(dfaUtil.checkExistence(string,true));
		System.out.println(dfaUtil.checkExistence(string,false));

		Set<String> set = dfaUtil.getSensitiveWords(string,true);
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
		set = dfaUtil.getSensitiveWords(string,false);
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);

		String filterStr =dfaUtil.filter(string,'*', true);
		System.out.println(filterStr);
		filterStr = dfaUtil.filter(string,'*', false);
		System.out.println(filterStr);

		System.out.println("执行时间" + (System.currentTimeMillis() - start + "ms"));
	}


	@Test
	public void testDfa2() {
		DFASensitiveWordsFilterUtil dfaUtil = DFASensitiveWordsFilterUtil.getInstance();
		String string = "2010现役电警棍 性感的bitch 幕中的情节。然后网带我去诞红问问轻度我去南方我的舞蹈你的短期内请问对我的钱王千瓦时的王神奇的单曲"
				+ "难过就躺在某一个人的怀关键字里尽v 人卡马克v等我开门或者网法国可免费情况手机店主V信一个贱人文采我的我的我打开毛孔哦那句就能玩多久呢三角今晚带你飞"
				+ "AV女,AV女AV女。八九学潮,八九见证paper ";



		long start = System.currentTimeMillis();
		dfaUtil.turnToDFA2();
		System.out.println("待检测语句字数：" + string.length());

		//ResourceUtils.CLASSPATH_URL_PREFIX
		System.out.println(dfaUtil.checkExistence(string,true));
		System.out.println(dfaUtil.checkExistence(string,false));

		Set<String> set = dfaUtil.getSensitiveWords(string,true);
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
		set = dfaUtil.getSensitiveWords(string,false);
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);


		String filterStr = dfaUtil.filter(string,'*', true);
		System.out.println(filterStr);
		filterStr = dfaUtil.filter(string,'*', false);
		System.out.println(filterStr);

		System.out.println("执行时间" + (System.currentTimeMillis() - start + "ms"));

	}
}
