package nowcoder;

/**
 * @author lei.X
 * @date 2020/4/19
 */
public class selectPresent {

    public static int selectPresent(int[][] presentVolumn) {
        // write code here
        int row = presentVolumn.length;
        int col = presentVolumn[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = presentVolumn[0][0];
        for (int i=1;i<row;i++){
            dp[i][0] = dp[i-1][0]+presentVolumn[i][0];
        }
        for (int i=1;i<col;i++){
            dp[0][i]=dp[0][i-1]+presentVolumn[0][i];
        }

        for (int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+presentVolumn[i][j];
            }
        }


        return dp[row-1][col-1];
    }

    public static void main(String[] args) {

        int[][] presentVolumn = new int[][]{
                {1,2,3},
                {2,3,4}
        };

        System.out.println(selectPresent(presentVolumn));
    }

}
