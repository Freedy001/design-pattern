package com.freedy.learn;

/**
 * @author Freedy
 * @date 2021/7/12 15:02
 */
public class FindMidNum {
    public static void main(String[] args) {
        System.out.println(new FindMidNum().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length+nums2.length];
        int l = 0, r = 0, cursor = 0;
        for (; l < nums1.length && r < nums2.length; cursor++) {
            if (nums1[l] <= nums2[r]) {
                temp[cursor] = nums1[l];
                l++;
            } else {
                temp[cursor] = nums2[r];
                r++;
            }
        }
        for (;l < nums1.length;l++,cursor++) temp[cursor] = nums1[l];
        for (;r < nums2.length;r++,cursor++) temp[cursor] = nums2[r];
        int length = temp.length;
        return length %2==0?(temp[length/2]+temp[length/2-1])/2.0: temp[length /2];
    }

}
