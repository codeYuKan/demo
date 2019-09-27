package com.yukan.demo.source.lang.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * @author yukan
 * @date 2019/9/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FinalizeDemo {

    @Getter
    @Setter
    @AllArgsConstructor
    static class Clothes {

        private String color;

        private double length;

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            log.info("finalize...");
        }
    }

    @AllArgsConstructor
    public static class Test<T>{

        private Clothes clothes;

        public Clothes get(){
            return clothes;
        }
    }

    public static Test<Clothes> test(){
        Clothes clothes = new Clothes("black", 100);
        return new Test<>(clothes);
    }

    public static WeakReference<Clothes> test2(){
        Clothes clothes = new Clothes("black", 100);
        return new WeakReference<>(clothes);
    }

    public static void main(String[] args) {
        WeakReference<Clothes> clothesWeakReference = test2();
        int count = 0;
        while (true) {
            if(Objects.nonNull(clothesWeakReference.get())) {
                count++;
                log.info("Object {} is alive for {} loops.", clothesWeakReference, count);
            } else {
                log.info("Object {} has been collected.", clothesWeakReference);
                break;
            }
            //Runtime.getRuntime().runFinalization();
            //System.gc();
        }
    }
}
