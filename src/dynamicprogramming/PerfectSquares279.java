package dynamicprogramming;

/**
 * @author lei.X
 */
public class PerfectSquares279 {

    public int numSquares(int n) {
          int[] dp = new int[n+1];
          for(int i=0;i<n+1;i++){
              dp[i] = Integer.MAX_VALUE;
          }
          dp[0] =0;
          for(int i=0;i<=n;i++){
              for(int j=1; i+j*j<=n;j++){
                  dp[i+j*j] = Math.min(dp[i]+1,dp[i+j*j]);
              }
          }

          return dp[n];
    }


}
