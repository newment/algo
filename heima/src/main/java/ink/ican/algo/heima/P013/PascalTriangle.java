package ink.ican.algo.heima.P013;

public class PascalTriangle {

    public static int element(int i, int j){
        if(j == 1 || i == j){
            return 1;
        }
        return element(i-1, j-1) + element(i-1, j);
    }

    public static void pascalTriangle(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.printf("   ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("%-6d", element(i, j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        pascalTriangle(20);
        print2(10);
    }


    public static void print2(int n){
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            createRow(row, i);
            for (int j = 0; j <= i; j++) {
                System.out.printf("%-6d", row[j]);
            }
            System.out.println();
        }
    }

    private static void createRow(int[] row, int i ){
        if(i == 0){
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j-1] + row[j];
        }
    }


}
