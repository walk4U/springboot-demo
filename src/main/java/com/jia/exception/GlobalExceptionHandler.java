package com.jia.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jia.model.result.CodeMsg;
import com.jia.model.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

/**
 * @Auther: jia
 * @Date: 2018/7/25 14:59
 * @Description: 全局统一异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    public ModelAndView handlerException(Exception ex) {
        ModelAndView mv = new ModelAndView();
        //使用MappingJackson2JsonView图返回，每个controller不需要捕获异常
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        ObjectMapper m = new ObjectMapper();
        Map<String, Object> mappedObject = m.convertValue(Result.fail(CodeMsg.SERVER_EXCEPTION), Map.class);
        view.setAttributesMap(mappedObject);
        mv.setView(view);
        logger.error("Handle Exception", ex);
        return mv;
    }
}
