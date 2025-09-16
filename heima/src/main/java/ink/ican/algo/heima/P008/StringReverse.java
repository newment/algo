package ink.ican.algo.heima.P008;

public class StringReverse {

    public static void main(String[] args) {
        reverse("hello world!");
    }

    public static void reverse(String s){
        if(s.isEmpty()){
            return ;
        }
        System.out.print(s.charAt(s.length() - 1));
        reverse(s.substring(0, s.length() - 1 ));
    }


}
