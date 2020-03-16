package com.yukan.demo.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemoEnum {

    AAAAAAAAAA("A"),
    BBBBBBBBBB("B"){
        @Override
        public boolean a() {
            return true;
        }
    },
    CCCCCCCCCC("C"),
    DDDDDDDDDD("D");

    private String status;

    public boolean a() {
        return false;
    }
}