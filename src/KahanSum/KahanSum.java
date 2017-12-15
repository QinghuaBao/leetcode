package KahanSum;

import java.util.Arrays;

/**
 * Created by bqh on 2017/8/1.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class KahanSum {
//    public float c = 0.0f;

    public static void main(String[] args) {
        float f = 0.1f;
        float[] arg = new float[4000000];
        Arrays.fill(arg, 0.1f);
        float sum = 0;
        KahanSum kahanSum = new KahanSum();
        for(int i = 0; i < 4000000; i++)
        {
//            sum += f;
//            sum = kahanSum.KahanSumTwo(sum, f);
//            System.out.println(sum);
        }
        System.out.println(sum);
        float xx = kahanSum.KahanSum(arg);
        System.out.println(xx);
    }

    float c = 0.0f;
    private float KahanSum(float[] args){

//        var sum = 0.0
//        var c = 0.0                 // A running compensation for lost low-order bits.
//        for i = 1 to input.length do
//            var y = input[i] - c    // So far, so good: c is zero.
//            var t = sum + y         // Alas, sum is big, y small, so low-order digits of y are lost.
//            c = (t - sum) - y       // (t - sum) cancels the high-order part of y; subtracting y recovers negative (low part of y)
//            sum = t                 // Algebraically, c should always be zero. Beware overly-aggressive optimizing compilers!
//        next i                      // Next time around, the lost low part will be added to y in a fresh attempt.
//        return sum
        float sum = 0.0f;
        for (float temp : args) {
            float y = temp - c;
            float t = sum + y;
            c = (t - sum) - y;
            sum = t;
        }
        return sum;
    }

    public float KahanSumTwo(float one, float two){
        float sum = 0.0f;
//        float c = 0.0f;
        float[] args = new float[]{one, two};
        for (float temp : args) {
            float y = temp - c;
            float t = sum + y;
            c = (t - sum) - y;
            sum = t;
        }
        return sum;
    }
}
