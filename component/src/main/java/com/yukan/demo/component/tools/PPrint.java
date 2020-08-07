package com.yukan.demo.component.tools;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author yukan
 * @date 2020/5/29
 * @email yukan.cn.mail@gmail.com
 */
public class PPrint {
    public PPrint() {
    }

    public static String pformat(Collection<?> c) {
        if (c.size() == 0) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[");

            Object elem;
            for(Iterator var3 = c.iterator(); var3.hasNext(); result.append(elem)) {
                elem = var3.next();
                if (c.size() != 1) {
                    result.append("\n  ");
                }
            }

            if (c.size() != 1) {
                result.append("\n");
            }

            result.append("]");
            return result.toString();
        }
    }

    public static void pprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void pprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
