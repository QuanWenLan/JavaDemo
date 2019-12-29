package com.lanwq.demo.qq.eightpolymorphism;

/**
 * @program: JavaDemo -->ReferenceCounting
 * @Description : <blue>对共享的成员进行清理</blue>
 * <p>利用引用计数来跟踪仍旧访问者共享对象的对象数量</p>
 * @author: lanwenquan
 * @creatTime: 2019-12-29 17 : 25
 **/

public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared), new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)
        };
        for (Composing c :
                composing) {
            c.dispose();
        }
        System.gc();
        new Composing(new Shared());
        System.gc();
    }
}

class Shared {
    private int refCount = 0; // 用来计数有几个对象使用了这个 shared 共享对象
    private static long counter = 0; // 使用了static来修饰成员变量，这样每次创建对象的时候都会在前一次的操作基础上进行
    private final long id = counter++;

    public Shared() {
        System.out.println("creating " + this);
    }

    public void addRef() {
        refCount++;
    }

    public void dispose() {
        if (--refCount == 0) {
            System.out.println("disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "shared " + id;
    }

    protected void finalize() {
        if (refCount != 0) {
            System.out.println("error ！object is not property clean-up");
        }
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("creating " + this);
        this.shared = shared;
        shared.addRef();
    }

    @Override
    public String toString() {
        return "composing " + id;
    }

    public void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

}