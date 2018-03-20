package LargestRectangleinHistogram;

import java.util.Stack;

/**
 * Created by bqh on 2018/3/20.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        int[] heights = {1,1};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[i] >= stack.peek()){
                stack.push(heights[i]);
            }else {
                int count = 0;
                while (!stack.empty() && stack.peek() > heights[i]){
                    count++;
                    int temp = stack.pop();
                    res = Math.max(temp*count, res);
                }
                while (count > 0){
                    stack.push(heights[i]);
                    count--;
                }
                stack.push(heights[i]);
            }
        }
        int i = 0;
        while (!stack.empty()){
            res = Math.max(res, stack.pop()*(i+1));
            i++;
        }

        return res;
    }
}
