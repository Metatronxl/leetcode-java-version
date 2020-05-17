package BackTrackAndRecursive;

/**
 * @author lei.X
 * @date 2019/12/19
 *
 * minN 记录数组中遇到的最小值
 * profit 记录遍历过程中可能存在的最大利润
 *
 * Space : O(1)
 * Time : O(n)
 */
public class MaxProfit121 {

    public int maxProfit(int[] prices) {

        int minN = Integer.MAX_VALUE;
        int profit = 0;
        for (int i=0;i<prices.length;i++){
            int num = prices[i];
            minN = (minN > num) ? num : minN;
            profit = (num-minN)>profit ? num-minN : profit;
        }

        return profit;
    }


    public static int backUp(int[] prices){

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i=0;i<prices.length;i++){

            if (prices[i]<min){
                min = prices[i];
            }

            profit = prices[i]-min>profit ? prices[i]-min:profit;
        }

        return profit;
    }


    /**
     * 不限制交易次数
     * @param prices
     * @return
     */
    public static int backUp2(int[] prices){

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i=1;i<prices.length;i++){

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];

    }

    /**
     * 只能交易一次
     * @param prices
     * @return
     */
    public static int backUp3(int[] prices){

        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i=1;i<prices.length;i++){

            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[prices.length-1][0];


    }


    /**
     * 只能交易K次
     *
     * @param
     */
    public static int backUp4(int[] prices,int max_k){

        int n = prices.length;

        if (max_k > n / 2)   // 如果max_k 大于n/2，那么k次的约束便失去了效果
            return backUp2(prices);

        int[][][] dp = new int[n][max_k + 1][2];

        for (int i = 0; i < n; i++)
            for (int k = 1; k <= max_k; k++) {
                if (i - 1 == -1) { /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                // 空档期不选择购入股票 or 之前买入的股票出售
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                // 继续持有当前的股票 or  选择买入股票
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }

        return dp[n - 1][max_k][0];

    }

    /**
     * 交易完成一次后需要有休息时间
     * @param prices
     * @return
     */
    public static int backUp5(int[] prices){

        int n = prices.length;

        int[][] dp  = new int[n][2];

        for (int i=0;i<n;i++){
            if (i==0){  // base case

                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            if (i==1){ // base case
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
                continue;
            }
            // 不考虑买入股票 or 将之前的股票给出售
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            // 继续持有当前股票  or  从i-2之前的状态(需要有一天休息日)开始买入股票
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }

        return dp[n-1][0];
    }

    /**
     * 每次交易需要手续费
     * @param prices
     * @param fee
     * @return
     */
    public static int backUp6(int[] prices, int fee){

        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i=0;i<n;i++){

            if (i==0){  // base case

                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            // 每次出手时缴纳手续费
            //  选择不购买股票  or   出售之前购买的股票 and 缴纳手续费
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            // 继续持有当前的股票   or   选择购买股票
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }

        return dp[n-1][0];
    }




    public static void main(String[] args) {

        int[] test = new int[]{1,9,4,2,13};
        System.out.println(backUp5(test));


    }
}
