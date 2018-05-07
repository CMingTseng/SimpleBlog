package com.lany.blog;

import com.lany.blog.exception.TokenOverTimeException;
import com.lany.blog.exception.ValidationException;
import com.lany.blog.result.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.PrintWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult handleException(HttpServletRequest request, Exception ex) {
        ResponseResult result = new ResponseResult();
        result.setCode(500);
        result.setMsg(ex.getMessage());
        return result;
    }

    @ExceptionHandler(TokenOverTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult handleTokenOverTimeException(HttpServletRequest request, TokenOverTimeException ex) {
        ResponseResult result = new ResponseResult();
        result.setCode(500);
        result.setMsg(ex.getMessage());
        return result;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult handleValidationException(HttpServletRequest request, ValidationException ex) {
        ResponseResult result = new ResponseResult();
        result.setCode(500);
        result.setMsg(ex.getMessage());
        return result;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException ex) {
        ResponseResult result = new ResponseResult();
        result.setCode(500);
        result.setMsg(ex.getMessage());
        return result;
    }
}
