package LongestPalindromicSubstring;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bqh on 2017/4/20.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("test.txt"));
        int length = in.nextInt();
        for (int i = 0; i < length; i++) {
            Main main = new Main();
            int[] p = main.pk(in.next());
            int max = 0;
            for (int j = 0; j < p.length; j++) {
                if (max < p[j]) max = p[j];
            }
            //填充后回文字串长度应该是2max-1，其中max-1是回文字串，max是‘#’
            System.out.println(max - 1);
        }
    }

    //求p数组
    public int[] pk(String str){
        //填充字符串，“12212321”填充为“#1#2#2#1#2#3#2#1#”，使字符串长度为奇数
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append("#");
            stringBuilder.append(str.charAt(i));
        }
        stringBuilder.append("#");

        int[] p = new int[stringBuilder.length()];
        //扫描边界
        int mx = 0;
        //取得边界的中心点
        int id = 0;
        char[] arrayStr = stringBuilder.toString().toCharArray();

        for (int i = 1; i < arrayStr.length; i++) {
            if (mx > i) {
                p[i] = Main.Min(mx - i, p[2*id - i]);
            }
            else p[i] = 1;

            //从该中心点的边界处继续扩展
            //数组越界时，代表不能继续比对下去，所以捕获之后不做任何处理
            try {
                while ((arrayStr[i - p[i]] == arrayStr[i + p[i]])){
                    p[i]++;
                }
            } catch (Exception e) {
            }

            //更新扫描边界和中心点
            if (i + p[i] > mx){
                mx = i + p[i];
                id = i;
            }
        }
        return p;
    }

    //最小值
    public static int Min(int a, int b){
        if (a > b)  return b;
        else    return a;
    }
}
