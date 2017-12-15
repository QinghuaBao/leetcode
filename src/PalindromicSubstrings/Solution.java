package PalindromicSubstrings;

/**
 * Created by bqh on 2017/8/7.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            int start = i-1;
            int end = i+1;
            while (start >= 0 && end < s.length()){
                if (s.charAt(start) == s.charAt(end)){
                    count++;
                    start--;
                    end++;
                }else break;
            }

            start = i-1;
            end = i;
            while (start >= 0 && end < s.length()){
                if (s.charAt(start) == s.charAt(end)){
                    count++;
                    start--;
                    end++;
                }else break;
            }
        }
        return count+s.length();
    }

}
