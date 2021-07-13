package com.freedy.learn;

import java.util.Arrays;

/**
 * @author Freedy
 * @date 2021/6/24 11:20
 */
public class QuickSort {
    public static void main(String[] args) {
        //20个随机数
        int[] arr = {368, 93, 284, 507, 204, 620, 331, 573, 910, 977,
                711, 305, 825, 438, 698, 49, 868, 241, 598, 737};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int left,int right){
        if (left>=right) return;
        int mid=(left+right)>>>1, midVal=arr[mid];
        int l=left,r=right;
        while (l<r){
            while (arr[l]<midVal) l++;
            while (arr[r]>midVal) r--;
            if (l==r) break;
            arr[l]=arr[l]^arr[r];
            arr[r]=arr[l]^arr[r];
            arr[l]=arr[l]^arr[r];
            if (arr[l]==midVal) r++;
            if (arr[r]==midVal) l++;
        }
        l--;r++;
        sort(arr,left,l);
        sort(arr,r,right);
    }
}
