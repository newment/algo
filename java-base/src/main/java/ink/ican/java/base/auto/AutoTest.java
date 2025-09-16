package ink.ican.java.base.auto;

public class AutoTest {
    public static void main(String[] args) {
        Integer a=1, b=2;
        System.out.println(a+b);
        Integer c = a+b;
        System.out.println(c);

        Boolean flag = true;
        Boolean simpleBoolean = false;
        Boolean nullBoolean = null;
        Boolean x = flag ? nullBoolean : simpleBoolean;
        System.out.println(x);
    }
}
