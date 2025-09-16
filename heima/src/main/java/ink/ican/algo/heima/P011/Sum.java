package ink.ican.algo.heima.P011;

public class Sum {

    public static long sum(int n){
        if(n == 1){
            return 1;
        }
        return sum(n-1) + n;
    }

    public static long sum(int n, int accumulator){
        if(n == 1){
            return 1 + accumulator;
        }
        return sum(n-1, accumulator + n) ;
    }

    public static void main(String[] args) {
//        System.out.println(sum(30080));
        System.out.println(sum(31000, 0));
    }

}
