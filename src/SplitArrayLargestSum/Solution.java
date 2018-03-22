package SplitArrayLargestSum;

/**
 * Created by bqh on 2018/3/22.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(splitArray(nums, 2));
    }
    public static int splitArray(int[] nums, int m) {
        if (nums.length == 0 || nums.length < m){
            return 0;
        }
        //剪枝
        if (nums.length == 1){
            return nums[0];
        }
        int low = nums[0];
        int high = nums[0];
        for (int i = 1; i < nums.length; i++) {
            high = high + nums[i];
            low = Math.max(low, nums[i]);
        }
        //剪枝
        if (nums.length == m){
            return low;
        }
        if (m == 1){
            return high;
        }

        while (low < high){
            int mid = (low + high)/2;
            int temp = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                temp += nums[i];
                if (temp > mid){
                    temp = nums[i];
                    count++;
                }
            }
            count++;
            if (count > m){
                low = mid + 1;
            }else
                high = mid;
        }
        return low;
    }
}