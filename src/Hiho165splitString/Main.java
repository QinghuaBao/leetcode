package Hiho165splitString;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by bqh on 2017/8/30.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] save = new int[26];
        Arrays.fill(save, 0);
        for (int i = 0; i < str.length(); i++) {
            save[str.charAt(i)- 'a']++;
        }

        StringBuilder reset = new StringBuilder();
        int loc;
        for (int i = 0; i < 26;) {
            if (save[i] != 0 && (i+'a') != reset.charAt(reset.length())){
                reset.append(i+'a');
                loc = i;
                i = 0;
            }else
                i++;
        }

        for (int i = 0; i < save[loc]; i++) {

        }
    }

    private void insert(StringBuilder stringBuilder, char x, int count){
        for (int i = stringBuilder.length()-1; i >= 0 && count != 0 ; i--) {

        }
    }
}
