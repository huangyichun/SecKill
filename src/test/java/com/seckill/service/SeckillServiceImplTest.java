package com.seckill.service;

import com.seckill.dto.Exposer;
import com.seckill.dto.SeckillExecution;
import com.seckill.exception.SeckillException;
import com.seckill.mode.Seckill;
import com.seckill.mode.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by huangyichun on 2017/6/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

    @Autowired
    private SeckillService seckillService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if (exposer.isExposed()) {
            long phone = 15502456523L;
            logger.info("exposer={}", exposer);
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = null;
            try {
                seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("seckillExecution={}", seckillExecution);

            } catch (SeckillException e) {
                logger.info("e={}", e);
            }
        }else {
            //秒杀未开启
            logger.warn("exposer={}",exposer);
        }

        //exposer=Exposer{exposed=true,
        // md5='27de6336ee4dfce903d6af422686a1b7',
        // seckillId=1000, now=0, start=0, end=0}

    }

}