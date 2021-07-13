package com.freedy.learn;

import java.util.Scanner;

/**
 * @author Freedy
 * @date 2021/6/27 0:14
 */
public abstract class LineGraph {
    public int testInt = 5;



//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int dis = scanner.nextInt();
//        int[] position = new int[n];
//        for (int i = 0; i < n; i++) {
//            position[i] = scanner.nextInt();
//        }
//
//        int tem, end = rangeLength(tem = position[0], tem + dis, position);
//        int count = C(end, 3);
//        for (int start = 1; start < position.length; start++) {
//            int temp, length = rangeLength(temp = position[start], temp + dis, position);
//            if (start + length > end && length >= 3) {
//                int cell1 = end - start + 1;
//                int cell2 = start + length - end + 1;
//                end = start + length;
//                if (cell2 >= 3) {
//                    count += C(cell2, 3) + C(cell2, 2) * C(cell1, 1) + C(cell2, 1) * C(cell1, 2);
//                }
//                if (cell2 == 2) {
//                    count += C(cell2, 2) * C(cell1, 1) + C(cell2, 1) * C(cell1, 2);
//                }
//                if (cell2 == 1) {
//                    count += C(cell2, 1) * C(cell1, 2);
//                }
//            }
//        }
//
//
//        System.out.println(count);
//    }
//
//    public static int rangeLength(int start, int end, int[] arr) {
//        int count = 0;
//        for (int i : arr) {
//            if (i >= start && i <= end) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    /**
//     * 排列组合
//     */
//    public static int C(int down, int up) {
//        int higher = 1;
//        for (int i = 0; i < up; i++) {
//            higher *= down;
//            down--;
//        }
//        int lower = 1;
//        for (int i = 1; i <= up; i++) {
//            lower *= i;
//        }
//        return higher / lower;
//    }

}
