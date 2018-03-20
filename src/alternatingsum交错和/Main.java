package alternatingsum交错和;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by bqh on 2017/4/22.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Main {
    //18位，前面补一位0，就不进行特别讨论了
    //20 -9~+9
    //19位的和大致为-200~+200
    private Node[][][] dp = new Node[19][20][400];//[长度][以哪个数作为开头][该数的数位交错和]
    private int[] bit;
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("test.txt"));
    }

    //sign 0正1负
    private Node dfs(int len, int dig, boolean sign, boolean limit, int sum) {

        Node t = new Node();
        if(len <= 0 || len > 19 || dig < 0 || dig > 9 || sum < -200 || sum > 200)
            return t;
        //记忆话搜索，算法核心
        if (!limit && dp[len][sign ? dig : (dig += 10)][sum + 200].count != 0){
            return dp[len][dig][sum + 200];
        }

        if (len == 1){
            if (dig != sum)
                return t;
            else {
                t.sum = sum;
                t.count = 1;
                return t;
            }
        }

        int end = limit ? 9 : bit[len-2];
        int newSum = sum - (sign ? dig : (dig += 10));
        for (int i = 0; i < end + 1; i++) {

        }
        return t;
    }

}

class Node {
    public long sum = 0;
    public long count = 0;
}
