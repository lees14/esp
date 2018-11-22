package cn.most.esp.common;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.shiro.session.UnknownSessionException;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class CtrlExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(CtrlExceptionHandler.class);

    //拦截未授权页面
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public String handleException(UnauthorizedException e) {
        logger.debug(e.getMessage());
        return "403";
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public String handleException2(AuthorizationException e) {
        logger.debug(e.getMessage());
        return "403";
    }
    
    //
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnknownSessionException.class)
    public String UnknownSessionException(UnknownSessionException e) {
        logger.debug(e.getMessage());
        return "403";
    }
}
