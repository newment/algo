package ink.ican.algo.heima.BASE;

/**
 * 双端队列接口
 * @param <E>
 */
public interface Deque<E> {
    boolean offerFirst(E e);
    boolean offerLast(E e);
    E pollFirst();
    E pollLast();
    E peekFirst();
    E peekLast();
    boolean isEmpty();
    boolean isFull();
}
