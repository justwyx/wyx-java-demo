package com.wyx.sensitive.word.filter.demo.common.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 * abstract word cache interface method
 * @author zhy
 */
public abstract class WordsCache {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String listenerName;

    public WordsCache(String listenerName) {
        this.listenerName = listenerName;
    }

    public String getListenerName() {
        return listenerName;
    }


    public void setDataSource(Object dataSource) {
        logger.debug("{}: bindDataSource: {}", listenerName, dataSource);
    }


    public boolean init() throws RuntimeException {
        logger.debug("{}: init word cache", listenerName);
        return true;
    }


    public boolean put(String words) throws Exception {
        logger.debug("{}: put word: {}", listenerName, words);

        return true;
    }


    public boolean put(Collection<String> words) throws Exception {
        logger.debug("{}: put word list: {}", listenerName, words);

        return true;
    }


    public List<String> get() {
        logger.debug("{}: get word list", listenerName);

        return null;
    }


    public boolean update(String word) throws Exception {
        logger.debug("{}: update word: {}", listenerName, word);

        return true;
    }


    public boolean remove(String words) throws Exception {
        logger.debug("{}: remove word: {}", listenerName, words);

        return false;
    }


    public boolean refresh() throws RuntimeException {
        logger.debug("{}: refresh word cache", listenerName);

        return false;
    }
}
