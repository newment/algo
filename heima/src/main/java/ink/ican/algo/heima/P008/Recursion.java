package ink.ican.algo.heima.P008;

public class Recursion {

    public static void main(String[] args) {
        int recursion1 = f(10);
        System.out.println(recursion1);
    }

    public static int f(int n){
        if(n == 1){
            return 1;
        }
        return n * f(n - 1);
    }

}
