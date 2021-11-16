package com.heqing.hibernate.service;

/**
 * @author heqing
 * @since 2021-07-21
 */
public interface TransactionaService {

    /**
     * 测试事务
     * @param isbug
     * @throws Exception
     */
    void save(boolean isbug) throws Exception;

}
