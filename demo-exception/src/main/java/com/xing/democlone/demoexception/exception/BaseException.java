package com.xing.democlone.demoexception.exception;

import com.xing.democlone.demoexception.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

//注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
//@EqualsAndHashCode(callSuper = true) 注解的作用就是将其父类属性也进行比较
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{
    private Integer code;
    private  String message;


    public BaseException(Status status) {
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
