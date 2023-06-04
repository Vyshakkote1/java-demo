package com.xing.democlone.demoexception.controller;


import com.xing.democlone.demoexception.model.ApiResponse;
import com.xing.democlone.demoexception.constant.Status;
import com.xing.democlone.demoexception.exception.JsonException;
import com.xing.democlone.demoexception.exception.PageException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/exception")
@Api(tags = "1.0.0-SNAPSHOT", value = "异常测试")
public class TestController {
    @GetMapping("/json")
    @ApiOperation(value = "json异常", notes = "备注")
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @GetMapping("/page")
    @ApiOperation(value = "页面异常", notes = "备注")
    public ModelAndView pageException() {
        throw new PageException(Status.UNKNOWN_ERROR);
    }
}
