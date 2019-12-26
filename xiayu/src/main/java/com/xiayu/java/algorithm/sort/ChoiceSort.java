package com.xiayu.java.algorithm.sort;

/**
 * @author: test_
 * @date: 2019/9/17
 */
public class ChoiceSort {
    /*
        选择排序
            不断的选择未排序部分的极值,放到数组的一边作为已排序的部分.
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
}
