package com.wyx.sensitive.word.filter.demo.enums;

/**
 * 过滤敏感词类型
 * @author zhy
 */
public enum SensitiveWordsTypeEnum {
	/** 色情 */
	PORNO(1, "色情"), 
	/** 政治 */
	POLITICS(2, "政治"), 
	/** 暴恐 */
	TERROR(3, "暴恐"), 
	/** 民生 */
	LIVELIHOOD(4, "民生"), 
	/** 反动 */
	REACTION(5, "反动"), 
	/** 贪腐 */
	CORRUPTION(6, "贪腐"), 
	/** 其他 */
	OTHERS(7, "其他"); 

	private int code;
	private String name;
	
	SensitiveWordsTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public String getEnumName() {
		return this.name();
	}
}
