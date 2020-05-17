package BackTrackAndRecursive;

/**
 * @author lei.X
 * @date 2019/12/27
 */
public class MaxProfit309 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len==0) return 0;

        int[] buy = new int[len];
        int[] sell = new int[len];
        int[] cool = new int[len];

        buy[0] = -prices[0];

        for (int i=1;i<len;i++){
            // 第一项表示前一天购买，今天卖出，第二项表示今天不购买，即cool
            sell[i] = Math.max(buy[i-1]+prices[i],sell[i-1]);
            // 第一项表示今天购买，第二项表示今天不买
            buy[i] = Math.max(cool[i-1]-prices[i],buy[i-1]);
            // 第一项表示今天是第一个cool日，第二项表示今天是第二个cool日
            cool[i] = Math.max(sell[i-1],cool[i-1]);
        }

        return sell[len-1];
    }


    public static void main(String[] args) {

    }
}
