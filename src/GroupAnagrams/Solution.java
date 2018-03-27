package GroupAnagrams;

import javafx.scene.paint.Material;
import org.w3c.dom.ranges.Range;

import java.util.*;

/**
 * Created by bqh on 2018/3/26.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strings));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        //分类
        for (int i = 0; i < strs.length; i++) {
            int hash = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                hash += strs[i].charAt(j)*strs[i].charAt(j);
            }
            if (map.containsKey(hash)){
                map.get(hash).add(strs[i]);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(hash, temp);
            }
        }

        List<List<String>> externListSum = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()){
            if (entry.getValue().isEmpty()){
                continue;
            }
            List<String> equallist = new ArrayList<>();
            List<String> externlist = new ArrayList<>();

            String demo = entry.getValue().get(0);
            equallist.add(demo);
            for (int i = 1; i < entry.getValue().size(); i++) {
                if (isEqual(demo, entry.getValue().get(i))){
                    equallist.add(entry.getValue().get(i));
                }else externlist.add(entry.getValue().get(i));
            }
            if (!externlist.isEmpty()){
                externListSum.add(externlist);
            }

            lists.add(equallist);
        }

        for (int i = 0; i < externListSum.size(); i++) {
            List<String> tempList = externListSum.get(i);
            Map<String, List<String>> tempMap = new HashMap<>();
            for (int j = 0; j < tempList.size(); j++) {
                char[] strChar = tempList.get(j).toCharArray();
                Arrays.sort(strChar);
                String sortStr = String.valueOf(strChar);
                if (tempMap.containsKey(sortStr)){
                    tempMap.get(sortStr).add(tempList.get(j));
                }else {
                    List<String> xx = new ArrayList<>();
                    xx.add(tempList.get(j));
                    tempMap.put(sortStr, xx);
                }
            }

            for (List<String> li : tempMap.values()) {
                Collections.sort(li);
                lists.add(li);
            }
        }

        return lists;
    }

    public static boolean isEqual(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        int[] ascallStr1 = new int[128];
        int[] ascallStr2 = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            ascallStr1[str1.charAt(i)]++;
            ascallStr2[str2.charAt(i)]++;
        }
        for (int i = 0; i < ascallStr1.length; i++) {
            if (ascallStr1[i] != ascallStr2[i]){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> xgroupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        //分类
//         for (int i = 0; i < strs.length; i++) {
//             int hash = 0;
//             for (int j = 0; j < strs[i].length(); j++) {
//                 hash += strs[i].charAt(j)*strs[i].charAt(j);
//             }
//             if (map.containsKey(hash)){
//                 map.get(hash).add(strs[i]);
//             }else{
//                 List<String> temp = new ArrayList<>();
//                 temp.add(strs[i]);
//                 map.put(hash, temp);
//             }
//         }

//         List<List<String>> externListSum = new ArrayList<>();
//         for (Map.Entry<Integer, List<String>> entry : map.entrySet()){
//             if (entry.getValue().isEmpty()){
//                 continue;
//             }
//             List<String> equallist = new ArrayList<>();
//             List<String> externlist = new ArrayList<>();

//             String demo = entry.getValue().get(0);
//             equallist.add(demo);
//             for (int i = 1; i < entry.getValue().size(); i++) {
//                 if (isEqual(demo, entry.getValue().get(i))){
//                     equallist.add(entry.getValue().get(i));
//                 }else externlist.add(entry.getValue().get(i));
//             }
//             if (!externlist.isEmpty()){
//                 externListSum.add(externlist);
//             }

//             lists.add(equallist);
//         }

        // for (int i = 0; i < externListSum.size(); i++) {
        //     List<String> tempList = externListSum.get(i);
             Map<String, List<String>> tempMap = new HashMap<>();
        for (int j = 0; j < strs.length; j++) {
            char[] strChar = strs[j].toCharArray();
            Arrays.sort(strChar);
            String sortStr = String.valueOf(strChar);
            if (tempMap.containsKey(sortStr)){
                tempMap.get(sortStr).add(strs[j]);
            }else {
                List<String> xx = new ArrayList<>();
                xx.add(strs[j]);
                tempMap.put(sortStr, xx);
            }
            // }
        }
        for (List<String> li : tempMap.values()) {
            lists.add(li);
        }

        return lists;
    }
}
     