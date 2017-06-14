package com.seckill.exception;

import com.seckill.dto.SeckillExecution;

/**
 * 秒杀相关业务异常
 * Created by huangyichun on 2017/6/14.
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
