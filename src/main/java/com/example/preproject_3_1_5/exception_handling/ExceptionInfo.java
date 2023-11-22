package com.example.preproject_3_1_5.exception_handling;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExceptionInfo {

    private String info;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
