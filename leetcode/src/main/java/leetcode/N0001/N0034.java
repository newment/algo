package leetcode.N0001;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 */
public class N0034 {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int i = this.searchLeft(nums, target);
        if(i == -1){
            return new int[]{-1, -1}; 
        }
        return new int[]{i, searchRight(nums, target)};
    }

    public int searchLeft(int[] nums, int target) {
        int i =0, j = nums.length - 1, candidate = -1;
        while(i <= j){
            int mid = (i+j) >>>1;
            if(nums[mid] < target){
                i = mid + 1;
            }
            else if (target < nums[mid]){
                j = mid - 1;
            }
            else{
                candidate = mid;
                j = mid-1;
            }
        }
        return candidate;
    }

    public int searchRight(int[] nums, int target) {
        int i =0, j = nums.length - 1, candidate = -1;
        while(i <= j){
            int mid = (i+j) >>>1;
            if(nums[mid] < target){
                i = mid + 1;
            }
            else if (target < nums[mid]){
                j = mid - 1;
            }
            else{
                candidate = mid;
                i = mid + 1;
            }
        }
        return candidate;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        int[] ints = new N0034().searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
