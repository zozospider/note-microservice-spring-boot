package com.zozospider.autoconfiguration.service;

/**
 * 计算服务
 *
 * @author zozo
 * @since 1.0
 */
public interface CalculateService {

    /**
     * 求多个整数的和
     * @param values 多个整数
     * @return 累加值
     */
    Integer sum(Integer... values);

}
