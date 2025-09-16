package ink.ican.algo.heima.P011;

import cn.hutool.core.date.StopWatch;

import java.sql.Array;
import java.util.ArrayList;

public class Fibonacci {

    public static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        System.out.println("执行");
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacci1(int n){
        int[] cache = new int[n + 1];
        return f(n, cache);
    }

    public static int f(int n, int[] cache){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            cache[1] = 1;
            return 1;
        }
        if(cache[n] != 0){
            return cache[n];
        }
        System.out.println("执行");
        cache[n] = f(n - 1, cache) + f(n-2, cache);
        return cache[n];
    }


    public static void main(String[] args) {

        StopWatch sw = new StopWatch();
        sw.start("old");
        System.out.println(fibonacci(13));
        sw.stop();
        sw.start("new");
        System.out.println(fibonacci1(13));
        sw.stop();
        System.out.println(sw.prettyPrint());

        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("java");
        list.add("orange");

        list.remove("java");
        System.out.println(list);
        list.removeIf((s) -> s.equals("java"));
        System.out.println(list);
    }

}
