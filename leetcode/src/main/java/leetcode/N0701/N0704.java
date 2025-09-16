package leetcode.N0701;

/**
 * <a href="https://leetcode.cn/problems/binary-search/">...</a>
 */
public class N0704 {

    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int m = (i+j) >>> 1;
            if(nums[m] < target){
                i = m + 1;
            }
            else if(nums[m] > target){
                j = m - 1;
            }
            else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(new N0704().search(nums, target));
    }

}
