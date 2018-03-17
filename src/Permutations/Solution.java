package Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bqh on 2018/3/17.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<>();
        }

        List<List<Integer>> pre = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(nums[0]);
        pre.add(init);
        for (int i = 1; i < nums.length; i++) {
            //要插入的数
            int temp = nums[i];
            List<List<Integer>> now = new ArrayList<>();
            //遍历现有数组
            for (int j = 0; j < pre.size(); j++) {
                List<Integer> list = pre.get(j);
                int size = list.size();
                //不同的位置增加一位
                for (int k = 0; k <= size; k++) {
                    List<Integer> addList = new ArrayList<>(list);
                    addList.add(k, temp);
                    now.add(addList);
                }
            }
            pre = now;
        }

        return pre;
    }
}
