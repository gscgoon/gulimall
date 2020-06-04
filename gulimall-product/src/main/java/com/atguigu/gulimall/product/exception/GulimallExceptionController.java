package com.atguigu.gulimall.product.exception;

import com.atguigu.common.exception.StatusCodeEnum;
import com.atguigu.common.utils.R;
import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.atguigu.gulimall.product.controller")
public class GulimallExceptionController {

    //数据校验异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        //日志
        log.error("数据校验异常{}，异常类型{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        //将所有的异常信息添加到集合中
        Map<String, String> errorsMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item)->{
            errorsMap.put(item.getField(),item.getDefaultMessage());
        });
        return R.error(StatusCodeEnum.VALID_EXCEPTION.getCode(),StatusCodeEnum.VALID_EXCEPTION.getMsg()).put("data",errorsMap);
    }

    //统一异常
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable e){
        return R.error(StatusCodeEnum.UNKNOWN_EXCEPTION.getCode(),StatusCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
