package leetcode.N0001;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 描述:给你两个按非递减顺序排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n。
 * <a href="https://leetcode.cn/problems/merge-sorted-array/description/">合并两个有序数组</a>
 */
public class N0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] dest = new int[m + n];
        int i = 0, j = 0, p = 0;
        while (i < m || j < n) {
            if(i==m){
                dest[p++] = nums2[j++];
            }
            else if(j == n){
                dest[p++] = nums1[i++];
            }
            else if(i < m && nums1[i] < nums2[j]){
                dest[p++] = nums1[i++];
            }
            else {
                dest[p++] = nums2[j++];
            }
        }
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = dest[i];
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        int[] dest = new int[m+n];
        mergeRec(nums1, 0, m-1, m, m+n-1, dest, 0);
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = dest[i];
        }
    }

    public void mergeRec(int[] nums, int i, int iEnd, int j, int jEnd, int[] result, int k){
        if(i > iEnd){
            System.arraycopy(nums, j, result, k, jEnd-j +1);
            return;
        }
        if(j>jEnd){
            System.arraycopy(nums, i, result, k, iEnd-i +1);
            return;
        }
        if(nums[i] < nums[j]){
            result[k] = nums[i];
            mergeRec(nums, i+1, iEnd, j, jEnd, result, k+1);
        }
        else{
            result[k] = nums[j];
            mergeRec(nums, i, iEnd, j+1, jEnd, result, k+1);
        }


    }



    @Test
    public void test() {
        N0088 name = new N0088();
        int[] parameter1 = new int[]{1, 2, 3, 4, 5};
        int[] parameter2 = new int[]{3, 5, 6, 9, 10};
        int[] temp = new int[parameter1.length + parameter2.length];
        System.arraycopy(parameter1, 0, temp, 0, parameter1.length);
        name.merge1(temp, parameter1.length, parameter2, parameter2.length);
        System.out.println(Arrays.toString(temp));
    }

}