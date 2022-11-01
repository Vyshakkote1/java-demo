package com.xing.demoexception.exception;

import com.xing.demoexception.constant.Status;
import lombok.Getter;


@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
