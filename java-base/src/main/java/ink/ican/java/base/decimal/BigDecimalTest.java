package ink.ican.java.base.decimal;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(1);
        BigDecimal b2 = new BigDecimal(1.0);
        BigDecimal b3 = new BigDecimal(1.00);
        BigDecimal b4 = new BigDecimal("0.1");
        BigDecimal b5 = new BigDecimal("0.10");
        BigDecimal b6 = new BigDecimal(0.1);
        BigDecimal bigDecimal = BigDecimal.valueOf(0.1);
        System.out.println(b4.equals(b5));
        System.out.println(b4.compareTo(b5));
    }
}
