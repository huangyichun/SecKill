package com.seckill.dao;

import com.seckill.mode.Seckill;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置Spring和junit整合，junit启动时加载SpringIOC容器
 * spring-test, junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    /**
     * org.mybatis.spring.MyBatisSystemException: nested exception is org.apache.
     * ibatis.binding.BindingException: Parameter 'offset' not found. Available
     * parameters are [0, 1, param1, param2]
     * java 没有保存形参记录
     *  List<Seckill> queryAll(int offset, int limit);-> queryAll(arg0,arg1)
     */


    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        seckills.forEach(seckill -> System.out.println(seckill));
    }

    /**
     *  UPDATE seckill SET number = number - 1 WHERE
     *  seckill_id = ? AND start_time <= ? AND end_time >= ? AND number > 0;
     * @throws Exception
     */
    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000, killTime);
        Assert.assertEquals(updateCount, 1);
    }

}