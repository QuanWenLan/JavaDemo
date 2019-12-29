package com.lanwq.demo.qq.eightpolymorphism.fieldandstatic;

/**
 * @program: JavaDemo -->FiledAccess
 * @Description : <blue>多态下的域访问</blue> <p>静态方法不具备多态的特性</p>
 * @author: lanwenquan
 * @creatTime: 2019-12-29 16 : 14
 **/

public class FiledAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // 向上转型
        System.out.println("sup.filed = " + sup.field + ", sup.getField = " + sup.getField());
        // h后面的这个方法是调用的子类（导出类）本身的方法，不是基类的方法，因为有重写

        Sub sub = new Sub();
        System.out.println("sub.filed = " + sub.field + ", sub.getField = " + sub.getField() + " " +  sub.getSuperField());

    }
}

class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}