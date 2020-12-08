package com.wyx.sensitive.word.filter.demo.common;

import com.wyx.sensitive.word.filter.demo.common.factory.SensitiveWordsFilterFactory;
import com.wyx.sensitive.word.filter.demo.enums.FilterTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

/**
 * 分词执行器工具类
 * 
 * @author zhy
 */
public final class DFASensitiveWordsFilterUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	private static class SingleFactory {
		private static final DFASensitiveWordsFilterUtil INSTANCE = new DFASensitiveWordsFilterUtil();
	}

	public static final DFASensitiveWordsFilterUtil getInstance() {
		return SingleFactory.INSTANCE;
	}

	private AbstractSensitiveWordsFilter wordsFilter = null;

	private DFASensitiveWordsFilterUtil() {
		try {
			wordsFilter = SensitiveWordsFilterFactory.create(FilterTypeEnum.DFA);
			wordsFilter.initAll();
			wordsFilter.putAllCacheWords();
		}catch (Exception ex){

		}
	}

	public void turnToDFA2(){
		try {
			wordsFilter = SensitiveWordsFilterFactory.create(FilterTypeEnum.DFA2);
			wordsFilter.initAll();
			wordsFilter.putAllCacheWords();
		}catch (Exception ex){

		}
	}

	/**
	 * 是否包含敏感字符
	 * @author zhy
	 * @param partMatch 是否支持匹配词语的一部分
	 * @param content 被匹配内容
	 * @return 是否包含敏感字符
	 */
	public boolean checkExistence(String content, boolean partMatch) {
		if (StringUtils.isBlank(content)) {
			throw new RuntimeException("必填参数content 为空");
		}
		logger.debug("执行敏感词接口：{}，算法：{}", FilterTypeEnum.DFA.getClazz().getSimpleName(), FilterTypeEnum.DFA.getDesc());

		return wordsFilter.checkExistence(content,partMatch);
	}
	
	/**
	 * 返回匹配到的敏感词语
	 * @author zhy
	 * @param partMatch 是否部分匹配
	 * @param content 被匹配的语句
	 * @return 返回匹配的敏感词语集合
	 */
	public Set<String> getSensitiveWords(String content,boolean partMatch) {

		if (StringUtils.isBlank(content)) {
			throw new RuntimeException("必填参数content 为空");
		}

		logger.debug("执行匹配敏感词接口：{}，算法：{}", FilterTypeEnum.DFA.getClazz().getSimpleName(), FilterTypeEnum.DFA.getDesc());
		Set<String> words = wordsFilter.getSensitiveWords(content,partMatch);

		logger.debug("包含敏感词：{}", words);
		return words;
	}
	
	/**
	 * html高亮敏感词
	 * @author zhy
	 * @param partMatch 是否部分匹配
	 * @param content 被匹配的语句
	 * @return 返回html高亮敏感词
	 * @throws RuntimeException
	 */
	public String highlight(boolean partMatch, String content) throws Exception {
		if (StringUtils.isBlank(content)) {
			throw new RuntimeException("必填参数content 为空");
		}

		logger.debug("执行“高亮”敏感词接口：{}，算法：{}", FilterTypeEnum.DFA.getClazz().getSimpleName(), FilterTypeEnum.DFA.getDesc());
		content = wordsFilter.highlight(content,partMatch);

		logger.debug("高亮敏感词：{}", content);
		return content;
	}

	/**
	 * 过滤敏感词，并把敏感词替换为指定字符
	 * @author zhy
	 * @param target 被匹配的语句
	 * @param replaceChar 替换字符
	 * @return 过滤后的字符串
	 * @throws RuntimeException
	 */
	public String filter(String target, Character replaceChar){
		return filter(target, replaceChar, true);
	}

	/**
	 * 过滤敏感词，并把敏感词替换为指定字符
	 * @author zhy
	 * @param partMatch 是否部分匹配
	 * @param target 被匹配的语句
	 * @param replaceChar 替换字符
	 * @return 过滤后的字符串
	 * @throws RuntimeException
	 */
	public String filter(String target, Character replaceChar, boolean partMatch) {
		replaceChar = Optional.ofNullable(replaceChar).orElse('*');

		if (StringUtils.isBlank(target)) {
			throw new RuntimeException("必填参数content 为空");
		}

		logger.debug("执行“过滤”敏感词接口：{}，算法：{}", FilterTypeEnum.DFA.getClazz().getSimpleName(), FilterTypeEnum.DFA.getDesc());
		String result = wordsFilter.filter(target, replaceChar, partMatch);

		//log.debug("脱敏结果：{}", result);
		return result;
	}

	public void refresh() throws Exception {

		logger.debug("执行刷新敏感词接口：{}，算法：{}", FilterTypeEnum.DFA.getClazz().getSimpleName(), FilterTypeEnum.DFA.getDesc());
		wordsFilter.refresh();
	}
	
	public void refreshAll() throws Exception {

		logger.debug("执行“刷新”敏感词库和所有缓存接口：{}，算法：{}", FilterTypeEnum.DFA.getClazz().getSimpleName(), FilterTypeEnum.DFA.getDesc());
		wordsFilter.refreshAll();
	}
	
	private FilterTypeEnum checkFilterType(FilterTypeEnum type) {
		if (type == null) {
			type = FilterTypeEnum.DFA;
		}
		return type;
	}
}
