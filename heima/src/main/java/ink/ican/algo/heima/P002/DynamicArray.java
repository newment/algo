package ink.ican.algo.heima.P002;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 使用数组实现动态数组
 */

public class DynamicArray implements Iterable<Integer>{

    private int size = 0;

    private int capacity = 8;

    private int[] array = {};

    /**
     * 增加元素 addLast
     */
    public void addLast(int element){
        add(this.size, element);
    }

    public void add(int index, int element){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        checkAndGrow();
        if(index < size){
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * 容量检查
     */
    private void checkAndGrow() {
        if(this.size == 0) {
            array = new int[capacity];
        }
        else if(this.size == this.capacity){     // 扩容
            this.capacity += this.capacity>>1;
            int[] newArray = new int[this.capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        int remove = array[index];
        System.arraycopy(array, index + 1, array, index, --size - index);
        return remove;
    }

    /**
     * 遍历 方法一 函数式
     * @param consumer
     */
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    /**
     * 遍历 方法二 迭代器
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {  // 有没有下一个元素
                return i<size;
            }

            @Override
            public Integer next() {     // 返回当前元素并移动到下一个元素
                return array[i++];
            }
        };
    }

    /**
     * 遍历 方法三 流
     * @return
     */
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }



    @Override
    public String toString() {
        return "DynamicArray{" +
                "size=" + size +
                ", capacity=" + capacity +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
