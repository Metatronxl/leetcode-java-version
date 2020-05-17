package dynamicprogramming;

/**
 * @author lei.X
 * @date 2019/11/14
 */
public class maxCoin312 {


    public int maxCoins(int[] nums) {

        int len = nums.length;

        int[] newNum = new int[len+2];
        newNum[0] = 1;
        newNum[len+1] = 1;
        for (int i=0;i<len;i++){
            newNum[i+1] = nums[i];
        }
        int[][] dp = new int[len+2][len+2];

        for(int c=1;c<=len;c++){
            for(int i=1;i+c<=len;i++){
                int j = i+c;
                for(int k=i;k<=j;k++){
                    dp[i][j] = Math.max(dp[i][j],dp[i][k-1]+dp[k+1][j]+ newNum[i-1]*newNum[k]*newNum[j+1]);
                }
            }
        }

        return dp[1][len];


    }


    public static void main(String[] args) {

        maxCoin312 test = new maxCoin312();
        int[] nums = new int[]{3,1,5,8};
        System.out.println(test.maxCoins(nums));

    }
}
