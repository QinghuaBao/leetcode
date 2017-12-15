package MaximumLengthofPairChain;


/**
 * Created by bqh on 2017/8/8.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        int[][] pairs = {{-10,-8}, {8,9}, {-5,0}, {6,10}, {-6,-4}, {1,7}, {9,10}, {-4, 7}};
        System.out.println(findLongestChain(pairs));
    }

    //先按照第二个数排序，然后是最长递增子序列
    public static int findLongestChain(int[][] pairs) {
        int count = 0;
        int lastend = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            boolean flag = false;
            int end = 0;
            for (int j = 0; j < pairs.length; j++) {
                if (pairs[j][0] > lastend){
                    if (!flag){
                        end = pairs[j][1];
                    }
                    end = Math.min(end, pairs[j][1]);
                    flag = true;
                }
            }
            if (flag){
                lastend = end;
                count++;
            }
        }
        return count;
    }
}
