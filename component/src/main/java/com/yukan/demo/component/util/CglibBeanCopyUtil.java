package com.yukan.demo.component.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class CglibBeanCopyUtil {

    private static ConcurrentMap<String, BeanCopier> beanCopiers = new ConcurrentHashMap<>();

    /**
     * bean对象之间的copy
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        if (null == source || null == target) {
            return;
        }
        BeanCopier copier = createCopier(source, target);
        copier.copy(source, target, null);
    }

    /**
     * copy bean
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> T copyProperties(Object source, Class<T> destinationClass){
        try {
            T t = destinationClass.newInstance();
            copyProperties(source, t);
            return t;
        } catch (InstantiationException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
    }


    /**
     * 集合copy
     *
     * @param sourceList
     * @param destinationClass
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = new ArrayList<>();
        try {
            for (Iterator<?> iterator = sourceList.iterator(); iterator.hasNext(); ) {
                Object sourceObject = iterator.next();
                T destinationObject = destinationClass.newInstance();
                copyProperties(sourceObject, destinationObject);
                destinationList.add(destinationObject);
            }
        } catch (InstantiationException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
        return destinationList;
    }


    private static BeanCopier createCopier(Object srcClz, Object tagClz) {
        String key = generateKey(srcClz, tagClz);
        if (beanCopiers.containsKey(key)) {
            return beanCopiers.get(key);
        }
        beanCopiers.putIfAbsent(key, BeanCopier.create(srcClz.getClass(), tagClz.getClass(), false));
        return beanCopiers.get(key);

    }

    private static String generateKey(Object class1, Object class2) {
        return class1.getClass().getName() + class2.getClass().getName();
    }
}
