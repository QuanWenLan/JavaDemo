package com.lanwq.demo.qq.eightpolymorphism;

/**
 * @program: JavaDemo -->Transmogrify
 * @Description : <blue>设计模式----状态模式；用继承进行设计</blue>
 * @author: lanwenquan
 * @creatTime: 2019-12-29 23 : 07
 **/

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}

class Actor {
    public void act() {
    }
}

class HappyActor extends Actor {
    public void act() {
        System.out.println("happy actor");
    }
}

class SadActor extends Actor {
    public void act() {
        System.out.println("sad actor");
    }
}

class Stage {
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor(); // 状态模式
    }

    public void performPlay() {
        actor.act();
    }
}