package dynamicprogramming;

/**
 * @author lei.X
 * @date 2020/3/27
 */
public class MaxPalindromeSequence {

    public int longestPalindromeSubseq(String s){

        char[] sub = s.toCharArray();
        int len = sub.length;
        int[][] dp = new int[len][len];

        for (int i=0;i<len;i++){
            dp[i][i] = 1;
        }

        for (int i=len-1;i>0;i--){
            for (int j=i;j<len-1;j++){

                if (sub[i] == sub[j]){
                    dp[i][j] = dp[i-1][j+1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
                }
            }
        }


        return dp[0][len-1];
    }





    public static void main(String[] args) {

    }
}
