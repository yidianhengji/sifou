package com.pg.bbs.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import javax.validation.UnexpectedTypeException;

@ControllerAdvice(basePackages = "com.pg.bbs.controller")
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Result<String> handlerBusinessException(Exception e) {
        BusinessException businessException = (BusinessException) e;
        log.warn("业务异常: {}", e);
        return new Result<String>(businessException.getCode(), businessException.getMsg());
    }

    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Result<Object> handlerHttpMediaTypeNotSupportedException(Exception e) {
        return new Result<Object>(BusinessStatus.TYPE_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Object> handlerMethodArgumentNotValidException(Exception e) {
        return new Result<Object>(BusinessStatus.PARAMETER_ERROR);
    }

    @ExceptionHandler(value = UnexpectedTypeException.class)
    @ResponseBody
    public Result<Object> handlerUnexpectedTypeException(Exception e) {
        log.warn("字段校验异常",e);
        return new Result<Object>(BusinessStatus.VOLID_ERROR);
    }

    @ExceptionHandler(value = MultipartException.class)
    @ResponseBody
    public Result<Object> handlerMultipartException(Exception e) {
        log.warn("文件异常",e);
        return new Result<Object>(BusinessStatus.FILE_EXIST_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> handler(Exception e) {
        log.warn("未知异常",e);
        return new Result<String>(BusinessStatus.ERROR,e.getMessage());
    }
}
