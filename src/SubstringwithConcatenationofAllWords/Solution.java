package SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bqh on 2018/3/14.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        String s= "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int[] vpw = new int[s.length()];
        //Arrays.fill(vpw, -1);
        HashMap<String, Integer> wordMaps = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (wordMaps.containsKey(words[i])){
                int temp = wordMaps.get(words[i]);
                wordMaps.put(words[i], ++temp);
            }else wordMaps.put(words[i], 1);

            int pos = 0;
            while (pos != -1){
                pos = s.indexOf(words[i], pos);
                if (pos == -1){
                    break;
                }
                vpw[pos] = i+1;
                pos++;
            }
        }


        int len = words[0].length();
        for (int i = 0; i <= s.length()-words.length*len; i++) {
            if (vpw[i] == 0){
                continue;
            }
            int[] vb = new int[words.length]; //每个单词出现了几次
            int count = 0; //所有单词总出现次数
            for (int j = i; j < s.length(); j+=len) {
                if (vpw[j] == 0){
                    break;
                }
                vb[vpw[j]-1]++;

                //超出大小立马跳出
                if (vb[vpw[j]-1] > wordMaps.get(words[vpw[j]-1])){
                    break;
                }else count++;

                if (count == words.length){
                    break;
                }
            }
            if (count == words.length){
                list.add(i);
            }
        }

        return list;
    }



}
