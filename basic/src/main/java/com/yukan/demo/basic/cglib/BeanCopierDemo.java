package com.yukan.demo.basic.cglib;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;

/**
 * @author yukan
 * @date 2020/10/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class BeanCopierDemo {

    public static void test1() {
        A a = new A();
        a.setA("tttt");
        a.setB(333);

        // 名称相同而类型不同的属性不会被拷贝。
        // 即使源类型是 原始类型(int, short和char等)，目标类型是其 包装类型(Integer, Short和Character等)，或反之：都 不会被拷贝。
        BeanCopier beanCopier = BeanCopier.create(A.class, B.class, false);
        B b = new B();
        beanCopier.copy(a, b, null);
        log.info("b.a={},b.b={}", b.getA(), b.getB());
    }

    public static void main(String[] args) {
        test1();
    }


}

class A {
    String a;
    int b;

    public A() {
    }

    public String getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof A)) return false;
        final A other = (A) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$a = this.getA();
        final Object other$a = other.getA();
        if (this$a == null ? other$a != null : !this$a.equals(other$a)) return false;
        if (this.getB() != other.getB()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof A;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $a = this.getA();
        result = result * PRIME + ($a == null ? 43 : $a.hashCode());
        result = result * PRIME + this.getB();
        return result;
    }

    public String toString() {
        return "A(a=" + this.getA() + ", b=" + this.getB() + ")";
    }
}

@Data
class B {
    String a;
    int b;
}
