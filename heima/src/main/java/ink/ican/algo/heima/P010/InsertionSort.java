package ink.ican.algo.heima.P010;

public class InsertionSort {

    public static void sort(int[] nums){
        insertion(nums, 1);
    }


    public static void insertion(int[] nums, int low){
        if(low == nums.length){
            return;
        }

        int t = nums[low];
        int i = low - 1;
        while(i >= 0 && nums[i] > t){
            nums[i+1] = nums[i];
            i--;
        }
        if(i+1 != low){
            nums[i+1] = t;
        }
        insertion(nums, low+1);
    }

}
