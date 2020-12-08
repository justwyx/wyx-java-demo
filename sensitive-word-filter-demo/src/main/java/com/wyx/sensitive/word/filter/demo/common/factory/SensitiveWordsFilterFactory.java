package com.wyx.sensitive.word.filter.demo.common.factory;


import com.wyx.sensitive.word.filter.demo.common.AbstractSensitiveWordsFilter;
import com.wyx.sensitive.word.filter.demo.enums.FilterTypeEnum;

/**
 * 敏感词库过滤实现工厂
 * @author zhy
 */
public final class SensitiveWordsFilterFactory {

	public static AbstractSensitiveWordsFilter create(FilterTypeEnum filterTypeEnum) throws Exception {
		
		return (AbstractSensitiveWordsFilter) Class.forName(filterTypeEnum.getClazz().getName()).newInstance();
	}
}
