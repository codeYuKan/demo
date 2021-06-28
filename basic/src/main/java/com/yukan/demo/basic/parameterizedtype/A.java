package com.yukan.demo.basic.parameterizedtype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2021/5/29
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@AllArgsConstructor
@Data
public class A<X, Y, Z> extends B<X, Y, Z>{

    private X x;

    private Y y;

    private Z z;

    public C t() {
        return new C<Y>(){};
    }
}
