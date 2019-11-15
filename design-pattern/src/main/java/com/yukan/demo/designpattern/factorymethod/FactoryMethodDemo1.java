package com.yukan.demo.designpattern.factorymethod;

import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * 工厂方法设计模式
 *
 * @author yukan
 * @date 2019/10/30
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FactoryMethodDemo1 {

    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Product productA = factoryA.createProduct();
        productA.display();
        log.info("**************************************");
        Factory factoryB = new FactoryB();
        Product productB = factoryB.createProduct();
        productB.display();
    }
}

@SuperBuilder
@Slf4j
abstract class Product {
    private String name;

    void display() {
        log.info("default display");
    }
}

interface Factory {
    Product createProduct();
}

@SuperBuilder
@ToString
@Slf4j
class ProductA extends Product {

    @Override
    void display() {
        log.info("product A display");
    }
}

@SuperBuilder
@ToString
@Slf4j
class ProductB extends Product {

    @Override
    void display() {
        log.info("product B display");
    }
}

class FactoryA implements Factory {

    @Override
    public Product createProduct() {
        return ProductA.builder().name("zhangsan").build();
    }
}

class FactoryB implements Factory {

    @Override
    public Product createProduct() {
        return ProductB.builder().name("lisi").build();
    }
}