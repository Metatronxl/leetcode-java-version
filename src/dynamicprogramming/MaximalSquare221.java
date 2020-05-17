package dynamicprogramming;

/**
 * @author lei.X
 */
public class MaximalSquare221 {

    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        int column = rows > 0 ? matrix[0].length:0;

        int[][] dp = new int[rows+1][column+1];
        int maxLen =0;

        for(int i=1;i<=rows;i++){
            for(int j=1;j<=column;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
            }
        }

        return maxLen*maxLen;
    }


}
