package com.xiayu.java.datastructure.set;

import java.util.LinkedHashSet;

/**
 * @author: starc
 * @date: 2019/6/8
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add("fuck");
        set.add("you");
        for (Object next : set) {
            System.out.println(next.toString());
        }
    }
}
