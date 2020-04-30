package com.example.shop.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyGlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> handlerMyException(
            HttpServletRequest req
            , HttpServletResponse rep
            , MyException e){
        ErrorInfo<String> errorInfo=new ErrorInfo<>();
        errorInfo.setStatus(rep.getStatus());
        errorInfo.setErrType(e.getClass().toString());
        errorInfo.setMsgTitle(ErrorType.getErrorType(e.getClass().getSimpleName()).getErrMsg());
        errorInfo.setMsgDetail(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setData("错误数据");
        logger.error("\033[31;2m" + "自定义异常捕捉打印："+ errorInfo.toString() + "\033[0m");
        return errorInfo;
    }

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> handlerGlobalException(
        HttpServletRequest req
        , HttpServletResponse rep
        , Exception e){
        ErrorInfo<String> errorInfo=new ErrorInfo<>();
        errorInfo.setStatus(rep.getStatus());
        errorInfo.setErrType(e.getClass().toString());
        errorInfo.setMsgTitle(ErrorType.getErrorType(e.getClass().getSimpleName()).getErrMsg());
        errorInfo.setMsgDetail(e.getMessage());
        errorInfo.setUrl(req.getRequestURI());
        errorInfo.setData("错误数据");
        logger.error("\033[31;2m" + "全局异常捕捉打印："+ errorInfo.toString() + "\033[0m");
        return errorInfo;
    }
//判断是否是ajax请求
//    if ((request.getHeader("accept").indexOf("application/json") > -1 || (request
//            .getHeader("X-Requested-With") != null && request.getHeader(
//            "X-Requested-With").indexOf("XMLHttpRequest") > -1)))
//
//    {
//    }
    }