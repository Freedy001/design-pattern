package com.freedy.learn;

import java.util.Arrays;

/**
 * @author Freedy
 * @date 2021/6/24 18:59
 */
public class MergeSort {
    public static void main(String[] args) {
        //20个随机数
        int[] arr = {368, 93, 284, 507, 204, 620, 331, 573, 910, 977,
                711, 305, 825, 438, 698, 49, 868, 241, 598, 737};
        sort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int left,int right,int[] temp){
        if (left>=right) return;
        int mid=(left+right)>>1;
        sort(arr,left,mid,temp);
        sort(arr,mid+1,right,temp);
        merge(arr,left,mid,right,temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l=left,r=mid+1,n=0;
        for (;l<=mid&&r<=right;n++){
            if (arr[l]<arr[r]){
                temp[n]=arr[l];
                l++;
            }else {
                temp[n]=arr[r];
                r++;
            }
        }
        for (;l<=mid;l++,n++) temp[n]=arr[l];
        for (;r<=right;r++,n++) temp[n]=arr[r];
        System.arraycopy(temp,0,arr,left,right-left+1);
    }
}
