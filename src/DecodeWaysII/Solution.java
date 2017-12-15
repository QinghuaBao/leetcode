package DecodeWaysII;

/**
 * Created by bqh on 2017/8/9.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("*1*1*0"));
    }
    public int numDecodings(String s) {
        if (s.length() == 0 || s == null || s.charAt(0) == '0'){
            return 0;
        }

        int[] num = new int[s.length()+1];
        num[0] = 1;
        if (s.charAt(0) == '*'){
            num[1] = 9;
        }else
            num[1] = 1;
        for (int i = 2; i < s.length()+1; i++) {
            num[i] = 0;
            if (s.charAt(i-1) == '*'){
                num[i] += num[i-1]*9;
                if (s.charAt(i-2) == '1'){
                    num[i] += num[i-2]*10;
                }
                if (s.charAt(i-2) == '2'){
                    num[i] += num[i-2]*6;
                }
                if (s.charAt(i-2) == '*'){
                    num[i] += num[i-2]*16;
                }
            }else {
                num[i] += num[i-1];
                if (s.charAt(i-2) == '*'){
                    if (s.charAt(i-1) <= '6'){
                        num[i] += num[i-2]*2;
                    }else num[i] += num[i-2];
                }
                if (s.charAt(i-2) == '1'){
                    num[i] += num[i-2];
                }
                if (s.charAt(i-2) == 2 && s.charAt(i-2) <= '6'){
                    num[i] += num[i-2];
                }
            }
        }
        return num[s.length()];
    }
}
