package com.wyx.sensitive.word.filter.demo.enums;

import com.wyx.sensitive.word.filter.demo.common.AbstractSensitiveWordsFilter;
import com.wyx.sensitive.word.filter.demo.common.algorithm.dfa.DfaFilterExecutor;
import com.wyx.sensitive.word.filter.demo.common.algorithm.dfa2.Dfa2FilterExecutor;

/**
 * 敏感词算法实现类型
 * @author zhy
 */
public enum FilterTypeEnum {

	DFA("dfa算法", DfaFilterExecutor.class),
	DFA2("dfa2算法", Dfa2FilterExecutor.class);

	private String desc;
	private Class<? extends AbstractSensitiveWordsFilter> clazz;

	FilterTypeEnum(String desc, Class<? extends AbstractSensitiveWordsFilter> clazz) {
		this.desc = desc;
		this.clazz = clazz;
	}

	public String getDesc() {
		return desc;
	}

	public Class<? extends AbstractSensitiveWordsFilter> getClazz() {
		return clazz;
	}
}