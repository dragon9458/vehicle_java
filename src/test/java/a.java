import java.util.Scanner;

public class a {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int[][] gifts = new int [4][4];

            for(int i = 0; i < 4; i++){
                for(int j = 0; j< 4; j++){
                    if(in.hasNextInt()){
                        gifts[i][j] = in.nextInt();
                    }
                }
            }

            getMost(gifts);



        }

    public static int getMost(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0)
            return 0;
        int n = values[0].length;
        int[] dp = new int[n];
        for (int[] value : values) {
            dp[0] += value[0];
            for (int i = 1; i < n; i++)
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
        }
        return dp[n - 1];
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

}
