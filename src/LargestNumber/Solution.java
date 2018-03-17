package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bqh on 2018/3/17.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        Integer[] x = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            x[i] = nums[i];
        }

        Arrays.sort(x, new Comparator<Integer>(){
            @Override
            public int compare(Integer arg0, Integer arg1){
                String temp1 = arg0.toString()+arg1.toString();
                String temp2 = arg1.toString()+arg0.toString();
                return Long.valueOf(temp1)>Long.valueOf(temp2)?-1:1;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        if (x[0] == 0){
            return "0";
        }
        for (int i = 0; i < x.length; i++) {
            stringBuilder.append(x[i]);
        }
        return stringBuilder.toString();
    }
}
