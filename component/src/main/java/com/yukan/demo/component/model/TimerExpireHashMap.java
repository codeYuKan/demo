package com.yukan.demo.component.model;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 不好用 一旦异常定时器就停止了
 *
 * @author yukan
 * @date 2020/10/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class TimerExpireHashMap<K, V> extends HashMap<K, V> {

    // 定时删除过期键，间隔时间
    private static final long CHECK_TIME_SECOND = 1 * 1000;

    // 默认过期时间容器初始化数量
    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    /**
     * 定时器
     */
    private final Timer timer = new Timer();

    /**
     * 过期时间容器
     */
    private Map<K, Long> timerMap;

    //private TimerExpireHashMapCallback<K, V> timerExpireHashMapCallback;

    private final TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            long currentTime = System.currentTimeMillis();
            timerMap.keySet().forEach(key -> {
                Long keyTime = timerMap.get(key);
                if (currentTime >= keyTime) {
                    //// 回调相关
                    //if (Objects.nonNull(timerExpireHashMapCallback)) {
                    //    try {
                    //        timerExpireHashMapCallback.callback(key, get(key));
                    //    } catch (RuntimeException re) {
                    //        log.error("TimerExpireHashMap.error:", re);
                    //    }
                    //}
                    TimerExpireHashMap.super.remove(key);

                    timerMap.remove(key);
                    remove(key);
                }
            });
        }
    };

    public TimerExpireHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        init(initialCapacity, loadFactor);
    }

    public TimerExpireHashMap(int initialCapacity) {
        super(initialCapacity);
        init(initialCapacity);
    }

    public TimerExpireHashMap() {
        super();
        init(DEFAULT_INITIAL_CAPACITY);
    }

    public TimerExpireHashMap(Map<K, V> map) {
        super(map);
        init(DEFAULT_INITIAL_CAPACITY);
    }

    private void init(int initialCapacity) {
        timerMap = new HashMap<>(initialCapacity);
        timer.scheduleAtFixedRate(timerTask, 0, CHECK_TIME_SECOND);
    }

    private void init(int initialCapacity, float loadFactor) {
        timerMap = new HashMap<>(initialCapacity, loadFactor);
        timer.scheduleAtFixedRate(timerTask, 0, CHECK_TIME_SECOND);
    }

    @Override
    public V get(Object key) {
        Long expireTime = checkKeyExpireTime(key);
        if (Objects.isNull(expireTime) || expireTime > 0) {
            return super.get(key);
        }
        return null;
    }

    public void put(K key, V value, Long expireSecond) {
        if (Objects.nonNull(expireSecond) && expireSecond > 0) {
            setExpireTime(key, expireSecond);
        }
        super.put(key, value);
    }

    private Long checkKeyExpireTime(Object key) {
        Long second  = timerMap.get(key);
        if (Objects.isNull(second)) {
            return null;
        }
        long currentTime = System.currentTimeMillis();
        return (second - currentTime) / 1000;
    }

    private void setExpireTime(K key, Long expireSecond) {
        if (Objects.nonNull(expireSecond) && expireSecond > 0) {
            long currentTime = System.currentTimeMillis();
            long expireTime = currentTime + expireSecond * 1000;
            timerMap.put(key, expireTime);
        }
    }

    //public void setTimerExpireHashMapCallback(TimerExpireHashMapCallback<K, V> timerExpireHashMapCallback) {
    //    this.timerExpireHashMapCallback = timerExpireHashMapCallback;
    //}

    static interface TimerExpireHashMapCallback<K, V> {
        public void callback(K key, V value) throws RuntimeException;
    }
}