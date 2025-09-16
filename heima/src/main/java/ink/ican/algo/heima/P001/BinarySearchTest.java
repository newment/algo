package ink.ican.algo.heima.P001;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static ink.ican.algo.heima.P001.BinarySearch.*;

public class BinarySearchTest {


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

    @Test
    @DisplayName("binarySearchAlternative 找到")
    public void testAlternative1() {
        Assertions.assertEquals(0, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, 1));
        Assertions.assertEquals(1, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, 2));
        Assertions.assertEquals(2, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, 3));
        Assertions.assertEquals(3, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, 4));
        Assertions.assertEquals(4, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    @DisplayName("binarySearchAlternative 没找到")
    public void testAlternative2() {
        Assertions.assertEquals(-1, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, -1));
        Assertions.assertEquals(-1, binarySearchAlternative(new int[]{1, 2, 3, 4, 5}, 6));
        Assertions.assertEquals(-1, binarySearchAlternative(new int[]{1, 2, 4, 5, 6}, 3));
    }

    @Test
    @DisplayName("binarySearchBalance 找到")
    public void testBinarySearchBalance1() {
        Assertions.assertEquals(0, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, 1));
        Assertions.assertEquals(1, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, 2));
        Assertions.assertEquals(2, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, 3));
        Assertions.assertEquals(3, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, 4));
        Assertions.assertEquals(4, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    @DisplayName("binarySearchBalance 未找到")
    public void testBinarySearchBalance2() {
        Assertions.assertEquals(-1, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, -1));
        Assertions.assertEquals(-1, binarySearchBalance(new int[]{1, 2, 3, 4, 5}, 6));
        Assertions.assertEquals(-1, binarySearchBalance(new int[]{1, 2, 4, 5, 6}, 3));
    }

    @Test
    @DisplayName("binarySearch Java版 未找到")
    public void testBinarySearchJava1() {
        Assertions.assertEquals(-1, Arrays.binarySearch(new int[]{1, 2, 3, 4, 5}, -1));
        Assertions.assertEquals(-6, Arrays.binarySearch(new int[]{1, 2, 3, 4, 5}, 6));
        Assertions.assertEquals(-3, Arrays.binarySearch(new int[]{1, 2, 4, 5, 6}, 3));
    }

    @Test
    @DisplayName("binarySearch Java版 插入点测试")
    public void testBinarySearchInsert() {
        int[] a = {2,5,8};
        int target = 4;
        int i = Arrays.binarySearch(a, target);
        System.out.println(i);

        if(i<0){
            int insertIndex = Math.abs(i+1);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }
    @Test
    @DisplayName("binarySearchLeftMost 测试")
    public void testBinarySearchLeftMost(){
        int[] a = {1,2,4,4,4,5,6,7};
        Assertions.assertEquals(0, binarySearchLeftMost(a, 1));
        Assertions.assertEquals(1, binarySearchLeftMost(a, 2));
        Assertions.assertEquals(2, binarySearchLeftMost(a, 4));
        Assertions.assertEquals(5, binarySearchLeftMost(a, 5));
        Assertions.assertEquals(6, binarySearchLeftMost(a, 6));
        Assertions.assertEquals(7, binarySearchLeftMost(a, 7));

        Assertions.assertEquals(-1, binarySearchLeftMost(a, 0));
        Assertions.assertEquals(-1, binarySearchLeftMost(a, 3));
        Assertions.assertEquals(-1, binarySearchLeftMost(a, 8));
    }

    @Test
    @DisplayName("binarySearchLeftMost1 测试")
    public void testBinarySearchLeftMost1(){
        int[] a = {1,2,4,4,4,5,6,7};
        Assertions.assertEquals(0, binarySearchLeftMost1(a, 1));
        Assertions.assertEquals(1, binarySearchLeftMost1(a, 2));
        Assertions.assertEquals(2, binarySearchLeftMost1(a, 4));
        Assertions.assertEquals(5, binarySearchLeftMost1(a, 5));
        Assertions.assertEquals(6, binarySearchLeftMost1(a, 6));
        Assertions.assertEquals(7, binarySearchLeftMost1(a, 7));

        Assertions.assertEquals(0, binarySearchLeftMost1(a, 0));
        Assertions.assertEquals(2, binarySearchLeftMost1(a, 3));
        Assertions.assertEquals(8, binarySearchLeftMost1(a, 8));
    }


    @Test
    @DisplayName("binarySearchRightMost 测试")
    public void testBinarySearchRightMost(){
        int[] a = {1,2,4,4,4,5,6,7};
        Assertions.assertEquals(0, binarySearchRightMost(a, 1));
        Assertions.assertEquals(1, binarySearchRightMost(a, 2));
        Assertions.assertEquals(4, binarySearchRightMost(a, 4));
        Assertions.assertEquals(5, binarySearchRightMost(a, 5));
        Assertions.assertEquals(6, binarySearchRightMost(a, 6));
        Assertions.assertEquals(7, binarySearchRightMost(a, 7));

        Assertions.assertEquals(-1, binarySearchRightMost(a, 0));
        Assertions.assertEquals(-1, binarySearchRightMost(a, 3));
        Assertions.assertEquals(-1, binarySearchRightMost(a, 8));
    }

    @Test
    @DisplayName("binarySearchRightMost11 测试")
    public void testBinarySearchRightMost1(){
        int[] a = {1,2,4,4,4,5,6,7};
        Assertions.assertEquals(0, binarySearchRightMost1(a, 1));
        Assertions.assertEquals(1, binarySearchRightMost1(a, 2));
        Assertions.assertEquals(4, binarySearchRightMost1(a, 4));
        Assertions.assertEquals(5, binarySearchRightMost1(a, 5));
        Assertions.assertEquals(6, binarySearchRightMost1(a, 6));
        Assertions.assertEquals(7, binarySearchRightMost1(a, 7));

        Assertions.assertEquals(-1, binarySearchRightMost1(a, 0));
        Assertions.assertEquals(1, binarySearchRightMost1(a, 3));
        Assertions.assertEquals(7, binarySearchRightMost1(a, 8));
    }
}

