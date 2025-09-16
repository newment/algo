package ink.ican.algo.heima.P003;

import cn.hutool.core.date.StopWatch;
import org.junit.jupiter.api.Test;

public class DoubleArrayCacheTest {
    
    public static void ij(int[][] a, int rows, int columns){
        long sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void ji(int[][] a, int rows, int columns){
        long sum = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    @Test
    public void test() {
        int rows = 1_000_000;
        int columns = 14;
        int[][] a = new int[rows][columns];
        StopWatch sw = new StopWatch();
        sw.start("ij");
        ij(a, rows, columns);
        sw.stop();

        sw.start("ji");
        ji(a, rows, columns);
        sw.stop();

        System.out.println(sw.prettyPrint());

    }

}
