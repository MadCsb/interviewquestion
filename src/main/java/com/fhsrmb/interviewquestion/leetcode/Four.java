package com.fhsrmb.interviewquestion.leetcode;

/**
 * @title 两个排序数组的中位数
 *
 * Created by cheng on 2018/9/12.
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 不同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class Four {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0 ;
        int i=0,j=0;
        int midPlus = (nums1.length+nums2.length)%2;
        int mid = (nums1.length+nums2.length)/2;
        while(i<nums1.length || j<nums2.length )
        {
            Boolean currentI = null;
            if(i>=nums1.length)
            {
                currentI = false;
            }else if (j>=nums2.length)
            {
                currentI = true;
            }else
            {
                if(nums1[i]<nums2[j]){
                    currentI = true;
                }else{
                    currentI = false;
                }
            }
            if (i+j == (mid-1) && midPlus == 0)
            {
                median = (currentI?nums1[i]:nums2[j]);
            }
            if (i+j == mid)
            {
                if (midPlus == 0) {
                    median = (median + (currentI ? nums1[i] : nums2[j])) / 2;
                }
                else {
                    median = (currentI ? nums1[i] : nums2[j]);
                }
                break;
            }
            if (currentI){
                i++;
            }
            else{
                j++;
            }
        }
        return median;
    }

    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};

        System.out.println(new Four().findMedianSortedArrays(nums1,nums2));
    }
}
