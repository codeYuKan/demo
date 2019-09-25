package com.yukan.demo.source.util.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class CloneDemo {

    @Getter
    @Setter
    @AllArgsConstructor
    static class Clothes implements Cloneable {

        private String color;

        private int length;

        @Override
        protected Clothes clone() throws CloneNotSupportedException {
            return (Clothes)super.clone();
        }
    }


    /**
     *
     */
    private static void test1() throws CloneNotSupportedException {
        Clothes clothes = new Clothes("black", 100);
        Clothes cloneClothes = clothes.clone();
        // result:clothes:com.yukan.demo.source.util.object.CloneDemo$Clothes@5419f379,cloneClothes=com.yukan.demo.source.util.object.CloneDemo$Clothes@7dc7cbad
        log.info("clothes:{},cloneClothes={}", clothes, cloneClothes);
        clothes.setColor("red");
        log.info("clothes.getColor:{},cloneClothes.color():{}", clothes.getColor(), cloneClothes.getColor());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        test1();
    }

}
