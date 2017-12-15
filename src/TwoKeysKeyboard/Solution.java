package TwoKeysKeyboard;

/**
 * Created by bqh on 2017/8/6.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public int minSteps(int n) {
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                if (i%j == 0){
                    dp[i] = Math.min(i, dp[j]+i/j);
                }
            }
        }
        return dp[n];
    }
}
