package com.freedy.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * @author Freedy
 * @date 2021/6/24 19:17
 */
public class RadixSort {
    public static void main(String[] args) {
        //20个随机数
        int[] arr = {368, 93, 284, 507, 204, 620, 331, 573, 910, 977,
                711, 305, 825, 438, 698, 49, 868, 241, 598, 737};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketIndex = new int[10];
        int max = Integer.MIN_VALUE;
        for (int k : arr) {
            int length;
            if ((length = String.valueOf(k).length()) > max)
                max = length;
        }
        for (int i = 0; i < max; i++) {
            for (int k : arr) {
                int digit = (k / (int) (Math.pow(10,i))) % 10;
                bucket[digit][bucketIndex[digit]++] = k;
            }
            int index, n = 0;
            for (int i1 = 0; i1 < bucketIndex.length; i1++) {
                if ((index = bucketIndex[i1]) > 0) {
                    for (int i2 = 0; i2 < index; i2++) {
                        arr[n++] = bucket[i1][i2];
                    }
                }
            }
            bucketIndex = new int[10];
        }
    }
}
