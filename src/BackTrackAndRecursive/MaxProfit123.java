package BackTrackAndRecursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/12/25
 */
public class MaxProfit123 {

    public int maxProfit(int[] prices) {

        if (prices.length==0 || prices.length==1) return 0;
        // 如果是个递增数组，只需要卖出一次
        boolean asc = true;
        for(int i=0;i<prices.length-1;i++){
            if (prices[i+1]<prices[i]){
                asc =false;
            }
        }
        if (asc){
            return prices[prices.length-1] - prices[0];
        }
        // 如果是个递减数组，不能交易，直接返回0
        boolean dsc = true;
        for (int i=0;i<prices.length-1;i++){
            if (prices[i+1]>prices[i]){
                dsc = false;
            }
        }

        if (dsc){
            return 0;
        }

        /**
         * 如果既不是递增or递减数组
         * 则新建2个数组，一个以左边开始，到i为止产生一次交易可以获得的利润
         * 一个以右边作为结束，从i开始产生一次交易可以获得的利润
         * 最后通过动态规划获得最佳2次交易能产生的利润（因为不是asc和dsc数组，所以必然多次交易会有更多收益）
         *
         */

        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];

        int buy = prices[0];
        int leftSubProfit = 0;
        for (int i=1;i<prices.length;i++){
            int temp = prices[i]-buy;
            if (temp>leftSubProfit){   // 存在更大的利润
                leftSubProfit = temp;
            }

            if (buy > prices[i]){
                // 当前价格比买入价格更低，可能存在更大的利润
                buy = prices[i];
            }
            leftProfit[i] = leftSubProfit;
        }

        int sell = prices[prices.length-1];
        int rightSubProfit = 0;
        for(int i=prices.length-1;i>=0;i--){
            int temp = sell-prices[i];
            if (temp > rightSubProfit){
                rightSubProfit = temp;
            }
            if (sell < prices[i]){
                sell = prices[i];
            }
            rightProfit[i] = rightSubProfit;
        }

        System.out.println(leftProfit);
        System.out.println(rightProfit);

        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            maxProfit = Math.max(leftProfit[i]+rightProfit[i+1],maxProfit);
        }

        return maxProfit;

    }


    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        MaxProfit123 test = new MaxProfit123();
        System.out.println(test.maxProfit(prices));
    }

}


/**
 *
 *
 * public class Solution {
 public int maxProfit(int[] prices) {

 int firstBuy = Integer.MIN_VALUE;
 int firstSell = 0;
 int secondBuy = Integer.MIN_VALUE;
 int secondSell = 0;

 for(int curPrice:prices){
 if(firstBuy< -curPrice) firstBuy = -curPrice;
 if(firstSell < firstBuy+curPrice) firstSell = firstBuy+curPrice;
 if(secondBuy < firstSell - curPrice) secondBuy = firstSell-curPrice;
 if(secondSell < secondBuy+curPrice) secondSell = secondBuy+curPrice;
 }

 return secondSell;
 }

 }
 *
 */
