package ink.ican.java.base.switch_;

public class SwitchTest {
    public static void main(String[] args) {
        String str = "world";
        switch (str){
            case "hello":
                System.out.println("hello");
            case "world":
                System.out.println("world");
            default:
                break;
        }
        if(false){
            System.out.println("false");
        }
    }
}
