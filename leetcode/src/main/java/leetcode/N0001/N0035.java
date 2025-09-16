package leetcode.N0001;

import leetcode.N0701.N0704;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/"/>...</a>
 */
public class N0035 {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i<=j){
            int mid = (i+j)>>>1;
            if(target < nums[mid]){
                j = mid-1;
            }
            else if(target > nums[mid]){
                i = mid + 1;
            }
            else {
                return mid;
            }
        }
        return i;
    }

    public int searchInsert1(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i<=j){
            int mid = (i+j)>>>1;
            if(target <= nums[mid]){
                j = mid-1;
            }
            else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(new N0035().searchInsert1(nums, target));
    }
}
