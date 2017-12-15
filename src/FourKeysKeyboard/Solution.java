package FourKeysKeyboard;

/**
 * Created by bqh on 2017/8/1.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxA(7));
    }

    public int minSteps(int n) {
        if (n <= 4){
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 4;
        for (int i = 4; i < n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-2; j < n; j++) {

            }
        }
        return 0;
    }

    public static int maxA(int N) {
        if (N <= 6){
            return N;
        }

        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 4;
        dp[4] = 5;
        dp[5] = 6;
        for (int i = 6; i < N; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-3; j > 0 ; j--) {
                dp[i] = Math.max(dp[i], (i-j-1)*dp[j]);
            }
        }
        return dp[N-1];
    }
}
