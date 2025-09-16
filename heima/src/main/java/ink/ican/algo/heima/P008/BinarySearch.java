package ink.ican.algo.heima.P008;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target  = 3;
        System.out.println(binarySearch(nums, target));
    }
    public static int binarySearch(int[] nums, int target){
        return binaryRecursion(nums, target, 0, nums.length - 1);
    }

    public static int binaryRecursion(int[] nums, int target, int i, int j){
        if(i > j){
            return -1;
        }
        int mid = (i+j) >>> 1;
        if( nums[mid] < target){
            return binaryRecursion(nums, target, mid + 1, j);
        }
        else if(target < nums[mid]){
            return binaryRecursion(nums, target, i, mid - 1);
        }
        else{
            return mid;
        }
    }

    @Test
    @DisplayName("binarySearchBasic 找到")
    public void testBasic1() {
        Assertions.assertEquals(0, binarySearch(new int[]{1, 2, 3, 4, 5}, 1));
        Assertions.assertEquals(1, binarySearch(new int[]{1, 2, 3, 4, 5}, 2));
        Assertions.assertEquals(2, binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
        Assertions.assertEquals(3, binarySearch(new int[]{1, 2, 3, 4, 5}, 4));
        Assertions.assertEquals(4, binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    @DisplayName("binarySearchBasic 没找到")
    public void testBasic2() {
        Assertions.assertEquals(-1, binarySearch(new int[]{1, 2, 3, 4, 5}, -1));
        Assertions.assertEquals(-1, binarySearch(new int[]{1, 2, 3, 4, 5}, 6));
        Assertions.assertEquals(-1, binarySearch(new int[]{1, 2, 4, 5, 6}, 3));
    }
}
