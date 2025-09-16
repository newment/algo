package ink.ican.algo.heima.P009;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PubbleSortTest {

    @Test
    public void testPuppleSort() {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        BubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
