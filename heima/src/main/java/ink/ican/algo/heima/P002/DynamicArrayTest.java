package ink.ican.algo.heima.P002;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {
    @Test
    public void testDynamic() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.add(0, 1);
//        dynamicArray.foreach(System.out::println);
//        for (Integer i : dynamicArray) {
//            System.out.println(i);
//        }

        int removed = dynamicArray.remove(0);
        assertEquals(1, removed);
//        dynamicArray.stream().forEach(System.out::println);

        assertIterableEquals(List.of(1,2,3), dynamicArray);
    }


    @Test
    public void testCheckCapacity() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.addLast(7);
        dynamicArray.addLast(8);
        dynamicArray.addLast(9);
        assertIterableEquals(List.of(1,2,3,4,5,6,7,8,9), dynamicArray);
    }
}
