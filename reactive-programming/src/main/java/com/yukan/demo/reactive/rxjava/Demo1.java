package com.yukan.demo.reactive.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author yukan
 * @date 2020/12/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Demo1 {

    public static void main(String[] args) {
        //被观察者在主线程中，每1ms发送一个事件
        Observable.interval(1, TimeUnit.MILLISECONDS)
        //.subscribeOn(Schedulers.newThread())
        //将观察者的工作放在新线程环境中

                .observeOn(Schedulers.newThread())
        //观察者处理每1000ms才处理一个事件
                .subscribe( aLong -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("TAG{}","---->"+aLong);
                });
    }
}
