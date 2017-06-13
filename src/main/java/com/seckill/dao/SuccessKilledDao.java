package com.seckill.dao;

import com.seckill.mode.SuccessKilled;

/**
 * SuccessKillDao
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可过滤重复
     * @param seckilled
     * @param userPhone
     * @return 插入的结果集数量
     */
    int insertSuccessKilled(long seckilled, long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckill
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckill);


}
