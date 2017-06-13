package com.seckill.dao;

import com.seckill.mode.Seckill;

import java.util.Date;
import java.util.List;

/**
 * SeckillDao
 */
public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 库存数
     */
    int reduceNumber(long seckillId, Date killTime);

    /**
     * 根据查询秒杀商品对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offset, int limit);
}
