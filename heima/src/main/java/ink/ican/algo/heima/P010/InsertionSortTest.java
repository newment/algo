package ink.ican.algo.heima.P010;

import ink.ican.algo.heima.P009.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSortTest {

    @Test
    public void testPuppleSort() {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        InsertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
