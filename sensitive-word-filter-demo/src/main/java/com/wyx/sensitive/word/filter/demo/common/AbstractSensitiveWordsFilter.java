package com.wyx.sensitive.word.filter.demo.common;

import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.wyx.sensitive.word.filter.demo.common.cache.JvmWordsCache;
import com.wyx.sensitive.word.filter.demo.common.cache.WordsCache;
import com.wyx.sensitive.word.filter.demo.enums.SensitiveWordsTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 敏感词库抽象接口实现
 * 
 * @author zhy
 */
public abstract class AbstractSensitiveWordsFilter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	private volatile static boolean HAS_INIT_WORDS_CACHE = false;
	
	public void initAll() throws RuntimeException {
		
		if (!HAS_INIT_WORDS_CACHE) {
			logger.debug("初始化所有缓存");
			this.initCache();
			this.init();
		} else {
			logger.debug("缓存已被初始化，无需重复执行！");
		}
	}
	
	public void refreshAll() throws Exception {

		logger.debug("刷新所有缓存");
		JvmWordsCache.getInstance().refresh();
		this.refresh();
	}

	public abstract boolean checkExistence(String content, boolean partMatch);

	public abstract boolean checkExistence(String content);

	public abstract Set<String> getSensitiveWords(String content,boolean partMatch);

	public abstract String highlight(String content,boolean partMatch);

	public abstract String filter(String content, char replaceChar,boolean partMatch);


	public void init() throws RuntimeException {
	}

	public void initCache() throws RuntimeException {
		WordsCache jvmWordsCache = JvmWordsCache.getInstance();
		jvmWordsCache.init();
		for (SensitiveWordsTypeEnum type : SensitiveWordsTypeEnum.values()) {
			try {
				int i = 0;
				Set<String> words = Sets.newHashSet();

				//File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "sensitivewords" + File.separator + type.getName() + "词库.txt");
				ClassPathResource classPathResource =
						new ClassPathResource("sensitivewords" + File.separator + type.getName() + "词库.txt");
				if(!classPathResource.exists())
					continue;

				File file = classPathResource.getFile();

				List<String> wordlists = Files.readLines(file, StandardCharsets.UTF_8);

				for (String word : wordlists) {
					if(StringUtils.isBlank(word))
						continue;

					words.add(word);
					i++;
				}

				jvmWordsCache.put(words);

				System.out.println("循环单词: " + i + ", 插入数据：" + words.size());
				Thread.sleep(15);
			} catch (Exception e) {
				logger.error("initCache-error:{}", e);
			}
		}
	}

	/**
	 * 添加分词
	 * @author zhy
	 * @throws RuntimeException
	 */
	protected abstract void put(Set<String> sensitiveWordSet);

	public void putAllCacheWords() {
		WordsCache jvmWordsCache = JvmWordsCache.getInstance();
		Set<String> set = new HashSet<>(jvmWordsCache.get());
		this.put(set);
	}

	public abstract void refresh();

	public abstract void destroy();
}
