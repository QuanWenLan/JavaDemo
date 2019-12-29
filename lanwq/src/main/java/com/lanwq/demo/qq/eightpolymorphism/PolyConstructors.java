package com.lanwq.demo.qq.eightpolymorphism;

/**
 * @program: JavaDemo -->PolyConstructors
 * @Description : <blue>构造器内部的多态方法的行为</blue>
 * @author: lanwenquan
 * @creatTime: 2019-12-29 22 : 36
 **/

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5); // 创建子类，存在基类的时候 draw方法会动态绑定
        /**
         * Glyph() before draw()
         * RoundGlyph.draw(), radius = 0
         * Glyph() after draw()
         * RoundGlyph.RoundGlyph(), radius = 5
         */
        // 创建一个父类的时候是会调用哪个方法？draw() 方法
        new Glyph(); // 这个时候不会动态绑定


    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    public Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    public RoundGlyph(int radius) {
        this.radius = radius;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}
/*
* 初始化的实际过程是：
1 在其他任何事物发生之前，将分配给对象的存储空间初始化为二进制的零或者null
2 在前面所示的那样调用基类构造器。此时，调用被覆盖后的draw方法（在RoundGlyph构造器之前调用），由于步骤一的缘故，此时radius的值是为 0
3 按照声明的顺序调用成员的初始化方法。
* 4 调用导出类的构造器主体
* *
* */