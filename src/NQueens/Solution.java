package NQueens;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by bqh on 2018/3/23.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList<>();
        int[] column = new int[n];
        queenSolution(column, 0, lists);
        return lists;
    }

    public static void queenSolution(int[] column, int col, List<List<String>> lists){
        //得到结果
        if (col == column.length){
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < column.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < column.length; j++) {
                    if (column[i] == j){
                        stringBuilder.append('Q');
                    }else
                        stringBuilder.append('.');
                }
                temp.add(stringBuilder.toString());
            }
            lists.add(temp);
            return;
        }
        for (int i = 0; i < column.length; i++) {
            column[col] = i;
            if (check(column, col)){
                queenSolution(column, col+1, lists);
            }
        }
    }

    //四种情况，同一行、同一列、正斜向，反斜向
    public static boolean check(int colume[], int col){
        for (int i = 0; i < col; i++) {
            if (colume[i] == colume[col] ||
                    Math.abs(colume[i] - colume[col]) == col - i){
                return false;
            }
        }
        return true;
    }
}
