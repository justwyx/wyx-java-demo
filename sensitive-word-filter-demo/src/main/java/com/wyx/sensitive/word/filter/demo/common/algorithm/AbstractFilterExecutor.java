package com.wyx.sensitive.word.filter.demo.common.algorithm;

import com.google.common.base.Strings;
import com.wyx.sensitive.word.filter.demo.common.AbstractSensitiveWordsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Set;

/**
 * 抽象敏感词过滤执行器，提供过滤的缓存初始化、刷新、销毁基础封装
 * 
 * @author zhy
 */
public abstract class AbstractFilterExecutor<T> extends AbstractSensitiveWordsFilter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	private static final String HTML_HIGHLIGHT = "<font color='red'>%s</font>";

	protected T cacheNodes;

	private String listenerName;

	public String getListenerName() {
		return listenerName;
	}

	public AbstractFilterExecutor(String listenerName) {
		super();
		this.listenerName = listenerName;
	}
	
	/**
	 * 分词数据对象模型
	 * @author zhy
	 */
	protected abstract T getCacheNodes();
	
	@Override
	public void init() throws RuntimeException {
		try {
			if (cacheNodes == null) {
				logger.debug("{}: 初始化数据", getListenerName());
				refresh();
			} else {
				logger.debug("{}: 已初始化数据，无需重复执行", getListenerName());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}		
	}

	@Override
	public void refresh() {
		logger.debug("{}: 刷新数据", getListenerName());
		
		cacheNodes = this.getCacheNodes();

	}
	
	@Override
	public void destroy() {
		logger.debug("{}: 销毁数据", getListenerName());
		cacheNodes = null;
	}

	@Override
	public String highlight(String content,boolean partMatch) {
		Set<String> words = this.getSensitiveWords(content,partMatch);

		Iterator<String> iter = words.iterator();
		while (iter.hasNext()) {
			String word = iter.next();
			content = content.replaceAll(word, String.format(HTML_HIGHLIGHT, word));
		}

		return content;
	}

	@Override
	public String filter(String content, char replaceChar, boolean partMatch) {
		Set<String> words = this.getSensitiveWords(content, partMatch);

		Iterator<String> iter = words.iterator();
		while (iter.hasNext()) {
			String word = iter.next();
			content = content.replaceAll(word, Strings.repeat(String.valueOf(replaceChar), word.length()));
		}

		return content;
	}
}
