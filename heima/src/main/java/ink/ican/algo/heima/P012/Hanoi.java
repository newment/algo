package ink.ican.algo.heima.P012;

import java.util.LinkedList;
import java.util.List;

public class Hanoi {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int n){
        for (int i = n; i > 0; i--) {
            a.add(i);
        }
    }

    /**
     *
     * @param n 盘子数量
     * @param a 源柱子
     * @param b 借助柱子
     * @param c 目标柱子
     */
    public static void hanoi(int n, List<Integer> a, List<Integer> b, List<Integer> c){
        if(n == 0){
            return;
        }
        hanoi(n-1, a, c, b);
        c.addLast(a.removeLast());
        hanoi(n-1, b, a, c);
        print();
    }

    public static void main(String[] args) {
        int n = 30;
        init(n);
        hanoi(n, a, b, c);
        print();
    }

    public static void print(){
        System.out.println("---------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }



}
