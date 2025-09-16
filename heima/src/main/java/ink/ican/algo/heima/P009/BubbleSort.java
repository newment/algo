package ink.ican.algo.heima.P009;

public class BubbleSort {
    public static void sort(int[] nums){
        bubble(nums, nums.length-1);
    }

    public static void bubble(int[] nums, int j){
        if(j == 0){
            return;
        }
        for (int i = 0; i < j; i++) {
            if(nums[i] > nums[i+1]){
                swap(nums, i, i+1);
            }
        }
        bubble(nums, j-1);
    }

    public static void bubble1(int[] nums, int j){
        if(j == 0){
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if(nums[i] > nums[i+1]){
                swap(nums, i, i+1);
                x = i;
            }
        }
        bubble1(nums, x);
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
