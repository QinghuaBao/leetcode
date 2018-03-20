package MinimumPathSum;

/**
 * Created by bqh on 2018/3/19.
 * <p>
 * E-mail:M201672845@hust.edu.cn
 */
public class Solution {

    public static void main(String[] args) {
        int[] line1 = {1,3,1};
        int[] line2 = {1,5,1};
        int[] line3 = {4,2,1};
        int[][] grid = new int[3][];
        grid[0] = line1;
        grid[1] = line2;
        grid[2] = line3;
        System.out.println(minPathSumTemp(grid));

    }

    public static int minPathSumTemp(int[][] grid) {
        int width = grid[0].length;

        int[] d = new int[width];

        for(int i=0;i<grid.length;i++){
            int[] row =grid[i];
            for(int j = 0 ;j<width;j++){

                int preMin = 0;
                if(j>0){
                    if(i==0){
                        preMin = d[j-1];
                    }else
                        preMin = d[j]<d[j-1]?d[j]:d[j-1];

                }
                d[j] = preMin +row[j];
            }
        }

        return d[width-1];
    }

    public static int minPathSum(int[][] grid) {
        int[][] help = new int[grid.length][];
        
        if (grid.length == 0){
            return 0;
        }
        if (grid[0].length == 0){
            return 0;
        }
        int maxj = grid[0].length;
        help[0] = new int[maxj];
        help[0][0] = grid[0][0];
        for (int j = 1; j < maxj; j++) {
            help[0][j] = help[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            help[i] = new int[maxj];
            help[i][0] = help[i-1][0] + grid[i][0];
            for (int j = 1; j < maxj; j++) {
               int min = help[i][j-1] < help[i-1][j] ? help[i][j-1]:help[i-1][j];
               help[i][j] = min + grid[i][j];
            }
        }
        return help[grid.length-1][maxj-1];
    }

    public static int recursionMinPathSum(int[][] grid, int i, int j, int maxj){
        //到达终点
        if (i == grid.length-1 && j == maxj-1){
            return grid[i][j];
        }
        //到达最下边
        if (i == grid.length-1){
            return recursionMinPathSum(grid, i, j+1, maxj)+grid[i][j];
        }
        //到达最右边
        if (j == maxj-1){
            return recursionMinPathSum(grid, i+1, j, maxj)+grid[i][j];
        }
        int right = recursionMinPathSum(grid, i+1, j, maxj)+grid[i][j];
        int  down = recursionMinPathSum(grid, i, j+1, maxj)+grid[i][j];
        //System.out.println(right > down ? down:right);
        return right > down ? down:right;
    }
}
